package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane allowing for the searching and listing of people in the cemetery
 * based on current selected section(s)
 */
public class CemeteryPlotterPeople extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel peoplePanel;
    private JTextField searchField;
    private JComboBox<String> searchByBox;
    private JButton searchButton;
    private JRadioButton bothRadioButton;
    private JRadioButton interredPeopleRadioButton;
    private JRadioButton ownersRadioButton;
    private ButtonGroup searchButtonGroup;
    private DefaultListModel<String> peopleListModel;
    private JList<String> peopleList;
    private JScrollPane peopleListScrollPane;

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
    public JPanel getPeoplePanel() {
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
        searchField = new JTextField();

        // create search by combo box
        String[] searchByBoxList = { "InterredID", "PlotID", "Name", "Phone",
                "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
        searchByBox = new JComboBox<>(searchByBoxList);
        searchByBox.setEditable(false);

        // create search button
        searchButton = new JButton("Search By");

        // add search by combo box and search by button to searchCenter panel
        JPanel searchCenter = new JPanel();
        searchCenter.setLayout(new BoxLayout(searchCenter, BoxLayout.LINE_AXIS));
        searchCenter.add(searchByBox);
        searchCenter.add(searchButton);

        // create search radio buttons
        interredPeopleRadioButton = new JRadioButton("Interred", false);
        ownersRadioButton = new JRadioButton("Owners", false);
        bothRadioButton = new JRadioButton("Both", true);

        // create search radio button group
        searchButtonGroup = new ButtonGroup();
        searchButtonGroup.add(interredPeopleRadioButton);
        searchButtonGroup.add(ownersRadioButton);
        searchButtonGroup.add(bothRadioButton);

        // create search radio button panel and add radio buttons to panel
        JPanel searchRadioButtonPanel = new JPanel();
        searchRadioButtonPanel.setLayout(new BoxLayout(searchRadioButtonPanel, BoxLayout.LINE_AXIS));
        searchRadioButtonPanel.add(interredPeopleRadioButton);
        searchRadioButtonPanel.add(ownersRadioButton);
        searchRadioButtonPanel.add(bothRadioButton);

        // add search field, searchCenter panel and search radio button panel to overall search panel
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.PAGE_START);
        searchPanel.add(searchCenter, BorderLayout.CENTER);
        searchPanel.add(searchRadioButtonPanel, BorderLayout.PAGE_END);

        // add search panel to main panel
        panel.add(searchPanel, BorderLayout.PAGE_START);

        // create list of sections
        peopleListModel = new DefaultListModel<>();
        peopleList = new JList<>(peopleListModel);
        peopleListScrollPane = new JScrollPane(peopleList);
        peopleListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        peopleList.setLayoutOrientation(JList.VERTICAL);
        peopleList.setPrototypeCellValue("Firstname Lastname");

        // add list to main panel
        panel.add(peopleListScrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Action listener for people content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) { // TODO add action listeners first for buttons and lists and stuff
        //
    }

    /**
     * Item state listener for people content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }

    /**
     * Get the data from cemetery about people and load it into the appropriate GUI elements
     */
    public void getPeopleData() { // TODO
        // figure out which people to put in the list (based on selected sections and radio buttons and search items, etc...)
        // this may be a tough one!!
    }
}
