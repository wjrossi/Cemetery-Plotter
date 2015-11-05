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
public class CemeteryPlotterPlot extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel plotPanel;
    private JTextField sectionField;
    private JTextField plotIDField;
    private JFormattedTextField burialDateField;
    private JFormattedTextField purchasedDateField;
    private JFormattedTextField moneyDueField;
    private JCheckBox vacantCheckBox;
    private JCheckBox readyCheckBox;
    private JButton editButton;
    private JButton cancelButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;
    private SimpleDateFormat sdf;
    private NumberFormat nf;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        editable = new ArrayList<>();
        sdf = new SimpleDateFormat("MM/dd/yyyy");
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

        burialDateLabel.setToolTipText("MM/DD/YYYY");
        purchasedDateLabel.setToolTipText("MM/DD/YYYY");
        moneyDueLabel.setToolTipText("$123.45");

        // create text fields
        sectionField = new JTextField(6);
        plotIDField = new JTextField(4);
        burialDateField = new JFormattedTextField(sdf);
        purchasedDateField = new JFormattedTextField(sdf);
        moneyDueField = new JFormattedTextField(nf);

        burialDateField.setColumns(10);
        purchasedDateField.setColumns(10);
        moneyDueField.setColumns(8);

        // set labels to text fields
        sectionLabel.setLabelFor(sectionField);
        plotIDLabel.setLabelFor(plotIDField);
        burialDateLabel.setLabelFor(burialDateField);
        purchasedDateLabel.setLabelFor(purchasedDateField);
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
        burialDatePanel.add(burialDateField);

        purchasedDatePanel.add(purchasedDateLabel);
        purchasedDatePanel.add(purchasedDateField);

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
        editable.add(burialDateField);
        editable.add(purchasedDateField);
        editable.add(moneyDueField);
        editable.add(vacantCheckBox);
        editable.add(readyCheckBox);
        editable.add(editButton);
        editable.add(cancelButton);
        editable.add(updateButton);

        // disable editable fields until a plot is selected and edit button is pressed
        setPlotEditable();
        return panel;
    }

    /**
     * Enable or disable fields belonging to editable list
     */
    public void setPlotEditable() {
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
                setPlotEditable();
                cancelButton.requestFocus();
                break;
            case "update":
                // write changes to plot using an additional method or call
                setPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                setPlotEditable();
                editButton.requestFocus();
                break;
            case "cancel":
                // revert changes by reloading info into fields
                editButton.setEnabled(false);
                setPlotEditable();
                clearPlotData();
                getPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
                editButton.requestFocus();
                break;
        }
    }

    /**
     * Item state listener for plot info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
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
            burialDateField.setText(plot.getBurialDate().toString());
        } catch (NullPointerException npe) {
            burialDateField.setText("");
        }

        try {
            purchasedDateField.setText(plot.getPurchasedDate().toString());
        } catch (NullPointerException npe) {
            purchasedDateField.setText("");
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
        cemetery.setModified();

        // write the plot data from the GUI fields into the right place in the data layer
        plot.setSection(sectionField.getText());
        plot.setID(Integer.parseInt(plotIDField.getText()));

        try {
            plot.setBurialDate(sdf.parse(burialDateField.getText()));
        } catch (ParseException pe) { // TODO show error??
            plot.setBurialDate(null);
        }

        try {
            plot.setPurchasedDate(sdf.parse(purchasedDateField.getText()));
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
        burialDateField.setText("");
        purchasedDateField.setText("");
        moneyDueField.setText("");
        vacantCheckBox.setSelected(false);
        readyCheckBox.setSelected(false);
    }
}
