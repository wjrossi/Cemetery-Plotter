package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private DefaultListModel<Integer> plotsListModel;
    private DefaultListSelectionModel plotsListSelectionModel;
    private JList<Integer> plotsList;
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

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                plotsListModel.clear();
                getPlotsData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (searchField.getText().isEmpty()) {
                    plotsListModel.clear();
                    getPlotsData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                } else {
                    DefaultListModel<Integer> newListModel = new DefaultListModel<>();
                    for (int index = 0; index < plotsListModel.size(); index++) {
                        if (plotsListModel.get(index).toString().startsWith(searchField.getText()))
                            newListModel.addElement(plotsListModel.get(index));
                    }

                    plotsListModel = newListModel;
                    plotsList.setModel(plotsListModel);

                    if (plotsListModel.size() == 1)
                        setSelectedPlot(0);
                }
            }
        });

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
        plotsList.setPrototypeCellValue(999999);
        plotsList.setToolTipText("Select the plot you wish to view or edit.");

        // create new and delete buttons
        newPlotButton = new JButton("New Plot");
        newPlotButton.setActionCommand("new");
        newPlotButton.addActionListener(this);
        newPlotButton.setToolTipText("Add a new plot in the selected section. Only one section may be selected.");

        deletePlotButton = new JButton("Delete Plot");
        deletePlotButton.setActionCommand("delete");
        deletePlotButton.addActionListener(this);
        deletePlotButton.setToolTipText("Permanently delete the selected plot from the cemetery. Only one section may be selected.");

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
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "new": // add a new plot and view/edit its information
                newPlot();
                break;
            case "delete": // permanently delete selected plot from cemetery
                deletePlot();
                break;
        }
    }

    /**
     * Get the data from cemetery about plots and load it into the appropriate GUI elements
     * @param sections list of selected sections in CemeteryPlotterSections
     */
    public void getPlotsData(Collection<String> sections) {
        ArrayList<Integer> plots = new ArrayList<>();

        for (String section : sections) {
            // figure out which plots to put in the list (based on which sections are selected in CemeteryPlotterSections)
            Section s = cemetery.get(new Section(section));

            for (Plot p : s.getPlots())
                plots.add(p.getID());
        }

        // sort the list of people using default String comparator
        Collections.sort(plots);

        // add each person to the people list
        for (int plotID : plots)
            plotsListModel.addElement(plotID);

        plotsList.setModel(plotsListModel);
    }

    /**
     * Create a new plot and view/edit it
     */
    public void newPlot() {
        Plot plot = new Plot();

        Collection<String> sections = cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections();

        if (sections.size() != 1) {
            JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                    "Select a single section to add a new plot.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String section : sections) {
            plot.setSection(section);
            plot.setID(cemetery.getNextPlotID());
            cemetery.setNextPlotID();
            cemetery.get(new Section(section)).add(plot);
            cemetery.getPlots().add(plot);
        }

        refreshPlotsList();
        cemetery.setModified(true);
    }

    /**
     * Delete the selected plot permanently
     */
    public void deletePlot() {
        if (plotsListModel.size() <= 0) {
            JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                    "Select a plot to delete.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Plot plot = getSelectedPlot();

        if (plot == null)
            return;

        int remove = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                "Are you sure you want to delete the plot with plotID \"" + plot.getID() + "\"?\n" +
                "This action will also delete the interred and contact information associated with the plot.",
                "Delete?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                null,
                null);

        if (remove == JOptionPane.YES_OPTION) { // remove it
            cemetery.get(new Section(plot.getSection())).remove(plot);
            cemetery.getPlots().remove(plot);
            cemetery.getInterred().remove(plot.getInterred());
            cemetery.getContacts().remove(plot.getContact());
            refreshPlotsList();
            cemeteryPlotterFrame.cemeteryPlotterPeople.refreshPeopleList();
            cemetery.setModified(true);
        }
    }

    /**
     * Get the plots list
     * @return plotsListModel
     */
    public DefaultListModel<Integer> getPlotsListModel() {
        return plotsListModel;
    }

    /**
     * Clear the plots list
     */
    public void clearPlotsList() {
        plotsListModel.clear();
        searchField.setText("");
    }

    /**
     * Refresh the plots list when a plot has been put in a new section
     */
    public void refreshPlotsList() {
        int index = plotsList.getSelectedIndex();
        clearPlotsList();
        getPlotsData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());

        if (index >= 0)
            plotsList.setSelectedIndex(index);
    }

    /**
     * Gets the selected plot ID
     * @return selected plot
     */
    public Plot getSelectedPlot() {
        // figure out what plot data to get and fill in based on selected plot from CemeteryPlotterPlots
        if (plotsList.getSelectedValue() < 0)
            return null;

        Plot plot = new Plot("", plotsList.getSelectedValue());
        int plotIndex = cemetery.getPlots().indexOf(plot);

        if (plotIndex < 0)
            return null;

        return cemetery.getPlots().get(plotIndex);
    }

    /**
     * Set selected plot
     * @param index of plot in plotsList
     */
    public void setSelectedPlot(int index) {
        plotsList.setSelectedIndex(index);
        plotsList.ensureIndexIsVisible(index);
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
                cemeteryPlotterFrame.cemeteryPlotterPlot.clearPlotData();
                cemeteryPlotterFrame.cemeteryPlotterPlot.setPlotEditable(false);
                cemeteryPlotterFrame.cemeteryPlotterInterredPerson.clearInterredData();
                cemeteryPlotterFrame.cemeteryPlotterInterredPerson.setInterredEditable(false);
                cemeteryPlotterFrame.cemeteryPlotterContact.clearContactData();
                cemeteryPlotterFrame.cemeteryPlotterContact.setContactEditable(false);

                if (lsm.isSelectionEmpty()) { // no selection
                    cemeteryPlotterFrame.clearData();
                } else { // show the selected plot
                    int index = lsm.getMinSelectionIndex();
                    Plot plot = new Plot("", plotsListModel.get(index));

                    cemeteryPlotterFrame.cemeteryPlotterPeople.getPeopleList().clearSelection();
                    cemeteryPlotterFrame.clearData();
                    cemeteryPlotterFrame.getData(plot);
                }
            }
        }
    }
}
