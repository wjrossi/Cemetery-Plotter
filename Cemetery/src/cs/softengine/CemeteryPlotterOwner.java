package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Content pane containing editable information on a plot owner
 */
public class CemeteryPlotterOwner extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel ownerPanel;
    private ArrayList<JComponent> editable;

    /**
     * Constructs a content pane for a plot owner info
     */
    public CemeteryPlotterOwner() {
        editable = new ArrayList<JComponent>();
        ownerPanel = createOwnerPanel();
    }

    /**
     * Get plot owner info panel
     * @return ownerPanel
     */
    public JPanel getOwnerPanel() {
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
        JTextField address1Field = new JTextField(12);
        JTextField address2Field = new JTextField(12);
        JTextField cityField = new JTextField(8);
        JTextField stateField = new JTextField(2);
        JTextField zipField = new JTextField(5);
        JTextField phoneField = new JTextField(10);

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
        JTextField addPlotField = new JTextField(4);
        JButton addPlotButton = new JButton("Add Plot");
        JButton removePlotButton = new JButton("Remove Plot(s)");

        // create sub-panels
        JPanel namePanel = new JPanel();
        JPanel addressPanel = new JPanel();
        JPanel address1Panel = new JPanel();
        JPanel address2Panel = new JPanel();
        JPanel address3Panel = new JPanel();
        JPanel phonePanel = new JPanel();
        JPanel ownedPanel = new JPanel();
        JPanel ownedButtonsPanel = new JPanel();

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.PAGE_AXIS));
        address1Panel.setLayout(new BoxLayout(address1Panel, BoxLayout.LINE_AXIS));
        address2Panel.setLayout(new BoxLayout(address2Panel, BoxLayout.LINE_AXIS));
        address3Panel.setLayout(new BoxLayout(address3Panel, BoxLayout.LINE_AXIS));
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        ownedPanel.setLayout(new BoxLayout(ownedPanel, BoxLayout.PAGE_AXIS));
        ownedButtonsPanel.setLayout(new BoxLayout(ownedButtonsPanel, BoxLayout.LINE_AXIS));

        // add items to sub-panels
        namePanel.add(fnameLabel);
        namePanel.add(fnameField);
        namePanel.add(lnameLabel);
        namePanel.add(lnameField);

        address1Panel.add(address1Label);
        address1Panel.add(address1Field);

        address2Panel.add(address2Label);
        address2Panel.add(address2Field);

        address3Panel.add(cityLabel);
        address3Panel.add(cityField);
        address3Panel.add(stateLabel);
        address3Panel.add(stateField);
        address3Panel.add(zipLabel);
        address3Panel.add(zipField);

        addressPanel.add(address1Panel);
        addressPanel.add(address2Panel);
        addressPanel.add(address3Panel);

        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);

        ownedButtonsPanel.add(addPlotButton);
        ownedButtonsPanel.add(removePlotButton);

        ownedPanel.add(plotsListScrollPane);
        ownedPanel.add(addPlotField);
        ownedPanel.add(ownedButtonsPanel);

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(namePanel);
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(phonePanel);
        fieldsPanel.add(ownedPanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editButton, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(fnameField);
        editable.add(lnameField);
        editable.add(address1Field);
        editable.add(address2Field);
        editable.add(cityField);
        editable.add(stateField);
        editable.add(zipField);
        editable.add(phoneField);
        editable.add(plotsList);
        editable.add(addPlotButton);
        editable.add(addPlotField);
        editable.add(removePlotButton);

        // disable editable fields until edit button is pressed
        setFieldsEditable(false);

        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     * @param isEditable new state of editable buttons
     */
    private void setFieldsEditable(boolean isEditable) {
        for (JComponent c : editable) {
            c.setEnabled(isEditable);
        }
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
