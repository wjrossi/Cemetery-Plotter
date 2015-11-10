package cs.softengine;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
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
        JMenuItem fileOpen, fileSave, fileSaveAs, fileQuit;

        // create the entire menu bar
        menuBar = new JMenuBar();

        // add a file menu on the menu bar
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);

        // add items to the file menu
        // open (meta+o)
        fileOpen = new JMenuItem("Open");
        fileOpen.setMnemonic(KeyEvent.VK_O);
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.META_MASK));
        fileOpen.addActionListener(this);
        menuFile.add(fileOpen);

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
            case "open": // open a file
                File file = openFile();

                if (file != null) {
                    try {
                        workingFile = file; // set the working file to the selected file
                        cemetery.load(file); // open the file using the cemetery object's load(file) method

                        // reload gui elements
                        cemeteryPlotterFrame.clearData();
                        cemeteryPlotterFrame.cemeteryPlotterSections.getSectionsData();
                    } catch (IOException ex) { // TODO show error dialogs
                        // major error, how do we handle it??
                        System.err.println("Unable to read input file.");
                        ex.printStackTrace();
                    }
                } // else do nothing
                break;
            case "save": // save a file
                try {
                    cemetery.save(workingFile); // save the working file
                    cemetery.setModified(false);
                } catch (IOException ex) { // TODO show error dialogs
                    // major error, how do we handle it
                    System.err.println("Unable to save file.");
                    ex.printStackTrace();
                }
                break;
            case "save as":  // save as a user chosen file
                file = saveAsFile();

                if (file != null) { // a file was selected
                    try {
                        workingFile = file; // set the working file to the selected file
                        cemetery.save(file); // open the file using the cemetery object's load(file) method
                        cemetery.setModified(false);
                        cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (" + workingFile.getName() + ")");

                    } catch (IOException ex) { // TODO show error dialogs
                        // major error, how do we handle it??
                        System.err.println("Unable to read input file.");
                        ex.printStackTrace();
                    }
                } // else do nothing
                break;
            case "quit":  // quit the program
                WindowEvent we = new WindowEvent(cemeteryPlotterFrame.getFrame(), WindowEvent.WINDOW_CLOSING);
                cemeteryPlotterFrame.getFrame().dispatchEvent(we);
                break;
        }
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

        fileChooser = new JFileChooser(workingFile);
        fileFilter = new FileNameExtensionFilter("Cemetery DB Files", "db");
        fileChooser.setFileFilter(fileFilter);

        result = fileChooser.showOpenDialog(menu.getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (" + workingFile + ")");
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

        fileChooser = new JFileChooser(workingFile);
        fileFilter = new FileNameExtensionFilter("Cemetery DB Files", "db");
        fileChooser.setFileFilter(fileFilter);

        result = fileChooser.showSaveDialog(menu.getParent());

        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            cemeteryPlotterFrame.getFrame().setTitle("Cemetery Plotter (" + workingFile + ")");
        }

        return file;
    }
}
