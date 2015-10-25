package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main GUI window for Cemetery Plotter
 */
public class CemeteryPlotterFrame {
    // class variables go here

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

        // add the text area to the content pane
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    /**
     * Create the GUI and show it. Invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // get the good GUI elements
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JFrame.setDefaultLookAndFeelDecorated(true);
        }

        // create and set up the window
        JFrame frame = new JFrame("Cemetery Plotter v0.0.1");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create and set up the content pane
        CemeteryPlotterFrame cpf = new CemeteryPlotterFrame();
        CemeteryPlotterMenu menu = new CemeteryPlotterMenu();
        frame.setJMenuBar(menu.getMenuBar());
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