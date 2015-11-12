package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Content pane containing editable information of an interred person
 */
public class CemeteryPlotterInterredPerson extends CemeteryPlotter implements ActionListener {
    private JPanel interredPanel;
    private JTextField interredIDField;
    private JTextField plotIDField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField bornDateMonthField;
    private JTextField bornDateDayField;
    private JTextField bornDateYearField;
    private JTextField diedDateMonthField;
    private JTextField diedDateDayField;
    private JTextField diedDateYearField;
    private JButton editButton;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;

    /**
     * Constructs a content pane for an interred person info
     */
    public CemeteryPlotterInterredPerson() {
        editable = new ArrayList<>();
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
        JLabel bornDateLabel = new JLabel("Date of Birth:");
        JLabel diedDateLabel = new JLabel("Date of Death:");
        JLabel dateDividerLabel1 = new JLabel("/");
        JLabel dateDividerLabel2 = new JLabel("/");
        JLabel dateDividerLabel3 = new JLabel("/");
        JLabel dateDividerLabel4 = new JLabel("/");

        bornDateLabel.setToolTipText("MM/DD/YYYY");
        diedDateLabel.setToolTipText("MM/DD/YYYY");

        // create text fields
        interredIDField = new JTextField(6);
        plotIDField = new JTextField(4);
        fnameField = new JTextField(8);
        lnameField = new JTextField(8);
        bornDateMonthField = new JTextField(2);
        bornDateDayField = new JTextField(2);
        bornDateYearField = new JTextField(4);
        diedDateMonthField = new JTextField(2);
        diedDateDayField = new JTextField(2);
        diedDateYearField = new JTextField(4);

        plotIDField.setEnabled(false); // plotID cannot be changed in interred person sub-class

        bornDateMonthField.setToolTipText("MM");
        bornDateDayField.setToolTipText("DD");
        bornDateYearField.setToolTipText("YYYY");
        diedDateMonthField.setToolTipText("MM");
        diedDateDayField.setToolTipText("DD");
        diedDateYearField.setToolTipText("YYYY");

        // join labels to text fields
        interredIDLabel.setLabelFor(interredIDField);
        plotIDLabel.setLabelFor(plotIDField);
        fnameLabel.setLabelFor(fnameField);
        lnameLabel.setLabelFor(lnameField);
        bornDateLabel.setLabelFor(bornDateYearField);
        diedDateLabel.setLabelFor(diedDateYearField);

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

        // create sub-panels
        JPanel idPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel bornDatePanel = new JPanel();
        JPanel diedDatePanel = new JPanel();
        JPanel editPanel = new JPanel();

        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.LINE_AXIS));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));
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

        bornDatePanel.add(bornDateLabel);
        bornDatePanel.add(bornDateMonthField);
        bornDatePanel.add(dateDividerLabel1);
        bornDatePanel.add(bornDateDayField);
        bornDatePanel.add(dateDividerLabel2);
        bornDatePanel.add(bornDateYearField);

        diedDatePanel.add(diedDateLabel);
        diedDatePanel.add(diedDateMonthField);
        diedDatePanel.add(dateDividerLabel3);
        diedDatePanel.add(diedDateDayField);
        diedDatePanel.add(dateDividerLabel4);
        diedDatePanel.add(diedDateYearField);

        editPanel.add(editButton);
        editPanel.add(cancelButton);
        editPanel.add(deleteButton);
        editPanel.add(updateButton);

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(idPanel);
        fieldsPanel.add(namePanel);
        fieldsPanel.add(bornDatePanel);
        fieldsPanel.add(diedDatePanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editPanel, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(interredIDField);
        //editable.add(plotIDField); // not editable
        editable.add(fnameField);
        editable.add(lnameField);
        editable.add(bornDateMonthField);
        editable.add(bornDateDayField);
        editable.add(bornDateYearField);
        editable.add(diedDateMonthField);
        editable.add(diedDateDayField);
        editable.add(diedDateYearField);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(deleteButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setInterredEditable(false);

        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     * @param value enabled/disabled
     */
    public void setInterredEditable(boolean value) {
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
            case "edit": // allow the info to be changed
                editInterred();
                break;
            case "delete": // delete this record
                deleteInterred();
                break;
            case "update": // write changes to plot
                updateInterred();
                break;
            case "cancel": // revert changes by clearing and reloading info
                cancelInterred();
                break;
        }
    }

    /**
     * Edit button's action for the interred person's data
     */
    public void editInterred() {
        setInterredEditable(true);
        editButton.setEnabled(false);
        cancelButton.requestFocus();
    }

    /**
     * Delete button's action for the interred person's data
     */
    public void deleteInterred() {
        cemetery.setModified(true);
        setInterredEditable(false);
        editButton.setEnabled(true);
        cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot().setInterred(null);
        clearInterredData();
        getInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        cemeteryPlotterFrame.cemeteryPlotterPeople.refreshPeopleList();
        editButton.requestFocus();
    }

    /**
     * Update button's action for the interred person's data
     */
    public void updateInterred() {
        String interredID = interredIDField.getText().toUpperCase();
        int interredIndex = cemetery.getInterred().indexOf(new InterredPerson(Integer.parseInt(interredID)));

        if (interredIndex >= 0) { // interredID already exists
            JOptionPane.showMessageDialog(cemeteryPlotterFrame.getFrame(),
                    "Interred person with interredID \"" + interredID + "\" already exists\n"
                            + "in plot with plotID \"" + cemetery.getInterred().get(interredIndex).getPlotID() + "\".",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            interredIDField.requestFocus();
            interredIDField.selectAll();
        } else {
            setInterredEditable(false);
            editButton.setEnabled(true);
            setInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
            clearInterredData();
            getInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
            cemeteryPlotterFrame.cemeteryPlotterPeople.refreshPeopleList();
            editButton.requestFocus();
        }
    }

    /**
     * Cancel button's action for the interred person's data
     */
    public void cancelInterred() {
        setInterredEditable(false);
        editButton.setEnabled(true);
        clearInterredData();
        getInterredData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        editButton.requestFocus();
    }

    /**
     * Get the data from cemetery about an interred person and load it into the appropriate GUI elements
     */
    public void getInterredData(Plot plot) {
        editButton.setEnabled(true);

        InterredPerson ip = plot.getInterred();

        // load the gui elements...
        if (ip != null) {
            interredIDField.setText(Integer.toString(ip.getInterredID()));
            plotIDField.setText(Integer.toString(ip.getPlotID()));
            fnameField.setText(ip.getFirstName());
            lnameField.setText(ip.getLastName());
            bornDateMonthField.setText(ip.getBornDateMonth());
            bornDateDayField.setText(ip.getBornDateDay());
            bornDateYearField.setText(ip.getBornDateYear());
            diedDateMonthField.setText(ip.getDiedDateMonth());
            diedDateDayField.setText(ip.getDiedDateDay());
            diedDateYearField.setText(ip.getDiedDateYear());
        } else { // possibly creating a new interred person for the associated plot
            plotIDField.setText(Integer.toString(plot.getID()));
            interredIDField.setText(Integer.toString(cemetery.getNextInterredID()));
        }
    }

    /**
     * Set the data from the GUI into the interred person in the cemetery
     */
    public void setInterredData(Plot plot) { // TODO bad input error checking
        cemetery.setModified(true);

        // write the contact data from the GUI fields into the right place in the data layer
        InterredPerson ip = plot.getInterred();

        if (ip == null) {
            ip = new InterredPerson();
            cemetery.setNextInterredID();
            cemetery.getInterred().add(ip);
        }

        ip.setInterredID(Integer.parseInt(interredIDField.getText()));
        ip.setPlotID(Integer.parseInt(plotIDField.getText()));
        ip.setFirstName(fnameField.getText());
        ip.setLastName(lnameField.getText());
        ip.setBornDateMonth(bornDateMonthField.getText());
        ip.setBornDateDay(bornDateDayField.getText());
        ip.setBornDateYear(bornDateYearField.getText());
        ip.setDiedDateMonth(diedDateMonthField.getText());
        ip.setDiedDateDay(diedDateDayField.getText());
        ip.setDiedDateYear(diedDateYearField.getText());

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
        bornDateMonthField.setText("");
        bornDateDayField.setText("");
        bornDateYearField.setText("");
        diedDateMonthField.setText("");
        diedDateDayField.setText("");
        diedDateYearField.setText("");
    }
}
