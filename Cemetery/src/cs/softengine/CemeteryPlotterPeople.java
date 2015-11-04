package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

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
    private DefaultListSelectionModel peopleListSelectionModel;
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
        searchButton.setActionCommand("search");
        searchButton.addActionListener(this);

        // add search by combo box and search by button to searchCenter panel
        JPanel searchCenter = new JPanel();
        searchCenter.setLayout(new BoxLayout(searchCenter, BoxLayout.LINE_AXIS));
        searchCenter.add(searchByBox);
        searchCenter.add(searchButton);

        // create search radio buttons
        interredPeopleRadioButton = new JRadioButton("Interred", false);
        interredPeopleRadioButton.setActionCommand("interred");
        interredPeopleRadioButton.addActionListener(this);

        ownersRadioButton = new JRadioButton("Owners", false);
        ownersRadioButton.setActionCommand("owners");
        ownersRadioButton.addActionListener(this);

        bothRadioButton = new JRadioButton("Both", true);
        bothRadioButton.setActionCommand("both");
        bothRadioButton.addActionListener(this);

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

        peopleListSelectionModel = (DefaultListSelectionModel) peopleList.getSelectionModel();
        peopleListSelectionModel.addListSelectionListener(new PeopleListSelectionHandler());

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
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "interred": // refresh people list on any of these actions
            case "owners":
            case "both":
                // clear the people list
                peopleListModel.clear();
                // get the people data for each selected section
                cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections().forEach(this::getPeopleData);
                break;
            case "search": // search using searchByBox and searchField
                // TODO
                break;
        }
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
     * @param section selected in CemeteryPlotterSections
     */
    public void getPeopleData(String section) {
        // figure out which people to put in the list (based on selected sections and radio buttons and search items, etc...)
        ArrayList<String> people = new ArrayList<>();

        if (interredPeopleRadioButton.isSelected()) { // list only interred
            people.addAll(getPeopleDataInterred(section));
        } else if (ownersRadioButton.isSelected()) { // list only owners
            people.addAll(getPeopleDataOwners(section));
        } else { // bothRadioButton.isSelected() // list both interred and owners
            people.addAll(getPeopleDataInterred(section));
            people.addAll(getPeopleDataOwners(section));
        }

        // sort the list of people using default String comparator
        Collections.sort(people);

        // add each person to the people list
        for (String p : people) {
            peopleListModel.addElement(p);
        }
    }

    /**
     * Get the data from cemetery about the interred people in the selected section(s)
     * @param section selected in CemeteryPlotterSections
     * @return list of interred people
     */
    private ArrayList<String> getPeopleDataInterred(String section) {
        Section s = cemetery.get(new Section(section));
        ArrayList<String> results = new ArrayList<>(s.getSize());

        for (Plot p : s.getPlots()) {
            InterredPerson ip = p.getInterred();
            if (ip != null) {
                // TODO switch based on searchByBox (to show burial date instead of name for example)
                results.add(ip.getLastName() + ", " + ip.getFirstName());
            }
        }

        return results;
    }

    /**
     * Get the data from cemetery about the owner of plots in the selected section(s)
     * @param section selected in CeneteryPlotterSections
     * @return list of owners
     */
    private ArrayList<String> getPeopleDataOwners(String section) {
        Section s = cemetery.get(new Section(section));
        ArrayList<String> results = new ArrayList<>(s.getSize());

        for (Plot p : s.getPlots()) {
            Person o = p.getOwner();
            if (o != null) {
                // TODO switch based on searchByBox (to show ID instead of name for example)
                results.add(o.getLastName() + ", " + o.getFirstName());
            }
        }

        return results;
    }

    /**
     * Clear the people list
     */
    public void clearPeopleList() {
        peopleListModel.clear();
    }

    /**
     * Implementation of ListSelectionListener that is invoked when selections are made on the people list
     */
    class PeopleListSelectionHandler implements ListSelectionListener {

        /**
         * Called automatically when selections are made
         * @param e ListSelectionEvent
         */
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting();

            if (!isAdjusting) {
                if (lsm.isSelectionEmpty()) { // no selection
                    // TODO clear all the fields and set to not editable, disable edit buttons...
                    // TODO must interact nicely with people list selections
                } else { // show the selected person
                    int index = lsm.getMinSelectionIndex();
                    // TODO enable edit buttons, then set fields to editable and show their data
                    // TODO must interact nicely with people list selections
                    System.out.println("Selected Person: " + peopleListModel.get(index)); // TEMP
                }
            }
        }
    }
}
