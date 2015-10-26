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
public class CemeteryPlotterPlot implements ActionListener, ItemListener {
    private JPanel plotPanel;
    private ArrayList<JComponent> editable;
    private SimpleDateFormat sdf;
    private NumberFormat nf;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        editable = new ArrayList<JComponent>();
        sdf = new SimpleDateFormat("MM/DD/YYYY");
        nf = NumberFormat.getCurrencyInstance();
        plotPanel = createPlotPanel();
    }

    /**
     * Get plot info panel
     * @return plotPanel
     */
    public JPanel getPanel() {
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

        // add things to panel

        // create labels
        JLabel sectionLabel = new JLabel("Section:");
        JLabel plotIDLabel = new JLabel("Plot ID#:");
        JLabel burialDateLabel = new JLabel("Burial Date:");
        JLabel purchasedDateLabel = new JLabel("Purchased Date:");
        JLabel moneyDueLabel = new JLabel("Amount Owed:");

        // create text fields
        JTextField sectionField = new JTextField(6);
        JTextField plotIDField = new JTextField(4);
        JFormattedTextField burialDateField = new JFormattedTextField(sdf);
        JFormattedTextField purchasedDateField = new JFormattedTextField(sdf);
        JFormattedTextField moneyDueField = new JFormattedTextField(nf);

        // set labels to text fields
        sectionLabel.setLabelFor(sectionField);
        plotIDLabel.setLabelFor(plotIDField);
        burialDateLabel.setLabelFor(burialDateField);
        purchasedDateLabel.setLabelFor(purchasedDateField);
        moneyDueLabel.setLabelFor(moneyDueField);

        // create status check boxes
        JCheckBox vacantCheckBox = new JCheckBox("Vacant:", false);
        JCheckBox readyCheckBox = new JCheckBox("Ready:", false);

        // create edit button
        JButton editButton = new JButton("Edit"); // when clicked will unlock text fields and allow changes

        // create sub-panels
        JPanel idPanel = new JPanel();
        JPanel burialDatePanel = new JPanel();
        JPanel purchasedDatePanel = new JPanel();
        JPanel moneyDuePanel = new JPanel();
        JPanel checkBoxPanel = new JPanel();

        idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.LINE_AXIS));
        burialDatePanel.setLayout(new BoxLayout(burialDatePanel, BoxLayout.LINE_AXIS));
        purchasedDatePanel.setLayout(new BoxLayout(purchasedDatePanel, BoxLayout.LINE_AXIS));
        moneyDuePanel.setLayout(new BoxLayout(moneyDuePanel, BoxLayout.LINE_AXIS));
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.LINE_AXIS));

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

        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(idPanel);
        fieldsPanel.add(burialDatePanel);
        fieldsPanel.add(purchasedDatePanel);
        fieldsPanel.add(moneyDuePanel);
        fieldsPanel.add(checkBoxPanel);

        panel.add(fieldsPanel, BorderLayout.PAGE_START);
        panel.add(editButton, BorderLayout.PAGE_END);

        // add editable components to list for easy enable/disable
        editable.add(sectionField);
        editable.add(plotIDField);
        editable.add(burialDateField);
        editable.add(purchasedDateField);
        editable.add(moneyDueField);
        editable.add(vacantCheckBox);
        editable.add(readyCheckBox);

        return panel;
    }

    /**
     * Action listener for plot info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for plot info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
