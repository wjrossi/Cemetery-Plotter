package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane allowing for the searching and listing of people in the cemetery
 */
public class CemeteryPlotterPeople {
    private JPanel peoplePanel;

    /**
     * Constructs a content pane for searching and listing of people
     */
    public CemeteryPlotterPeople() {
        peoplePanel = createPeoplePanel();
    }

    /**
     * Get people panel
     * @return peoplePanel
     */
    public JPanel getPanel() {
        return peoplePanel;
    }

    /**
     * Create people panel
     * @return panel
     */
    private JPanel createPeoplePanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "People");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        // create search text field
        JTextField searchField = new JTextField();

        // create search by combo box
        String[] searchByBoxList = { "InterredID", "PlotID", "Name", "Phone",
                "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
        JComboBox<String> searchByBox = new JComboBox<String>(searchByBoxList);
        searchByBox.setEditable(false);

        // create search button
        JButton searchButton = new JButton("Search By");

        // add search by combo box and search by button to searchCenter panel
        JPanel searchCenter = new JPanel();
        searchCenter.setLayout(new BoxLayout(searchCenter, BoxLayout.LINE_AXIS));
        searchCenter.add(searchByBox);
        searchCenter.add(searchButton);

        // create search radio buttons
        JRadioButton allRadioButton = new JRadioButton("All", true);
        JRadioButton interredPeopleRadioButton = new JRadioButton("Interred", false);
        JRadioButton ownersRadioButton = new JRadioButton("Owners", false);

        // create search radio button group
        ButtonGroup searchButtonGroup = new ButtonGroup();
        searchButtonGroup.add(allRadioButton);
        searchButtonGroup.add(interredPeopleRadioButton);
        searchButtonGroup.add(ownersRadioButton);

        // create search radio button panel and add radio buttons to panel
        JPanel searchRadioButtonPanel = new JPanel();
        searchRadioButtonPanel.setLayout(new BoxLayout(searchRadioButtonPanel, BoxLayout.LINE_AXIS));
        searchRadioButtonPanel.add(allRadioButton);
        searchRadioButtonPanel.add(interredPeopleRadioButton);
        searchRadioButtonPanel.add(ownersRadioButton);

        // add search field, searchCenter panel and search radio button panel to overall search panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.PAGE_START);
        searchPanel.add(searchCenter, BorderLayout.CENTER);
        searchPanel.add(searchRadioButtonPanel, BorderLayout.PAGE_END);

        // add search panel to main panel
        panel.add(searchPanel, BorderLayout.PAGE_START);

        // create list of sections
        JList<String> sectionList = new JList<String>();
        JScrollPane sectionListScrollPane = new JScrollPane(sectionList);
        sectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sectionList.setLayoutOrientation(JList.VERTICAL);
        sectionList.setPrototypeCellValue("Firstname Lastname");

        // add list to main panel
        panel.add(sectionListScrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Action listener for people content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for people content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
