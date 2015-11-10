package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Content pane for listing of plots belonging to selected section(s)
 */
public class CemeteryPlotterPlots extends CemeteryPlotter implements ActionListener {
    private JPanel plotsPanel;
    private JTextField searchField;
    private DefaultListModel<String> plotsListModel;
    private DefaultListSelectionModel plotsListSelectionModel;
    private JList<String> plotsList;
    private JScrollPane plotsListScrollPane;
    private JButton newPlotButton;
    private JButton deletePlotButton;

    /**
     * Constructs a content pane for listing of plots belonging to selected section(s)
     */
    public CemeteryPlotterPlots() {
        plotsPanel = createPlotsPanel();
    }

    /**
     * Get plots panel
     * @return plotsPanel
     */
    public JPanel getPlotsPanel() {
        return plotsPanel;
    }

    /**
     * Create plots panel
     * @return panel
     */
    private JPanel createPlotsPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Plots");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to main panel

        // create search text field and button
        searchField = new JTextField(8);
        searchField.setToolTipText("View or edit the specified plot.");

        // add search text field and button to search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.add(searchField);

        // add search panel to main panel
        panel.add(searchPanel, BorderLayout.PAGE_START);

        // create list of plots
        plotsListModel = new DefaultListModel<>();
        plotsList = new JList<>(plotsListModel);

        plotsListSelectionModel = (DefaultListSelectionModel) plotsList.getSelectionModel();
        plotsListSelectionModel.addListSelectionListener(new PlotsListSelectionHandler());

        plotsListScrollPane = new JScrollPane(plotsList);
        plotsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        plotsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        plotsList.setLayoutOrientation(JList.VERTICAL);
        plotsList.setPrototypeCellValue("999999");
        plotsList.setToolTipText("Select the plot you wish to view or edit.");

        // create new and delete buttons
        newPlotButton = new JButton("New Plot");
        newPlotButton.setActionCommand("new");
        newPlotButton.addActionListener(this);
        newPlotButton.setToolTipText("Add a new plot and view/edit its information.");

        deletePlotButton = new JButton("Delete Plot");
        deletePlotButton.setActionCommand("delete");
        deletePlotButton.addActionListener(this);
        deletePlotButton.setToolTipText("Permanently delete the selected plot from the cemetery.");

        JPanel plotsButtonsPanel = new JPanel();
        plotsButtonsPanel.setLayout(new BoxLayout(plotsButtonsPanel, BoxLayout.LINE_AXIS));
        plotsButtonsPanel.add(newPlotButton);
        plotsButtonsPanel.add(deletePlotButton);

        // add list to main panel
        panel.add(plotsListScrollPane, BorderLayout.CENTER);
        panel.add(plotsButtonsPanel, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Action listener for plots content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) { // TODO add action listeners and stuff first
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "new": // add a new plot and view/edit its information
                // pop up a dialog:
                //      suggest a default plotID that can be changed?
                //      suggest a default section name that can be changed?
                // then create a new Plot() and with those details and load it
                // TODO
                break;
            case "delete": // permanently delete selected plot from cemetery
                // TODO
                break;
        }
    }

    /**
     * Get the data from cemetery about plots and load it into the appropriate GUI elements
     * @param sections list of selected sections in CemeteryPlotterSections
     */
    public void getPlotsData(Collection<String> sections) {
        ArrayList<String> plots = new ArrayList<>();

        for (String section : sections) {
            // figure out which plots to put in the list (based on which sections are selected in CemeteryPlotterSections)
            Section s = cemetery.get(new Section(section));

            for (Plot p : s.getPlots()) {
                plots.add(Integer.toString(p.getID()));
            }
        }

        // sort the list of people using default String comparator
        Collections.sort(plots);

        // add each person to the people list
        for (String plotID : plots) {
            plotsListModel.addElement(plotID);
        }
    }

    /**
     * Set the data from the GUI into the Cemetery, Section, and Plot in the cemetery
     */
    public void setPlotsData() { // TODO on add plot and possibly on delete plot
        // write the plot data from the GUI fields into the right place in the data layer
    }

    /**
     * Clear the plots list
     */
    public void clearPlotsList() {
        plotsListModel.clear();
    }

    /**
     * Refresh the plots list when a plot has been put in a new section
     */
    public void refreshPlotsList() {
        int index = plotsList.getSelectedIndex();
        clearPlotsList();
        getPlotsData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());

        if (index >= 0) {
            plotsList.setSelectedIndex(index);
        }
    }

    /**
     * Gets the selected plot ID
     * @return selected plot
     */
    public Plot getSelectedPlot() {
        // figure out what plot data to get and fill in based on selected plot from CemeteryPlotterPlots
        int plotID = Integer.parseInt(plotsList.getSelectedValue());
        Plot plot = new Plot("", plotID);

        return cemetery.getPlots().get(cemetery.getPlots().indexOf(plot));
    }

    /**
     * Implementation of ListSelectionListener that is invoked when selections are made on the plots list
     */
    class PlotsListSelectionHandler implements ListSelectionListener {

        /**
         * Called automatically when selections are made
         * @param e ListSelectionEvent
         */
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting();

            if (!isAdjusting) {
                if (lsm.isSelectionEmpty()) { // no selection
                    // TODO must interact nicely with people list selections
                    cemeteryPlotterFrame.clearData();
                } else { // show the selected plot
                    // TODO must interact nicely with people list selections
                    int index = lsm.getMinSelectionIndex();
                    int plotID = Integer.parseInt(plotsListModel.get(index));
                    Plot plot = new Plot("", plotID);
                    cemeteryPlotterFrame.cemeteryPlotterPeople.overridePeopleList();
                    cemeteryPlotterFrame.clearData();
                    cemeteryPlotterFrame.getData(plot);
                }
            }
        }
    }
}
