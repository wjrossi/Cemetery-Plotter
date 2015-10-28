package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for listing of plots belonging to selected section(s)
 */
public class CemeteryPlotterPlots extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel plotsPanel;
    private JTextField searchField;
    private DefaultListModel<String> plotsListModel;
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
        searchField.setToolTipText("View or edit the specified plot");

        // add search text field and button to search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.add(searchField);

        // add search panel to main panel
        panel.add(searchPanel, BorderLayout.PAGE_START);

        // create list of plots
        plotsListModel = new DefaultListModel<String>();
        plotsList = new JList<String>(plotsListModel);
        plotsListScrollPane = new JScrollPane(plotsList);
        plotsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        plotsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        plotsList.setLayoutOrientation(JList.VERTICAL);
        plotsList.setPrototypeCellValue("999999");

        plotsList.setToolTipText("Select the plot you wish to view or edit");

        // create new and delete buttons
        newPlotButton = new JButton("New Plot");
        deletePlotButton = new JButton("Delete Plot(s)");

        newPlotButton.setToolTipText("Add a new plot and view/edit its information");
        deletePlotButton.setToolTipText("Permanently delete the selected plot from the cemetery");

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
        //
    }

    /**
     * Item state listener for plots content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }

    /**
     * Get the data from cemetery about plots and load it into the appropriate GUI elements
     */
    public void getPlotsData() {
        // figure out which plots to put in the list (based on which sections are selected in CemeteryPlotterSections)
    }

    /**
     * Set the data from the GUI into the Cemetery, Section, and Plot in the cemetery
     */
    public void setPlotsData() {
        // write the plot data from the GUI fields into the right place in the data layer
    }
}
