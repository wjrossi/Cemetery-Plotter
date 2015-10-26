package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Content pane containing editable information of an interred person
 */
public class CemeteryPlotterInterredPerson implements ActionListener, ItemListener {
    private JPanel interredPanel;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");

    /**
     * Constructs a content pane for an interred person info
     */
    public CemeteryPlotterInterredPerson() {
        interredPanel = createInterredPersonPanel();
    }

    /**
     * Get interred person info panel
     * @return interredPanel
     */
    public JPanel getPanel() {
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

        // add things to panel

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
        JLabel bornDateLabel = new JLabel("Born (MM/DD/YYYY):");
        JLabel diedDateLabel = new JLabel("Died (MM/DD/YYYY):");

        // create text fields
        JTextField interredIDField = new JTextField(4);
        JTextField plotIDField = new JTextField(4);
        JTextField fnameField = new JTextField(8);
        JTextField lnameField = new JTextField(8);
        JTextField address1Field = new JTextField(16);
        JTextField address2Field = new JTextField(16);
        JTextField cityField = new JTextField(8);
        JTextField stateField = new JTextField(1);
        JTextField zipField = new JTextField(2);
        JTextField phoneField = new JTextField(8);
        JFormattedTextField bornDateField = new JFormattedTextField(sdf);
        JFormattedTextField diedDateField = new JFormattedTextField(sdf);

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

        // create edit button
        JButton editButton = new JButton("Edit"); // when clicked will unlock text fields and allow changes

        // create sub-panels
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.LINE_AXIS));


        // add items to sub-panels
        namePanel.add(fnameLabel);
        namePanel.add(fnameField);
        namePanel.add(lnameLabel);
        namePanel.add(lnameField);


        // add sub-panels to main panel
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        fieldsPanel.add(namePanel);


        panel.add(fieldsPanel, BorderLayout.PAGE_START);

        return panel;
    }

    /**
     * Action listener for interred person info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for interred person info content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
