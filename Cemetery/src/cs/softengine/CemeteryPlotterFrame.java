package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main GUI window for Cemetery Plotter
 */
public class CemeteryPlotterFrame extends CemeteryPlotter {
    private JFrame frame; // this frame

    // CemeteryPlotterFrame elements, available to sub-classes
    CemeteryPlotterMenu cemeteryPlotterMenu; // the menu bar object
    CemeteryPlotterSections cemeteryPlotterSections; // the list of cemetery sections
    CemeteryPlotterPlots cemeteryPlotterPlots; // the list of plots in the currently selected section(s)
    CemeteryPlotterPlot cemeteryPlotterPlot; // the currently selected plot's info
    CemeteryPlotterInterredPerson cemeteryPlotterInterredPerson; // the currently selected plot's interred person
    CemeteryPlotterContact cemeteryPlotterContact; // the currently selected plot's contact
    CemeteryPlotterPeople cemeteryPlotterPeople; // the list of people in the currently selected section(s)
    CemeteryPlotterMap cemeteryPlotterMap; // the map of the cemetery

    /**
     * Construct the CemeteryPlotterFrame by scheduling a job for the event-dispatching thread that
     * creates and shows the application's GUI
     */
    public CemeteryPlotterFrame() {
        // load GUI in separate thread
        SwingUtilities.invokeLater(this::createAndShowGUI);
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
        // set the title
        String frameTitle = "Cemetery Plotter";

        if (workingFile != null)
            frameTitle += " (" + workingFile.getName() + ")";

        frame = new JFrame(frameTitle);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowEventHandler());

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
        cemeteryPlotterContact = new CemeteryPlotterContact();
        cemeteryPlotterPeople = new CemeteryPlotterPeople();
        cemeteryPlotterMap = new CemeteryPlotterMap();

        // add content panels to panes
        // left panel
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(cemeteryPlotterSections.getSectionsPanel());
        leftPanel.add(cemeteryPlotterPlots.getPlotsPanel());

        // center top panel
        centerTopPanel.setLayout(new BoxLayout(centerTopPanel, BoxLayout.LINE_AXIS));
        centerTopPanel.add(cemeteryPlotterPlot.getPlotPanel());
        centerTopPanel.add(cemeteryPlotterInterredPerson.getInterredPanel());
        centerTopPanel.add(cemeteryPlotterContact.getContactPanel());

        // center bottom panel
        centerBottomPanel.add(cemeteryPlotterMap.getMapPanel(), BorderLayout.CENTER);

        // center combined panel
        centerPanel.setTopComponent(centerTopPanel);
        centerPanel.setBottomComponent(centerBottomPanel);

        // right panel
        rightPanel.add(cemeteryPlotterPeople.getPeoplePanel(), BorderLayout.CENTER);

        // add layout panes to frame
        frame.add(leftPanel, BorderLayout.LINE_START);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.LINE_END);

        // display the window.
        frame.pack();
        frame.setVisible(true);

        // get data from cemetery and populate GUI with it
        cemeteryPlotterSections.getSectionsData();
        // disabled till we have something to put there
        //SwingUtilities.invokeLater(() -> cemeteryPlotterMap.getMapData());
    }

    /**
     * Get the frame
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Get data from cemetery for a plot, interred person, and contact
     * @param plot of the cemetery
     */
    public void getData(Plot plot) {
        plot = cemetery.getPlots().get(cemetery.getPlots().indexOf(plot));

        cemeteryPlotterPlot.getPlotData(plot);
        cemeteryPlotterInterredPerson.getInterredData(plot);
        cemeteryPlotterContact.getContactData(plot);
    }

    /**
     * Clear all plot, interred person, and contact data from the GUI
     */
    public void clearData() {
        cemeteryPlotterPlot.clearPlotData();
        cemeteryPlotterInterredPerson.clearInterredData();
        cemeteryPlotterContact.clearContactData();
        cemeteryPlotterMap.clearMapData();
    }

    /**
     * Handles window events for this frame
     */
    class WindowEventHandler extends WindowAdapter {

        /**
         * Intercepts the window closing signal and checks for unsaved changes.
         * @param we window event
         */
        public void windowClosing(WindowEvent we) {
            int exit = -1;

            if (cemetery.isModified()) {
                exit = JOptionPane.showOptionDialog(frame,
                        "You have changes that are not saved.\nAre you sure you want to quit?",
                        "Quit?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        null,
                        null);
            } else { // quit
                cemeteryPlotterFrame.getFrame().dispose();
            }

            if (exit == JOptionPane.YES_OPTION) { // quit
                cemeteryPlotterFrame.getFrame().dispose();
            } // else, do nothing
        }
    }
}