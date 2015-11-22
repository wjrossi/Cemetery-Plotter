package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
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
    private JRadioButton contactsRadioButton;
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
        filterByBoxList = new String[] { "Last Name, First Name" };
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

        contactsRadioButton = new JRadioButton("Contacts", false);
        contactsRadioButton.setActionCommand("contacts");
        contactsRadioButton.addActionListener(this);

        bothRadioButton = new JRadioButton("Both", true);
        bothRadioButton.setActionCommand("both");
        bothRadioButton.addActionListener(this);

        // create filter radio button group
        filterButtonGroup = new ButtonGroup();
        filterButtonGroup.add(interredPeopleRadioButton);
        filterButtonGroup.add(contactsRadioButton);
        filterButtonGroup.add(bothRadioButton);

        // create filter radio button panel and add radio buttons to panel
        JPanel filterRadioButtonPanel = new JPanel();
        filterRadioButtonPanel.setLayout(new BoxLayout(filterRadioButtonPanel, BoxLayout.LINE_AXIS));
        filterRadioButtonPanel.add(interredPeopleRadioButton);
        filterRadioButtonPanel.add(contactsRadioButton);
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
        peopleList.setPrototypeCellValue("Lastname, Firstname [Plot #: 12345]");

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
                filterByBoxList = new String[] { "InterredID", "Last Name, First Name",
                        "Date of Burial", "Date of Purchase" };
                filterByBoxListModel = new DefaultComboBoxModel<>(filterByBoxList);
                filterByBox.setModel(filterByBoxListModel);

                // clear the people list
                peopleListModel.clear();
                // get the people data for each selected section
                getPeopleData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());
                break;
            case "contacts":
                // change filterBy list to reflect the type or people being viewed
                filterByBoxListModel.removeAllElements();
                filterByBoxList = new String[] { "ContactID", "Last Name, First Name", "Phone",
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
                filterByBoxList = new String[] { "Last Name, First Name" };
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
    public void getPeopleData(Collection<String> sections) {
        // figure out which people to put in the list (based on selected sections and radio buttons and filter items, etc...)
        ArrayList<String> people = new ArrayList<>();

        for (String section : sections) {
            if (interredPeopleRadioButton.isSelected()) { // list only interred
                people.addAll(getPeopleDataInterred(section));
            } else if (contactsRadioButton.isSelected()) { // list only contacts
                people.addAll(getPeopleDataContact(section));
            } else { // bothRadioButton.isSelected() // list both interred and contacts
                people.addAll(getPeopleDataInterred(section));
                people.addAll(getPeopleDataContact(section));
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
                results.add(ip.getLastName() + ", " + ip.getFirstName() + " [Plot #" + ip.getPlotID() + "]");
            }
        }

        return results;
    }

    /**
     * Get the data from cemetery about the contact of plots in the selected section(s)
     * @param section selected in CemeteryPlotterSections
     * @return list of contacts
     */
    private ArrayList<String> getPeopleDataContact(String section) {
        Section s = cemetery.get(new Section(section));
        ArrayList<String> results = new ArrayList<>(s.getSize());

        for (Plot plot : s.getPlots()) {
            Person p = plot.getContact();
            if (p != null) {
                // TODO switch based on filterByBox (to show ID instead of name for example)
                results.add(p.getLastName() + ", " + p.getFirstName());
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
     * Refresh the people list when an interred person or contact has been updated
     */
    public void refreshPeopleList() {
        int index = peopleList.getSelectedIndex();
        clearPeopleList();
        getPeopleData(cemeteryPlotterFrame.cemeteryPlotterSections.getSelectedSections());

        if (index >= 0) {
            peopleList.setSelectedIndex(index);
        }
    }

    /**
     * Get the people list
     * @return peopleListModel
     */
    public DefaultListModel<String> getPeopleListModel() {
        return peopleListModel;
    }

    /**
     * Get people list
     * @return peopleList
     */
    public JList<String> getPeopleList() {
        return peopleList;
    }

    /**
     * Set selected person
     * @param index of person in peopleList
     */
    public void setSelectedPerson(int index) {
        peopleList.setSelectedIndex(index);
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
                if (!lsm.isSelectionEmpty()) { // show the selected person
                    int index = lsm.getMinSelectionIndex();
                    String selection = peopleListModel.get(index);
                    String id = "";
                    if (selection.indexOf("[Plot #") > 0) {
                        id = selection.substring(selection.lastIndexOf("[Plot #") + 7, selection.lastIndexOf("]"));
                        if (!id.isEmpty()) {
                            int plotsIndex = cemeteryPlotterFrame.cemeteryPlotterPlots.getPlotsListModel().indexOf(id);
                            cemeteryPlotterFrame.cemeteryPlotterPlots.setSelectedPlot(plotsIndex);
                        }
                    }
                }
            }
        }
    }
}
