package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane containing editable information on a plot owner
 */
public class CemeteryPlotterOwner implements ActionListener, ItemListener {
    private JPanel ownerPanel;

    /**
     * Constructs a content pane for a plot owner info
     */
    public CemeteryPlotterOwner() {
        ownerPanel = createOwnerPanel();
    }

    /**
     * Get plot owner info panel
     * @return ownerPanel
     */
    public JPanel getPanel() {
        return ownerPanel;
    }

    /**
     * Create plot owner panel
     * @return panel
     */
    private JPanel createOwnerPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Owner");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        // create labels
        JLabel fnameLabel = new JLabel("First:");
        JLabel lnameLabel = new JLabel("Last:");
        JLabel address1Label = new JLabel("Address 1:");
        JLabel address2Label = new JLabel("Address 2:");
        JLabel cityLabel = new JLabel("City:");
        JLabel stateLabel = new JLabel("State:");
        JLabel zipLabel = new JLabel("Zip:");
        JLabel phoneLabel = new JLabel("Phone:");

        // create text fields
        JTextField fnameField = new JTextField(8);
        JTextField lnameField = new JTextField(8);
        JTextField address1Field = new JTextField(16);
        JTextField address2Field = new JTextField(16);
        JTextField cityField = new JTextField(8);
        JTextField stateField = new JTextField(1);
        JTextField zipField = new JTextField(2);
        JTextField phoneField = new JTextField(8);

        // join labels to text fields
        fnameLabel.setLabelFor(fnameField);
        lnameLabel.setLabelFor(lnameField);
        address1Label.setLabelFor(address1Field);
        address2Label.setLabelFor(address2Field);
        cityLabel.setLabelFor(cityField);
        stateLabel.setLabelFor(stateField);
        zipLabel.setLabelFor(zipField);
        phoneLabel.setLabelFor(phoneField);

        // create edit button
        JButton editButton = new JButton("Edit"); // when clicked will unlock text fields and allow changes

        // create list of plots owned by person
        JList<String> plotsList = new JList<String>();
        JScrollPane plotsListScrollPane = new JScrollPane(plotsList);
        plotsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        plotsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        plotsList.setLayoutOrientation(JList.VERTICAL);
        plotsList.setPrototypeCellValue("999999");

        // create add and remove plot buttons and text field
        JButton addPlotButton = new JButton("Add Plot");
        JButton removePlotButton = new JButton("Remove Plot(s)");
        JTextField removePlotField = new JTextField();

        // create sub-panels


        // add items to sub-panels


        // add sub-panels to main panel




        return panel;
    }

    /**
     * Action listener for plot owner info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for plot owner info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
