package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterPlot extends CemeteryPlotter implements ActionListener {
    private JPanel plotPanel;
    private JTextField sectionField;
    private JTextField plotIDField;
    private JTextField burialDateMonthField;
    private JTextField burialDateDayField;
    private JTextField burialDateYearField;
    private JTextField purchasedDateMonthField;
    private JTextField purchasedDateDayField;
    private JTextField purchasedDateYearField;
    private JTextField moneyDueField;
    private JCheckBox vacantCheckBox;
    private JCheckBox readyCheckBox;
    private JButton editButton;
    private JButton cancelButton;
    private JButton updateButton;
    private ArrayList<JComponent> editable;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        editable = new ArrayList<>();
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
        moneyDueLabel.setToolTipText("e.g., $1234.56 or $7890");

        // create text fields
        sectionField = new JTextField(6);
        plotIDField = new JTextField(4);
        burialDateMonthField = new JTextField(2);
        burialDateDayField = new JTextField(2);
        burialDateYearField = new JTextField(4);
        purchasedDateMonthField = new JTextField(2);
        purchasedDateDayField = new JTextField(2);
        purchasedDateYearField = new JTextField(4);
        moneyDueField = new JTextField(8);

        sectionField.setEnabled(false); // TODO possibly enable to create new plots
        plotIDField.setEnabled(false);

        burialDateMonthField.setToolTipText("MM");
        burialDateDayField.setToolTipText("DD");
        burialDateYearField.setToolTipText("YYYY");
        purchasedDateMonthField.setToolTipText("MM");
        purchasedDateDayField.setToolTipText("DD");
        purchasedDateYearField.setToolTipText("YYYY");
        moneyDueField.setToolTipText("e.g., $1234.56 or $7890");

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
        //editable.add(sectionField);
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
        editButton.setEnabled(false);
        cancelButton.requestFocus();
    }

    /**
     * Update button's action for the plot's data
     */
    public void updatePlot() {
        String section = sectionField.getText().toUpperCase();

        if (cemetery.get(new Section(section)) == null) { // invalid section name
            sectionField.requestFocus();
            sectionField.selectAll();
        } else { // valid section name, update plot
            setPlotEditable(false);
            editButton.setEnabled(true);
            setPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
            clearPlotData();
            getPlotData(cemeteryPlotterFrame.cemeteryPlotterPlots.getSelectedPlot());
            // TODO call something that updates section list, plot list, and/or people list, if necessary
            editButton.requestFocus();
        }
    }

    /**
     * Cancel button's action for the plot's data
     */
    public void cancelPlot() {
        setPlotEditable(false);
        editButton.setEnabled(true);
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
        if (plot != null) {
            sectionField.setText(plot.getSection());
            plotIDField.setText(Integer.toString(plot.getID()));

            burialDateMonthField.setText(plot.getBurialDateMonth());
            burialDateDayField.setText(plot.getBurialDateDay());
            burialDateYearField.setText(plot.getBurialDateYear());

            purchasedDateMonthField.setText(plot.getPurchasedDateMonth());
            purchasedDateDayField.setText(plot.getPurchasedDateDay());
            purchasedDateYearField.setText(plot.getPurchasedDateYear());

            moneyDueField.setText(plot.getMoneyDue());

            vacantCheckBox.setSelected(plot.isVacant());
            readyCheckBox.setSelected(plot.isReady());
        } else { // setting up a new plot
            plotIDField.setText(Integer.toString(cemetery.getNextPlotID()));
        }
    }

    /**
     * Set the data from the GUI into the plot in the cemetery
     */
    public void setPlotData(Plot plot) { // TODO BAD INPUT ERROR CHECKING
        cemetery.setModified(true);

        if (plot == null) {
            plot = new Plot();
            cemetery.setNextPlotID();
        }

        // write the plot data from the GUI fields into the right place in the data layer
        plot.setSection(sectionField.getText().toUpperCase()); // TODO don't let it be changed to a section that does not exist
        plot.setID(Integer.parseInt(plotIDField.getText()));

        plot.setBurialDateMonth(burialDateMonthField.getText());
        plot.setBurialDateDay(burialDateDayField.getText());
        plot.setBurialDateYear(burialDateYearField.getText());

        plot.setPurchasedDateMonth(purchasedDateMonthField.getText());
        plot.setPurchasedDateDay(purchasedDateDayField.getText());
        plot.setPurchasedDateYear(purchasedDateYearField.getText());

        plot.setMoneyDue(moneyDueField.getText());

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
