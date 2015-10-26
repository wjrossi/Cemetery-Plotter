package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterPlot implements ActionListener, ItemListener {
    private JPanel plotPanel;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
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
        JTextField sectionField = new JTextField(8);
        JTextField plotIDField = new JTextField(8);
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

        // add items to sub-panels

        // add sub-panels to main panel


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
