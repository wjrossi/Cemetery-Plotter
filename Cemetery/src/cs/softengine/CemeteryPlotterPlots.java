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
    public JPanel getPanel() {
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

        // create search text field
        JTextField searchField = new JTextField(8);
        JButton searchButton = new JButton("Go");

        // add search text field and button to search panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // add search panel to main panel
        panel.add(searchPanel, BorderLayout.PAGE_START);

        // create list of plots
        JList<String> plotsList = new JList<String>();
        JScrollPane plotsListScrollPane = new JScrollPane(plotsList);
        plotsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        plotsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        plotsList.setLayoutOrientation(JList.VERTICAL);
        plotsList.setPrototypeCellValue("999999");

        // create new and delete buttons
        JButton newPlotButton = new JButton("New Plot");
        JButton deletePlotButton = new JButton("Delete Plot(s)");
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
}
