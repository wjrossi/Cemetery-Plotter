package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Cemetery Plotter Menu GUI Element
 */
public class CemeteryPlotterMenu implements ActionListener, ItemListener {
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
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        System.out.println("Action event detected... Event source: " + source.getText());
    }

    /**
     * Item state listener for menu bar
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
