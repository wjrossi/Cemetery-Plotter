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
 * Content pane allowing for the filtering and listing of people in the cemetery
 * based on current selected section(s)
 */
public class CemeteryPlotterPeople extends CemeteryPlotter implements ActionListener {
    private JPanel peoplePanel;
    private JTextField filterField;
    private JComboBox<String> filterByBox;
    private DefaultComboBoxModel<String> filterByBoxListModel;
    private String[] filterByBoxList;
    private JRadioButton bothRadioButton;
    private JRadioButton interredPeopleRadioButton;
    private JRadioButton ownersRadioButton;
    private ButtonGroup filterButtonGroup;
    private DefaultListModel<String> peopleListModel;
    private DefaultListSelectionModel peopleListSelectionModel;
    private JList<String> peopleList;
    private JScrollPane peopleListScrollPane;

    /**
     * Constructs a content pane for filtering and listing of people
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

        // create filter text field
        filterField = new JTextField(); // TODO add listener that searches as you type

        // create filter by combo box
        filterByBoxList = new String[] { "Last Name, First Name", "Phone",
                "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
        filterByBoxListModel = new DefaultComboBoxModel<>(filterByBoxList);
        filterByBox = new JComboBox<>(filterByBoxListModel);
        filterByBox.setEditable(false);

        // add filter by combo box to filterCenter panel
        JPanel filterCenter = new JPanel();
        filterCenter.setLayout(new BoxLayout(filterCenter, BoxLayout.LINE_AXIS));
        filterCenter.add(filterByBox);

        // create filter radio buttons
        interredPeopleRadioButton = new JRadioButton("Interred", false);
        interredPeopleRadioButton.setActionCommand("interred");
        interredPeopleRadioButton.addActionListener(this);

        ownersRadioButton = new JRadioButton("Owners", false);
        ownersRadioButton.setActionCommand("owners");
        ownersRadioButton.addActionListener(this);

        bothRadioButton = new JRadioButton("Both", true);
        bothRadioButton.setActionCommand("both");
        bothRadioButton.addActionListener(this);

        // create filter radio button group
        filterButtonGroup = new ButtonGroup();
        filterButtonGroup.add(interredPeopleRadioButton);
        filterButtonGroup.add(ownersRadioButton);
        filterButtonGroup.add(bothRadioButton);

        // create filter radio button panel and add radio buttons to panel
        JPanel filterRadioButtonPanel = new JPanel();
        filterRadioButtonPanel.setLayout(new BoxLayout(filterRadioButtonPanel, BoxLayout.LINE_AXIS));
        filterRadioButtonPanel.add(interredPeopleRadioButton);
        filterRadioButtonPanel.add(ownersRadioButton);
        filterRadioButtonPanel.add(bothRadioButton);

        // add filter field, filterCenter panel and filter radio button panel to overall filter panel
        JPanel filterPanel = new JPanel(new BorderLayout());
        filterPanel.add(filterField, BorderLayout.PAGE_START);
        filterPanel.add(filterCenter, BorderLayout.CENTER);
        filterPanel.add(filterRadioButtonPanel, BorderLayout.PAGE_END);

        // add filter panel to main panel
        panel.add(filterPanel, BorderLayout.PAGE_START);

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
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "interred": // refresh people list on any of these actions
                // change filterBy list to reflect the type or people being viewed
                filterByBoxListModel.removeAllElements();
                filterByBoxList = new String[] { "InterredID", "Last Name, First Name", "Phone",
                        "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
                filterByBoxListModel = new DefaultComboBoxModel<>(filterByBoxList);
                filterByBox.setModel(filterByBoxListModel);

                // clear the people list
                peopleListModel.clear();
                // get the people data for each selected section
                getPeopleData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                break;
            case "owners":
                // change filterBy list to reflect the type or people being viewed
                filterByBoxListModel.removeAllElements();
                filterByBoxList = new String[] { "OwnerID", "Last Name, First Name", "Phone",
                        "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
                filterByBoxListModel = new DefaultComboBoxModel<>(filterByBoxList);
                filterByBox.setModel(filterByBoxListModel);

                // clear the people list
                peopleListModel.clear();
                // get the people data for each selected section
                getPeopleData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                break;
            case "both":
                // change filterBy list to reflect the type or people being viewed
                filterByBoxListModel.removeAllElements();
                filterByBoxList = new String[] { "Last Name, First Name", "Phone",
                        "Date of Birth", "Date of Death", "Address", "City", "State", "Zip" };
                filterByBoxListModel = new DefaultComboBoxModel<>(filterByBoxList);
                filterByBox.setModel(filterByBoxListModel);

                // clear the people list
                peopleListModel.clear();
                // get the people data for each selected section
                getPeopleData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                break;
        }
    }

    /**
     * Get the data from cemetery about people and load it into the appropriate GUI elements
     * @param sections list of sections selected in CemeteryPlotterSections
     */
    public void getPeopleData(ArrayList<String> sections) {
        // figure out which people to put in the list (based on selected sections and radio buttons and filter items, etc...)
        ArrayList<String> people = new ArrayList<>();

        for (String section : sections) {
            if (interredPeopleRadioButton.isSelected()) { // list only interred
                people.addAll(getPeopleDataInterred(section));
            } else if (ownersRadioButton.isSelected()) { // list only owners
                people.addAll(getPeopleDataOwners(section));
            } else { // bothRadioButton.isSelected() // list both interred and owners
                people.addAll(getPeopleDataInterred(section));
                people.addAll(getPeopleDataOwners(section));
            }
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
                // TODO switch based on filterByBox (to show burial date instead of name for example)
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
                // TODO switch based on filterByBox (to show ID instead of name for example)
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
                    // TODO must interact nicely with plot list selections
                    // should probably defer to plot list select, if any
                } else { // show the selected person
                    int index = lsm.getMinSelectionIndex();
                    // TODO must interact nicely with plot list selections
                    // probably should select the associated plotID in the plots list which will make it show in the center
                    System.out.println("Selected Person: " + peopleListModel.get(index)); // TEMP
                }
            }
        }
    }
}
