package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Content pane containing editable information on a plot contact
 */
public class CemeteryPlotterContact extends CemeteryPlotter implements ActionListener {
    private JPanel contactPanel;
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
    private JButton addPlotButton;
    private JButton removePlotButton;
    private JButton editButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton updateButton;

    private ArrayList<JComponent> editable;

    /**
     * Constructs a content pane for a plot contact info
     */
    public CemeteryPlotterContact() {
        editable = new ArrayList<>();
        contactPanel = createContactPanel();
    }

    /**
     * Get plot contact info panel
     * @return contactPanel
     */
    public JPanel getContactPanel() {
        return contactPanel;
    }

    /**
     * Create plot contact panel
     * @return panel
     */
    private JPanel createContactPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Contact");
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

        deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(this);

        updateButton = new JButton("Update");
        updateButton.setActionCommand("update");
        updateButton.addActionListener(this);

        // create list of plots owned by person
        ownedListModel = new DefaultListModel<>();
        ownedList = new JList<>(ownedListModel);

        ownedListScrollPane = new JScrollPane(ownedList);
        ownedListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ownedList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ownedList.setLayoutOrientation(JList.VERTICAL);
        ownedList.setPrototypeCellValue("999999");
        ownedList.setToolTipText("List of plots owned by this contact.");

        // create add and remove plot buttons
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
        ownedPanel.add(ownedButtonsPanel);

        editPanel.add(editButton);
        editPanel.add(cancelButton);
        editPanel.add(deleteButton);
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
        editable.add(removePlotButton);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(deleteButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setContactEditable(false);

        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     * @param value enabled/disabled
     */
    public void setContactEditable(boolean value) {
        for (JComponent c : editable) {
            c.setEnabled(value);
        }
    }

    /**
     * Action listener for plot info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "edit": // allow changed to be made
                editContact();
                break;
            case "update": // write changes to plot
                updateContact();
                break;
            case "cancel": // revert changes by clearing and reloading info
                cancelContact();
                break;
            case "delete": // delete this record
                deleteContact();
                break;
            case "add": // add a new plot to the contact's list GUI object
                addPlot();
                break;
            case "remove": // remove selected plot from the contact's list GUI object
                removePlot();
                break;
        }
    }

    /**
     * Edit button's action for the plot contact's data
     */
    public void editContact() {
        setContactEditable(true);
        editButton.setEnabled(false);
        cancelButton.requestFocus();
    }

    /**
     * Delete button's action for the interred person's data
     */
    public void deleteContact() {
        cemetery.setModified(true);
        setContactEditable(false);
        editButton.setEnabled(true);
        cemetery.getContacts().remove(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot().getContact());
        cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot().setContact(null);
        clearContactData();
        getContactData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        cemeteryPlotterFrame.cemeteryPlotterPeople.refreshPeopleList();
        editButton.requestFocus();
    }

    /**
     * Update button's action for the plot contact's data
     */
    public void updateContact() {
        setContactEditable(false);
        editButton.setEnabled(true);
        setContactData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        clearContactData();
        getContactData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        cemeteryPlotterFrame.cemeteryPlotterPeople.refreshPeopleList();
        editButton.requestFocus();
    }

    /**
     * Cancel button's action for the plot contact's data
     */
    public void cancelContact() {
        setContactEditable(false);
        editButton.setEnabled(true);
        clearContactData();
        getContactData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        editButton.requestFocus();
    }

    /**
     * Add a plot to the contact's
     */
    public void addPlot() {
        // get plotID from user
        String input = (String) JOptionPane.showInputDialog(
                cemeteryPlotterFrame.getFrame(),
                "PlotID:",
                "Assign a plot to this person",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");

        // validate plotID
        if (input != null && !input.isEmpty()) {
            int plotID = Integer.parseInt(input);
            int plotIndex = cemetery.getPlots().indexOf(new Plot("", plotID));

            if (plotIndex >= 0) { // valid plot
                Plot plot = cemetery.getPlots().get(plotIndex);
                Person oldContact = plot.getContact();
                Person contact = cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot().getContact();

                if (oldContact == null || contact.equals(oldContact)) { // no existing contact or same person
                    ownedListModel.addElement(Integer.toString(plotID));
                    setContactData(plot);
                    cemetery.setModified(true);
                } else { // ask to overwrite
                    int overwrite = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                            "Plot with plotID \"" + plotID + "\" already has a contact.\n" +
                                    "First Name: " + contact.getFirstName() +
                                    ", Last Name: " + contact.getLastName() + "\n" +
                                    "Address1: " + contact.getAddress1() + "\n" +
                                    "Address2: " + contact.getAddress2() + "\n" +
                                    "City: " + contact.getCity() + ", State: " + contact.getState() +
                                    ", Zip: " + contact.getZip() + "\n" +
                                    "Phone: " + contact.getPhone() + "\n" +
                                    "Are you sure you want to overwrite the contact?",
                            "Overwrite?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            null,
                            null);

                    if (overwrite == JOptionPane.YES_OPTION) {
                        ownedListModel.addElement(Integer.toString(plotID));
                        setContactData(plot);
                        cemetery.setModified(true);
                    }
                }
            } else { // invalid plot
                JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                        "Plot with plotID \"" + plotID + "\" does not exist.",
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                addPlotButton.requestFocus();
            }
        }
    }

    /**
     *
     */
    public void removePlot() {
        int index = ownedList.getSelectedIndex();

        if (index < 0) { // no selection
            JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                    "No plotID selected from this contacts plot list.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            addPlotButton.requestFocus();
        } else { // remove selected plot
            int plotID = Integer.parseInt(ownedListModel.get(index));
            int remove = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "Are you sure you want to remove plot \"" + plotID + "\" " +
                            "from this contact?",
                    "Remove?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);

            if (remove == JOptionPane.YES_OPTION) { // remove it
                int plotIndex = cemetery.getPlots().indexOf(new Plot("", plotID));
                Plot plot = cemetery.getPlots().get(plotIndex);
                ownedListModel.remove(index);

                if (plotIndex >= 0) {
                    setContactData(plot);
                    plot.setContact(null);
                }
            }
        }
    }

    /**
     * Get the data from cemetery about a plot and load it into the appropriate GUI elements
     */
    public void getContactData(Plot plot) {
        editButton.setEnabled(true);

        Person contact = plot.getContact();

        // load the gui elements...
        if (contact != null) {
            fnameField.setText(contact.getFirstName());
            lnameField.setText(contact.getLastName());
            address1Field.setText(contact.getAddress1());
            address2Field.setText(contact.getAddress2());
            cityField.setText(contact.getCity());
            stateField.setText(contact.getState());
            zipField.setText(contact.getZip());
            phoneField.setText(contact.getPhone());

            for (Integer plotID : contact.getOwnedPlots()) {
                ownedListModel.addElement(Integer.toString(plotID));
            }
        } else {
            ownedListModel.addElement(Integer.toString(plot.getID()));
        }
    }

    /**
     * Set the data from the GUI into the contact Person in the cemetery
     */
    public void setContactData(Plot plot) {
        cemetery.setModified(true);

        // write the contact data from the GUI fields into the right place in the data layer
        Person contact = plot.getContact();

        if (contact == null) {
            contact = new Person(cemetery.getNextContactID());
            cemetery.setNextContactID();
            cemetery.getContacts().add(contact);
        }

        contact.setFirstName(fnameField.getText());
        contact.setLastName(lnameField.getText());
        contact.setAddress1(address1Field.getText());
        contact.setAddress2((address2Field.getText()));
        contact.setCity(cityField.getText());
        contact.setState(stateField.getText());
        contact.setZip(zipField.getText());
        contact.setPhone(phoneField.getText());

        ArrayList<Integer> ownedPlots = new ArrayList<>(ownedListModel.size());
        for (int index = 0; index < ownedListModel.size(); index++) {
            ownedPlots.add(Integer.parseInt(ownedListModel.get(index)));
            cemetery.getPlots().get(cemetery.getPlots().indexOf(plot)).setContact(contact);
        }
        Collections.sort(ownedPlots);
        contact.setOwnedPlots(ownedPlots);

        plot.setContact(contact);

        int contactIndex = cemetery.getContacts().indexOf(contact);
        if (contactIndex >= 0) {
            cemetery.getContacts().set(contactIndex, contact);
        } else {
            cemetery.getContacts().add(contact);
        }
    }

    /**
     * Clear all contact data from the GUI
     */
    public void clearContactData() {
        // clear each textfield and whatnot
        fnameField.setText("");
        lnameField.setText("");
        address1Field.setText("");
        address2Field.setText("");
        cityField.setText("");
        stateField.setText("");
        zipField.setText("");
        phoneField.setText("");
        ownedListModel.clear();
    }
}
