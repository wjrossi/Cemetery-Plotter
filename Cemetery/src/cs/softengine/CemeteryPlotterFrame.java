package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main GUI window for Cemetery Plotter
 */
public class CemeteryPlotterFrame extends CemeteryPlotter {
    private JFrame frame;
    private CemeteryPlotterMenu cemeteryPlotterMenu;
    private CemeteryPlotterSections cemeteryPlotterSections;
    private CemeteryPlotterPlots cemeteryPlotterPlots;
    private CemeteryPlotterPlot cemeteryPlotterPlot;
    private CemeteryPlotterInterredPerson cemeteryPlotterInterredPerson;
    private CemeteryPlotterOwner cemeteryPlotterOwner;
    private CemeteryPlotterPeople cemeteryPlotterPeople;
    private CemeteryPlotterMap cemeteryPlotterMap;

    /**
     * Construct the CemeteryPlotterFrame by scheduling a job for the event-dispatching thread that
     * creates and shows the application's GUI
     */
    public CemeteryPlotterFrame() {
        // load GUI in separate thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    /**
     * Create the GUI and show it. Invoked from the event-dispatching thread.
     */
    private void createAndShowGUI() {
        // get the good GUI elements
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JFrame.setDefaultLookAndFeelDecorated(true);
        }

        // create and set up the window
        frame = new JFrame("Cemetery Plotter (" + getWorkingFile() + ")");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // create and set up the menu bar
        cemeteryPlotterMenu = new CemeteryPlotterMenu();
        frame.setJMenuBar(cemeteryPlotterMenu.getMenuBar());

        // create empty panes for layout
        JPanel leftPanel = new JPanel(true);
        JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
        JPanel centerTopPanel = new JPanel(true);
        JPanel centerBottomPanel = new JPanel(new BorderLayout(), true);
        JPanel rightPanel = new JPanel(new BorderLayout(), true);

        // create and set up content panels
        cemeteryPlotterSections = new CemeteryPlotterSections();
        cemeteryPlotterPlots = new CemeteryPlotterPlots();
        cemeteryPlotterPlot = new CemeteryPlotterPlot();
        cemeteryPlotterInterredPerson = new CemeteryPlotterInterredPerson();
        cemeteryPlotterOwner = new CemeteryPlotterOwner();
        cemeteryPlotterPeople = new CemeteryPlotterPeople();
        cemeteryPlotterMap = new CemeteryPlotterMap();

        // add content panels to panes
        // left panel
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(cemeteryPlotterSections.getPanel());
        leftPanel.add(cemeteryPlotterPlots.getPanel());

        // center top panel
        centerTopPanel.setLayout(new BoxLayout(centerTopPanel, BoxLayout.LINE_AXIS));
        centerTopPanel.add(cemeteryPlotterPlot.getPanel());
        centerTopPanel.add(cemeteryPlotterInterredPerson.getPanel());
        centerTopPanel.add(cemeteryPlotterOwner.getPanel());

        // center bottom panel
        centerBottomPanel.add(cemeteryPlotterMap.getPanel(), BorderLayout.CENTER);

        // center combined panel
        centerPanel.setTopComponent(centerTopPanel);
        centerPanel.setBottomComponent(centerBottomPanel);

        // right panel
        rightPanel.add(cemeteryPlotterPeople.getPanel(), BorderLayout.CENTER);

        // add layout panes to frame
        frame.add(leftPanel, BorderLayout.LINE_START);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.LINE_END);

        // display the window.
        frame.pack();
        frame.setVisible(true);

        // load map URL
        /*
        cemeteryPlotterMap.loadMap();
        DISABLED TILL WE NEED IT. SHOULD BE MOVED TO A DIFFERENT METHOD OR THREAD MAYBE?
        LOCKS THINGS UP WHILE IT IS LOADING
        */
    }

    /**
     * Get the frame
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }
}