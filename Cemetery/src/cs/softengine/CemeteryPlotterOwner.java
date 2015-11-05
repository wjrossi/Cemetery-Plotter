package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Content pane containing editable information on a plot owner
 */
public class CemeteryPlotterOwner extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel ownerPanel;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField address1Field;
    private JTextField address2Field;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JTextField phoneField;
    private JList<String> ownedList;
    private JScrollPane ownedListScrollPane;
    private DefaultListModel<String> ownedListModel;
    private DefaultListSelectionModel ownedListSelectionModel;
    private JTextField addPlotField;
    private JButton addPlotButton;
    private JButton removePlotButton;
    private JButton editButton;
    private JButton cancelButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;

    /**
     * Constructs a content pane for a plot owner info
     */
    public CemeteryPlotterOwner() {
        editable = new ArrayList<>();
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
        fnameField = new JTextField(8);
        lnameField = new JTextField(8);
        address1Field = new JTextField(12);
        address2Field = new JTextField(12);
        cityField = new JTextField(8);
        stateField = new JTextField(2);
        zipField = new JTextField(5);
        phoneField = new JTextField(10);

        // join labels to text fields
        fnameLabel.setLabelFor(fnameField);
        lnameLabel.setLabelFor(lnameField);
        address1Label.setLabelFor(address1Field);
        address2Label.setLabelFor(address2Field);
        cityLabel.setLabelFor(cityField);
        stateLabel.setLabelFor(stateField);
        zipLabel.setLabelFor(zipField);
        phoneLabel.setLabelFor(phoneField);

        // create edit, update, and cancel buttons
        editButton = new JButton("Edit"); // when clicked will unlock text fields and allow changes
        editButton.setActionCommand("edit");
        editButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setActionCommand("update");
        updateButton.addActionListener(this);

        // create list of plots owned by person
        ownedListModel = new DefaultListModel<>();
        ownedList = new JList<>(ownedListModel);

        //ownedListSelectionModel = (DefaultListSelectionModel) ownedList.getSelectionModel();
        //ownedListSelectionModel.addListSelectionListener(new OwnedListSelectionHandler());

        ownedListScrollPane = new JScrollPane(ownedList);
        ownedListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ownedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ownedList.setLayoutOrientation(JList.VERTICAL);
        ownedList.setPrototypeCellValue("999999");

        // create add and remove plot buttons and text field
        addPlotField = new JTextField(4);

        addPlotButton = new JButton("Add Plot");
        addPlotButton.setActionCommand("add");
        addPlotButton.addActionListener(this);
        addPlotButton.setToolTipText("Add an existing plot to the list of plots owned by this person.");

        removePlotButton = new JButton("Remove Plot");
        removePlotButton.setActionCommand("remove");
        removePlotButton.addActionListener(this);
        removePlotButton.setToolTipText("Remove selected plot from the list. Does NOT delete the plot from the cemetery.");

        // create sub-panels
        JPanel namePanel = new JPanel();
        JPanel addressPanel = new JPanel();
        JPanel address1Panel = new JPanel();
        JPanel address2Panel = new JPanel();
        JPanel address3Panel = new JPanel();
        JPanel phonePanel = new JPanel();
        JPanel ownedPanel = new JPanel();
        JPanel ownedButtonsPanel = new JPanel();
        JPanel editPanel = new JPanel();

        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.PAGE_AXIS));
        address1Panel.setLayout(new BoxLayout(address1Panel, BoxLayout.LINE_AXIS));
        address2Panel.setLayout(new BoxLayout(address2Panel, BoxLayout.LINE_AXIS));
        address3Panel.setLayout(new BoxLayout(address3Panel, BoxLayout.LINE_AXIS));
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        ownedPanel.setLayout(new BoxLayout(ownedPanel, BoxLayout.PAGE_AXIS));
        ownedButtonsPanel.setLayout(new BoxLayout(ownedButtonsPanel, BoxLayout.LINE_AXIS));
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.LINE_AXIS));

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

        ownedPanel.add(ownedListScrollPane);
        ownedPanel.add(addPlotField);
        ownedPanel.add(ownedButtonsPanel);

        editPanel.add(editButton);
        editPanel.add(cancelButton);
        editPanel.add(updateButton);

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(namePanel);
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(phonePanel);
        fieldsPanel.add(ownedPanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editPanel, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(fnameField);
        editable.add(lnameField);
        editable.add(address1Field);
        editable.add(address2Field);
        editable.add(cityField);
        editable.add(stateField);
        editable.add(zipField);
        editable.add(phoneField);
        editable.add(ownedList);
        editable.add(addPlotButton);
        editable.add(addPlotField);
        editable.add(removePlotButton);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setOwnerEditable();

        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     */
    public void setOwnerEditable() {
        for (JComponent c : editable) {
            c.setEnabled(!c.isEnabled());
        }
    }

    /**
     * Action listener for plot info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "edit":
                setOwnerEditable();
                cancelButton.requestFocus();
                break;
            case "update":
                // write changes to plot using an additional method or call
                setOwnerData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                setOwnerEditable();
                // TODO call something that updates section list, plot list, and/or people list, if necessary
                editButton.requestFocus();
                break;
            case "cancel":
                // revert changes by reloading info into fields
                setOwnerEditable();
                clearOwnerData();
                getOwnerData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                editButton.requestFocus();
                break;
            case "add":
                // TODO add a plot to this owner's list and the list GUI object
                // can multiple people own a plot? probably not
                break;
            case "remove":
                // TODO remove a plot from this owner's list and the list GUI object
                break;
        }
    }

    /**
     * Item state listener for plot owner info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }

    /**
     * Get the data from cemetery about a plot and load it into the appropriate GUI elements
     */
    public void getOwnerData(Plot plot) { // TODO
        editButton.setEnabled(true);

        Person owner = plot.getOwner();

        // load the gui elements...
        if (owner != null) {
            fnameField.setText(owner.getFirstName());
            lnameField.setText(owner.getLastName());
            address1Field.setText(owner.getAddress1());
            address2Field.setText(owner.getAddress2());
            cityField.setText(owner.getCity());
            stateField.setText(owner.getState());
            zipField.setText(owner.getZip());
            phoneField.setText(owner.getPhone());
            addPlotField.setText("");

            for (Integer plotID : owner.getOwnedPlots()) {
                ownedListModel.addElement(Integer.toString(plotID));
            }
        }
    }

    /**
     * Set the data from the GUI into the owner Person in the cemetery
     */
    public void setOwnerData(Plot plot) { // TODO BAD INPUT ERROR CHECKING
        cemetery.setModified(true);

        // write the owner data from the GUI fields into the right place in the data layer
        Person owner = plot.getOwner();

        if (owner == null) {
            owner = new Person();
        }

        owner.setFirstName(fnameField.getText());
        owner.setLastName(lnameField.getText());
        owner.setAddress1(address1Field.getText());
        owner.setAddress2((address2Field.getText()));
        owner.setCity(cityField.getText());
        owner.setState(stateField.getText());
        owner.setZip(zipField.getText());
        owner.setPhone(phoneField.getText());

        ArrayList<Integer> ownedPlots = new ArrayList<>(ownedListModel.size());

        for (String plotID : ownedList.getSelectedValuesList()) {
            ownedPlots.add(Integer.parseInt(plotID));
        }

        owner.setOwnedPlots(ownedPlots);

        plot.setOwner(owner);
    }

    /**
     * Clear all owner data from the GUI
     */
    public void clearOwnerData() {
        // clear each textfield and whatnot
        fnameField.setText("");
        lnameField.setText("");
        address1Field.setText("");
        address2Field.setText("");
        cityField.setText("");
        stateField.setText("");
        zipField.setText("");
        phoneField.setText("");
        addPlotField.setText("");
        ownedListModel.clear();
    }

    /**
     * Implementation of ListSelectionListener that is invoked when selections are made on the owned plots list
     */
    class OwnedListSelectionHandler implements ListSelectionListener {

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
                    // DO NOTHING
                } else { // show the selected plot
                    int index = lsm.getMinSelectionIndex();
                    // DO NOTHING ON SELECTION?
                }
            }
        }
    }
}
