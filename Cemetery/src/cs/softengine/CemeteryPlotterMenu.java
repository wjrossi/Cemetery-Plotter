package cs.softengine;
import org.parse4j.ParseException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Cemetery Plotter Menu GUI Element
 */
public class CemeteryPlotterMenu extends CemeteryPlotter implements ActionListener {
    private JMenuBar menu;

    /**
     * Constructs a menu bar object
     */
    public CemeteryPlotterMenu() {
        menu = createMenuBar();
    }

    /**
     * Gets menu bar
     * @return menuBar
     */
    public JMenuBar getMenuBar() {
        return menu;
    }

    /**
     * Create the main menu bar
     * @return menuBar
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menuFile;
        JMenuItem fileNew, fileOpen, fileSave, fileSaveAs, fileQuit, fileSaveInCloud, fileOpenFromCloud;

        // create the entire menu bar
        menuBar = new JMenuBar();

        // add a file menu on the menu bar
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);

        // add items to the file menu
        // new (meta+n)
        fileNew = new JMenuItem("New");
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.META_MASK));
        fileNew.addActionListener(this);
        menuFile.add(fileNew);

        menuFile.addSeparator();


        // open (meta+o)
        fileOpen = new JMenuItem("Open");
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
        fileOpen.addActionListener(this);
        menuFile.add(fileOpen);

        // open in cloud
        fileOpenFromCloud = new JMenuItem("Open From Cloud");
        fileOpenFromCloud.addActionListener(this);
        menuFile.add(fileOpenFromCloud);

        menuFile.addSeparator();

        // save (meta+s)
        fileSave = new JMenuItem("Save");
        fileSave.setMnemonic(KeyEvent.VK_S);
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.META_MASK));
        fileSave.addActionListener(this);
        menuFile.add(fileSave);

        // save as (shift+meta+s)
        fileSaveAs = new JMenuItem("Save As");
        fileSaveAs.setMnemonic(KeyEvent.VK_A);
        fileSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK | InputEvent.META_MASK));
        fileSaveAs.addActionListener(this);
        menuFile.add(fileSaveAs);


        // file save in cloud
        fileSaveInCloud = new JMenuItem("Save In Cloud");
        fileSaveInCloud.addActionListener(this);
        menuFile.add(fileSaveInCloud);

        menuFile.addSeparator();

        // quit (meta+q)
        fileQuit = new JMenuItem("Quit");
        fileQuit.setMnemonic(KeyEvent.VK_Q);
        fileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.META_MASK));
        fileQuit.addActionListener(this);

        menuFile.add(fileQuit);

        return menuBar;
    }

    /**
     * Action listener for menu bar
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        String choice;
        JMenuItem source = (JMenuItem) (e.getSource());

        choice = source.getText().toLowerCase();

        switch (choice) {
            case "new": // new file
                newFile();
                break;
            case "open": // open a file
                open();
                break;
            case "open from cloud":
                openFromCloud();
                break;
            case "save": // save a file
                save();
                break;
            case "save as":  // save as a user chosen file
                saveAs();
                break;
            case "save in cloud":
                saveInCloud();
                break;
            case "quit":  // quit the program
                WindowEvent we = new WindowEvent(cemeteryPlotterFrame.getFrame(), WindowEvent.WINDOW_CLOSING);
                cemeteryPlotterFrame.getFrame().dispatchEvent(we);
                break;
        }
    }

    /**
     * Start a new file
     */
    public void newFile() {
        if (cemetery.isModified()) { // unsaved changes?
            int newQuestion = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "You have changes that are not saved.\nAre you sure you want to open a new file?",
                    "Open?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);

            if (newQuestion == JOptionPane.NO_OPTION) {
                return;
            }
        }

        workingFile = null; // set the working file to the selected file
        cemetery = new Cemetery();

        // reload gui elements
        cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (new file)");
        cemeteryPlotterFrame.clearData();
        cemeteryPlotterFrame.cemeteryPlotterSections.getSectionsData();
    }

    /**
     * Open a new file
     */
    public void open() {
        if (cemetery.isModified()) { // unsaved changes?
            int open = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "You have changes that are not saved.\nAre you sure you want to open a different file?",
                    "Open?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);

            if (open == JOptionPane.NO_OPTION) {
                return;
            }
        }

        File file = openFile();

        if (file != null) {
            try {
                workingFile = file; // set the working file to the selected file
                cemetery = new Cemetery();
                cemetery.load(workingFile);

                // reload gui elements
                cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (" + workingFile.getName() + ")");
                cemeteryPlotterFrame.clearData();
                cemeteryPlotterFrame.cemeteryPlotterSections.getSectionsData();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                        "Unable to open file \"" + file.getName() + "\"!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } // else do nothing
    }

    /**
     * Save to current file
     */
    public void save() {
        if (workingFile == null) { // trying to save a new unnamed file
            saveAs();
            return;
        }

        if (cemetery.isModified()) { // unsaved changes?
            int save = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "You are about to overwrite \"" + workingFile.getName() + "\" with new changes.\nAre you sure you want to save?",
                    "Save?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);

            if (save == JOptionPane.NO_OPTION) {
                return;
            }
        }

        try {
            cemetery.save(workingFile); // save the working file
            cemetery.setModified(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                    "Unable to save file \"" + workingFile.getName() + "\"!",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Save as a different file
     */
    public void saveAs() {
        File file = saveAsFile();

        if (file != null) { // a file was selected
            try {
                workingFile = file; // set the working file to the selected file
                cemetery.save(workingFile); // open the file using the cemetery object's load(file) method
                cemetery.setModified(false);
                cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (" + workingFile.getName() + ")");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                        "Unable to save as file \"" + file.getName() + "\"!",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } // else do nothing
    }

    /**
     * Save in cloud
     */
    public void saveInCloud() {
        ParseClient pc = new ParseClient();
        try {
            pc.saveFile(workingFile);
            System.out.println("Saving to cloud...");
        } catch (ParseException e) {
            System.out.println("Exception thrown  :" + e);
        } catch (IOException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

    /**
     * Open From Cloud
     */
    public void openFromCloud() {

    }

    /**
     * Show file chooser dialog to open a cemetery db file
     * @return file
     */
    private File openFile() {
        JFileChooser fileChooser;
        FileNameExtensionFilter fileFilter;
        File file;
        int result;

        file = null;

        fileChooser = new JFileChooser(new File(".").getAbsolutePath());
        fileFilter = new FileNameExtensionFilter("Cemetery DB Files (*.db)", "db");
        fileChooser.addChoosableFileFilter(fileFilter);
        fileChooser.setFileFilter(fileFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        result = fileChooser.showOpenDialog(menu.getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();

            if (!fileFilter.accept(file))
                file = null;
        }

        return file;
    }

    /**
     * Show file chooser dialog to save a cemetery db file
     * @return file
     */
    private File saveAsFile() {
        JFileChooser fileChooser;
        FileNameExtensionFilter fileFilter;
        File file;
        int result;

        file = null;

        fileChooser = new JFileChooser(new File(".").getAbsolutePath());
        fileFilter = new FileNameExtensionFilter("Cemetery DB Files (*.db)", "db");
        fileChooser.addChoosableFileFilter(fileFilter);
        fileChooser.setFileFilter(fileFilter);
        fileChooser.setAcceptAllFileFilterUsed(false);

        result = fileChooser.showSaveDialog(menu.getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();

            if (!fileFilter.accept(file))
                file = null;
        }

        return file;
    }
}
