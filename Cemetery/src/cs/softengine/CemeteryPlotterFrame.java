package cs.softengine;

import javax.swing.*;
import java.awt.*;

/**
 * The main GUI window for Cemetery Plotter
 */
public class CemeteryPlotterFrame {
    // class variables go here

    /**
     * Create the main menu bar
     * @return JMenuBar
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menuFile;
        JMenuItem fileOpen, fileSave, fileSaveAs;

        // create the entire menu bar
        menuBar = new JMenuBar();

        // add a file menu on the menu bar
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        // add items to the file menu
        fileOpen = new JMenuItem("Open");
        menuFile.add(fileOpen);

        menuFile.addSeparator();

        fileSave = new JMenuItem("Save");
        menuFile.add(fileSave);

        fileSaveAs = new JMenuItem("Save As");
        menuFile.add(fileSaveAs);

        return menuBar;
    }

    /**
     * Create main content pane
     * @return container
     */
    public Container createContentPane() { // TODO this is stuff from a demo
        // create the content-pane-to-be
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        // create a scrolled text area
        JTextArea output = new JTextArea(5, 30);
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);

        //Add the text area to the content pane
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    /**
     * Create the GUI and show it. Invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // get the good GUI elements
        JFrame.setDefaultLookAndFeelDecorated(true);

        // create and set up the window
        JFrame frame = new JFrame("Cemetery Plotter v0.0.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create and set up the content pane
        CemeteryPlotterFrame cpf = new CemeteryPlotterFrame();
        frame.setJMenuBar(cpf.createMenuBar());
        frame.setContentPane(cpf.createContentPane());

        // display the window.
        frame.pack();
        //frame.setSize(450, 260);
        frame.setVisible(true);
    }

    /**
     * Schedule a job for the event-dispatching thread
     * creating and showing the applications GUI
     * @param args ignored
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}