package cs.softengine;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main GUI window for Cemetery Plotter
 */
public class CemeteryPlotterFrame {
    // class variables go here

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
        JFrame frame = new JFrame("Cemetery Plotter v0.0.2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create and set up the menu bar
        CemeteryPlotterMenu cemeteryPlotterMenu = new CemeteryPlotterMenu();
        frame.setJMenuBar(cemeteryPlotterMenu.getMenuBar());

        // create empty panes for layout
        JPanel leftPanel = new JPanel(true);
        JPanel centerPanel = new JPanel(true);
        JPanel rightPanel = new JPanel(new BorderLayout(), true);

        // create and set up content panels
        CemeteryPlotterSections cemeteryPlotterSections = new CemeteryPlotterSections();
        CemeteryPlotterPlots cemeteryPlotterPlots = new CemeteryPlotterPlots();
        CemeteryPlotterPlot cemeteryPlotterPlot = new CemeteryPlotterPlot();
        CemeteryPlotterInterredPerson cemeteryPlotterInterredPerson = new CemeteryPlotterInterredPerson();
        CemeteryPlotterOwner cemeteryPlotterOwner = new CemeteryPlotterOwner();
        CemeteryPlotterPeople cemeteryPlotterPeople = new CemeteryPlotterPeople();

        // add content panels to panes
        // left panel
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(cemeteryPlotterSections.getPanel());
        leftPanel.add(cemeteryPlotterPlots.getPanel());

        // center panel
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
        centerPanel.add(cemeteryPlotterPlot.getPanel());
        centerPanel.add(cemeteryPlotterInterredPerson.getPanel());
        centerPanel.add(cemeteryPlotterOwner.getPanel());

        // right panel
        rightPanel.add(cemeteryPlotterPeople.getPanel(), BorderLayout.CENTER);

        // add layout panes to frame
        frame.add(leftPanel, BorderLayout.LINE_START);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.LINE_END);

        // display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Schedule a job for the event-dispatching thread
     * creating and showing the applications GUI
     * @param args ignored
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}