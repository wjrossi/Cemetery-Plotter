package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterPlot extends CemeteryPlotter implements ActionListener {
    private JPanel plotPanel;
    private JTextField sectionField;
    private JTextField plotIDField;
    private JFormattedTextField burialDateMonthField;
    private JFormattedTextField burialDateDayField;
    private JFormattedTextField burialDateYearField;
    private JFormattedTextField purchasedDateMonthField;
    private JFormattedTextField purchasedDateDayField;
    private JFormattedTextField purchasedDateYearField;
    private JFormattedTextField moneyDueField;
    private JCheckBox vacantCheckBox;
    private JCheckBox readyCheckBox;
    private JButton editButton;
    private JButton cancelButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;
    private SimpleDateFormat sdfMonth;
    private SimpleDateFormat sdfDay;
    private SimpleDateFormat sdfYear;
    private NumberFormat nf;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        editable = new ArrayList<>();
        sdfMonth = new SimpleDateFormat("MM");
        sdfDay = new SimpleDateFormat("dd");
        sdfYear = new SimpleDateFormat("yyyy");
        nf = NumberFormat.getCurrencyInstance();
        plotPanel = createPlotPanel();
    }

    /**
     * Get plot info panel
     * @return plotPanel
     */
    public JPanel getPlotPanel() {
        return plotPanel;
    }

    /**
     * Create plot info panel
     * @return panel
     */
    private JPanel createPlotPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Plot");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // create labels
        JLabel sectionLabel = new JLabel("Section:");
        JLabel plotIDLabel = new JLabel("PlotID:");
        JLabel burialDateLabel = new JLabel("Date of Burial:");
        JLabel purchasedDateLabel = new JLabel("Date of Purchase:");
        JLabel moneyDueLabel = new JLabel("Amount Owed:");
        JLabel dateDividerLabel1 = new JLabel("/");
        JLabel dateDividerLabel2 = new JLabel("/");
        JLabel dateDividerLabel3 = new JLabel("/");
        JLabel dateDividerLabel4 = new JLabel("/");

        burialDateLabel.setToolTipText("MM/DD/YYYY");
        purchasedDateLabel.setToolTipText("MM/DD/YYYY");
        moneyDueLabel.setToolTipText("$123.45");

        // create text fields
        sectionField = new JTextField(6);
        plotIDField = new JTextField(4);
        burialDateMonthField = new JFormattedTextField(sdfMonth);
        burialDateDayField = new JFormattedTextField(sdfDay);
        burialDateYearField = new JFormattedTextField(sdfYear);
        purchasedDateMonthField = new JFormattedTextField(sdfMonth);
        purchasedDateDayField = new JFormattedTextField(sdfDay);
        purchasedDateYearField = new JFormattedTextField(sdfYear);
        moneyDueField = new JFormattedTextField(nf);
        burialDateMonthField.setColumns(2);
        burialDateDayField.setColumns(2);
        burialDateYearField.setColumns(4);
        purchasedDateMonthField.setColumns(2);
        purchasedDateDayField.setColumns(2);
        purchasedDateYearField.setColumns(4);
        moneyDueField.setColumns(8);

        // set labels to text fields
        sectionLabel.setLabelFor(sectionField);
        plotIDLabel.setLabelFor(plotIDField);
        burialDateLabel.setLabelFor(burialDateYearField);
        purchasedDateLabel.setLabelFor(purchasedDateYearField);
        moneyDueLabel.setLabelFor(moneyDueField);

        // create status check boxes
        vacantCheckBox = new JCheckBox("Vacant", false);
        readyCheckBox = new JCheckBox("Ready", false);

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
        JPanel burialDatePanel = new JPanel();
        JPanel purchasedDatePanel = new JPanel();
        JPanel moneyDuePanel = new JPanel();
        JPanel checkBoxPanel = new JPanel();
        JPanel editPanel = new JPanel();

        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.LINE_AXIS));
        burialDatePanel.setLayout(new BoxLayout(burialDatePanel, BoxLayout.LINE_AXIS));
        purchasedDatePanel.setLayout(new BoxLayout(purchasedDatePanel, BoxLayout.LINE_AXIS));
        moneyDuePanel.setLayout(new BoxLayout(moneyDuePanel, BoxLayout.LINE_AXIS));
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.LINE_AXIS));
        editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.LINE_AXIS));

        // add items to sub-panels
        idPanel.add(sectionLabel);
        idPanel.add(sectionField);
        idPanel.add(plotIDLabel);
        idPanel.add(plotIDField);

        burialDatePanel.add(burialDateLabel);
        burialDatePanel.add(burialDateMonthField);
        burialDatePanel.add(dateDividerLabel1);
        burialDatePanel.add(burialDateDayField);
        burialDatePanel.add(dateDividerLabel2);
        burialDatePanel.add(burialDateYearField);

        purchasedDatePanel.add(purchasedDateLabel);
        purchasedDatePanel.add(purchasedDateMonthField);
        purchasedDatePanel.add(dateDividerLabel3);
        purchasedDatePanel.add(purchasedDateDayField);
        purchasedDatePanel.add(dateDividerLabel4);
        purchasedDatePanel.add(purchasedDateYearField);

        moneyDuePanel.add(moneyDueLabel);
        moneyDuePanel.add(moneyDueField);

        checkBoxPanel.add(vacantCheckBox);
        checkBoxPanel.add(readyCheckBox);

        editPanel.add(editButton);
        editPanel.add(cancelButton);
        editPanel.add(updateButton);

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(idPanel);
        fieldsPanel.add(burialDatePanel);
        fieldsPanel.add(purchasedDatePanel);
        fieldsPanel.add(moneyDuePanel);
        fieldsPanel.add(checkBoxPanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editPanel, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(sectionField);
        editable.add(plotIDField);
        editable.add(burialDateMonthField);
        editable.add(burialDateDayField);
        editable.add(burialDateYearField);
        editable.add(purchasedDateMonthField);
        editable.add(purchasedDateDayField);
        editable.add(purchasedDateYearField);
        editable.add(moneyDueField);
        editable.add(vacantCheckBox);
        editable.add(readyCheckBox);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setPlotEditable(false);
        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     * @param value enabled/disabled
     */
    public void setPlotEditable(boolean value) {
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
            case "edit": // allow changes to be made
                editPlot();
                break;
            case "update": // write changes to plot
                updatePlot();
                break;
            case "cancel": // revert changes by clearing and reloading info
                cancelPlot();
                break;
        }
    }

    /**
     * Edit button's action for the plot's data
     */
    public void editPlot() {
        setPlotEditable(true);
        cancelButton.requestFocus();
    }

    /**
     * Update button's action for the plot's data
     */
    public void updatePlot() {
        setPlotEditable(false);
        setPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        // TODO call something that updates section list, plot list, and/or people list, if necessary
        editButton.requestFocus();
    }

    /**
     * Cancel button's action for the plot's data
     */
    public void cancelPlot() {
        setPlotEditable(false);
        clearPlotData();
        getPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
        editButton.requestFocus();
    }

    /**
     * Get the data from cemetery about a plot and load it into the appropriate GUI elements
     */
    public void getPlotData(Plot plot) {
        editButton.setEnabled(true);

        // load the gui elements...
        sectionField.setText(plot.getSection());
        plotIDField.setText(Integer.toString(plot.getID()));

        try {
            burialDateMonthField.setText(plot.getBurialDate().toString());
        } catch (NullPointerException npe) {
            burialDateMonthField.setText("");
        }

        try {
            burialDateDayField.setText(plot.getBurialDate().toString());
        } catch (NullPointerException npe) {
            burialDateDayField.setText("");
        }

        try {
            burialDateYearField.setText(plot.getBurialDate().toString());
        } catch (NullPointerException npe) {
            burialDateYearField.setText("");
        }

        try {
            purchasedDateMonthField.setText(plot.getPurchasedDate().toString());
        } catch (NullPointerException npe) {
            purchasedDateMonthField.setText("");
        }

        try {
            purchasedDateDayField.setText(plot.getPurchasedDate().toString());
        } catch (NullPointerException npe) {
            purchasedDateDayField.setText("");
        }

        try {
            purchasedDateYearField.setText(plot.getPurchasedDate().toString());
        } catch (NullPointerException npe) {
            purchasedDateYearField.setText("");
        }

        try {
            moneyDueField.setText(nf.parse(Integer.toString(plot.getMoneyDue() / 100)).toString());
        } catch (ParseException pe) {
            moneyDueField.setText("");
        }

        vacantCheckBox.setSelected(plot.isVacant());
        readyCheckBox.setSelected(plot.isReady());
    }

    /**
     * Set the data from the GUI into the plot in the cemetery
     */
    public void setPlotData(Plot plot) { // TODO BAD INPUT ERROR CHECKING
        cemetery.setModified(true);

        // write the plot data from the GUI fields into the right place in the data layer
        plot.setSection(sectionField.getText()); // TODO don't let it be changed to a section that does not exist
        plot.setID(Integer.parseInt(plotIDField.getText())); // TODO hmmm what if this is changed???

        try {
            plot.setBurialDate(sdfMonth.parse(burialDateMonthField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setBurialDate(null);
        }

        try {
            plot.setBurialDate(sdfDay.parse(burialDateDayField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setBurialDate(null);
        }

        try {
            plot.setBurialDate(sdfYear.parse(burialDateYearField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setBurialDate(null);
        }

        try {
            plot.setPurchasedDate(sdfMonth.parse(purchasedDateMonthField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setPurchasedDate(null);
        }

        try {
            plot.setPurchasedDate(sdfDay.parse(purchasedDateDayField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setPurchasedDate(null);
        }

        try {
            plot.setPurchasedDate(sdfYear.parse(purchasedDateYearField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setPurchasedDate(null);
        }

        String moneyDue = moneyDueField.getText().replace("$", "").replace(".", ""); // strip symbols
        plot.setMoneyDue(Integer.parseInt(moneyDue)); // save as pennies

        plot.setVacant(vacantCheckBox.isSelected());
        plot.setReady(readyCheckBox.isSelected());
    }

    /**
     * Clear all plot data from the GUI
     */
    public void clearPlotData() {
        // clear each textfield and whatnot
        sectionField.setText("");
        plotIDField.setText("");
        burialDateMonthField.setText("");
        burialDateDayField.setText("");
        burialDateYearField.setText("");
        purchasedDateMonthField.setText("");
        purchasedDateDayField.setText("");
        purchasedDateYearField.setText("");
        moneyDueField.setText("");
        vacantCheckBox.setSelected(false);
        readyCheckBox.setSelected(false);
    }
}
