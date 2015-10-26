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
        JLabel interredIDLabel = new JLabel("Interred ID#:");
        JLabel plotIDLabel = new JLabel("Plot ID#:");
        JLabel fnameLabel = new JLabel("First Name:");
        JLabel lnameLabel = new JLabel("Last Name:");
        JLabel address1Label = new JLabel("Address 1:");
        JLabel address2Label = new JLabel("Address 2:");
        JLabel cityLabel = new JLabel("City:");
        JLabel stateLabel = new JLabel("State:");
        JLabel zipLabel = new JLabel("Zip:");
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel bornDateLabel = new JLabel("Date of Birth (MM/DD/YYYY):");
        JLabel diedDateLabel = new JLabel("Date of Death (MM/DD/YYYY):");

        // create text fields
        JTextField interredIDField = new JTextField();
        JTextField plotIDField = new JTextField();
        JTextField fnameField = new JTextField();
        JTextField lnameField = new JTextField();
        JTextField address1Field = new JTextField();
        JTextField address2Field = new JTextField();
        JTextField cityField = new JTextField();
        JTextField stateField = new JTextField();
        JTextField zipField = new JTextField();
        JTextField phoneField = new JTextField();
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


        // add items to sub-panels


        // add sub-panels to main panel



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
