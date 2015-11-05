package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Content pane containing editable information of an interred person
 */
public class CemeteryPlotterInterredPerson extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel interredPanel;
    private JTextField interredIDField;
    private JTextField plotIDField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField address1Field;
    private JTextField address2Field;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;
    private JTextField phoneField;
    private JFormattedTextField bornDateField;
    private JFormattedTextField diedDateField;
    private JButton editButton;
    private JButton cancelButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;
    private SimpleDateFormat sdf;

    /**
     * Constructs a content pane for an interred person info
     */
    public CemeteryPlotterInterredPerson() {
        editable = new ArrayList<>();
        sdf = new SimpleDateFormat("MM/dd/yyyy");
        interredPanel = createInterredPersonPanel();
    }

    /**
     * Get interred person info panel
     * @return interredPanel
     */
    public JPanel getInterredPanel() {
        return interredPanel;
    }

    /**
     * Create interred person info panel
     * @return panel
     */
    private JPanel createInterredPersonPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Interred");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // create labels
        JLabel interredIDLabel = new JLabel("InterredID:");
        JLabel plotIDLabel = new JLabel("PlotID:");
        JLabel fnameLabel = new JLabel("First:");
        JLabel lnameLabel = new JLabel("Last:");
        JLabel address1Label = new JLabel("Address 1:");
        JLabel address2Label = new JLabel("Address 2:");
        JLabel cityLabel = new JLabel("City:");
        JLabel stateLabel = new JLabel("State:");
        JLabel zipLabel = new JLabel("Zip:");
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel bornDateLabel = new JLabel("Date of Birth:");
        JLabel diedDateLabel = new JLabel("Date of Death:");

        bornDateLabel.setToolTipText("MM/DD/YYYY");
        diedDateLabel.setToolTipText("MM/DD/YYYY");

        // create text fields
        interredIDField = new JTextField(6);
        plotIDField = new JTextField(4);
        fnameField = new JTextField(8);
        lnameField = new JTextField(8);
        address1Field = new JTextField(12);
        address2Field = new JTextField(12);
        cityField = new JTextField(8);
        stateField = new JTextField(2);
        zipField = new JTextField(5);
        phoneField = new JTextField(10);
        bornDateField = new JFormattedTextField(sdf);
        diedDateField = new JFormattedTextField(sdf);

        bornDateField.setColumns(10);
        diedDateField.setColumns(10);

        // join labels to text fields
        interredIDLabel.setLabelFor(interredIDField);
        plotIDLabel.setLabelFor(plotIDField);
        fnameLabel.setLabelFor(fnameField);
        lnameLabel.setLabelFor(lnameField);
        address1Label.setLabelFor(address1Field);
        address2Label.setLabelFor(address2Field);
        cityLabel.setLabelFor(cityField);
        stateLabel.setLabelFor(stateField);
        zipLabel.setLabelFor(zipField);
        phoneLabel.setLabelFor(phoneField);
        bornDateLabel.setLabelFor(bornDateField);
        diedDateLabel.setLabelFor(diedDateField);

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

        // create sub-panels
        JPanel idPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel addressPanel = new JPanel();
        JPanel address1Panel = new JPanel();
        JPanel address2Panel = new JPanel();
        JPanel address3Panel = new JPanel();
        JPanel phonePanel = new JPanel();
        JPanel bornDatePanel = new JPanel();
        JPanel diedDatePanel = new JPanel();
        JPanel editPanel = new JPanel();

        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.LINE_AXIS));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
        addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.PAGE_AXIS));
        address1Panel.setLayout(new BoxLayout(address1Panel, BoxLayout.LINE_AXIS));
        address2Panel.setLayout(new BoxLayout(address2Panel, BoxLayout.LINE_AXIS));
        address3Panel.setLayout(new BoxLayout(address3Panel, BoxLayout.LINE_AXIS));
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.LINE_AXIS));
        bornDatePanel.setLayout(new BoxLayout(bornDatePanel, BoxLayout.LINE_AXIS));
        diedDatePanel.setLayout(new BoxLayout(diedDatePanel, BoxLayout.LINE_AXIS));
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.LINE_AXIS));

        // add items to sub-panels
        idPanel.add(interredIDLabel);
        idPanel.add(interredIDField);
        idPanel.add(plotIDLabel);
        idPanel.add(plotIDField);

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

        bornDatePanel.add(bornDateLabel);
        bornDatePanel.add(bornDateField);

        diedDatePanel.add(diedDateLabel);
        diedDatePanel.add(diedDateField);

        editPanel.add(editButton);
        editPanel.add(cancelButton);
        editPanel.add(updateButton);

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(idPanel);
        fieldsPanel.add(namePanel);
        fieldsPanel.add(addressPanel);
        fieldsPanel.add(phonePanel);
        fieldsPanel.add(bornDatePanel);
        fieldsPanel.add(diedDatePanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editPanel, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(interredIDField);
        editable.add(plotIDField);
        editable.add(fnameField);
        editable.add(lnameField);
        editable.add(address1Field);
        editable.add(address2Field);
        editable.add(cityField);
        editable.add(stateField);
        editable.add(zipField);
        editable.add(phoneField);
        editable.add(bornDateField);
        editable.add(diedDateField);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setInterredEditable();

        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     */
    private void setInterredEditable() {
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
                setInterredEditable();
                cancelButton.requestFocus();
                break;
            case "update":
                // write changes to plot using an additional method or call
                setInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                setInterredEditable();
                // TODO call something that updates section list, plot list, and/or people list, if necessary
                editButton.requestFocus();
                break;
            case "cancel":
                // revert changes by reloading info into fields
                editButton.setEnabled(false);
                setInterredEditable();
                clearInterredData();
                getInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                editButton.requestFocus();
                break;
        }
    }

    /**
     * Item state listener for interred person info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }

    /**
     * Get the data from cemetery about an interred person and load it into the appropriate GUI elements
     */
    public void getInterredData(Plot plot) { // TODO
        editButton.setEnabled(true);

        InterredPerson ip = plot.getInterred();

        // load the gui elements...
        if (ip != null) {
            interredIDField.setText(Integer.toString(ip.getInterredID()));
            plotIDField.setText(Integer.toString(ip.getPlotID()));
            fnameField.setText(ip.getFirstName());
            lnameField.setText(ip.getLastName());
            address1Field.setText(ip.getAddress1());
            address2Field.setText(ip.getAddress2());
            cityField.setText(ip.getCity());
            stateField.setText(ip.getState());
            zipField.setText(ip.getZip());
            phoneField.setText(ip.getPhone());

            try {
                bornDateField.setText(ip.getBornDate().toString());
            } catch (NullPointerException npe) {
                bornDateField.setText("");
            }

            try {
                diedDateField.setText(ip.getDiedDate().toString());
            } catch (NullPointerException npe) {
                diedDateField.setText("");
            }
        }
    }

    /**
     * Set the data from the GUI into the interred person in the cemetery
     */
    public void setInterredData(Plot plot) { // TODO on update button press
        cemetery.setModified(true);

        // write the owner data from the GUI fields into the right place in the data layer
        InterredPerson ip = plot.getInterred();

        if (ip == null) {
            ip = new InterredPerson();
        }

        ip.setInterredID(Integer.parseInt(interredIDField.getText())); // TODO what if this is changed??
        ip.setPlotID(Integer.parseInt(plotIDField.getText())); // TODO what if this is changed??
        ip.setFirstName(fnameField.getText());
        ip.setLastName(lnameField.getText());
        ip.setAddress1(address1Field.getText());
        ip.setAddress2((address2Field.getText()));
        ip.setCity(cityField.getText());
        ip.setState(stateField.getText());
        ip.setZip(zipField.getText());
        ip.setPhone(phoneField.getText());

        try {
            ip.setBornDate(sdf.parse(bornDateField.getText()));
        } catch (ParseException pe) {
            ip.setBornDate(null);
        }

        try {
            ip.setDiedDate(sdf.parse(diedDateField.getText()));
        } catch (ParseException pe) {
            ip.setDiedDate(null);
        }

        plot.setInterred(ip);
    }

    /**
     * Clear all interred person data from the GUI
     */
    public void clearInterredData() {
        // clear each textfield and whatnot
        interredIDField.setText("");
        plotIDField.setText("");
        fnameField.setText("");
        lnameField.setText("");
        address1Field.setText("");
        address2Field.setText("");
        cityField.setText("");
        stateField.setText("");
        zipField.setText("");
        phoneField.setText("");
        bornDateField.setText("");
        diedDateField.setText("");
    }
}
