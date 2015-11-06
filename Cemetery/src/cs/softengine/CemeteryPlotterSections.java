package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Content pane for selecting section(s) of the cemetery
 */
public class CemeteryPlotterSections extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel sectionsPanel;
    private JButton selectAllButton;
    private JButton selectNoneButton;
    private DefaultListModel<String> sectionsListModel;
    private DefaultListSelectionModel sectionsListSelectionModel;
    private JList<String> sectionsList;
    private JScrollPane sectionsListScrollPane;
    private JButton newSectionButton;
    private JButton deleteSectionButton;

    /**
     * Constructs a content pane for selecting section(s)
     */
    public CemeteryPlotterSections() {
        sectionsPanel = createSectionsPanel();
    }

    /**
     * Get section panel
     * @return sectionsPanel
     */
    public JPanel getSectionsPanel() {
        return sectionsPanel;
    }

    /**
     * Create section panel
     * @return panel
     */
    private JPanel createSectionsPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Sections");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // create buttons
        selectAllButton = new JButton("Select All");
        selectAllButton.setActionCommand("select all");
        selectAllButton.addActionListener(this);

        selectNoneButton = new JButton("Select None");
        selectNoneButton.setActionCommand("select none");
        selectNoneButton.addActionListener(this);

        // put buttons in a button panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.add(selectAllButton);
        buttons.add(selectNoneButton);

        // add button panel to main panel
        panel.add(buttons, BorderLayout.PAGE_START);

        // create list of sections
        sectionsListModel = new DefaultListModel<>();
        sectionsList = new JList<>(sectionsListModel);

        sectionsListSelectionModel = (DefaultListSelectionModel) sectionsList.getSelectionModel();
        sectionsListSelectionModel.addListSelectionListener(new SectionsListSelectionHandler());

        sectionsListScrollPane = new JScrollPane(sectionsList);
        sectionsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sectionsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sectionsList.setLayoutOrientation(JList.VERTICAL);
        sectionsList.setPrototypeCellValue("ABCDEFGH");
        sectionsList.setToolTipText("Select the section(s) to list their plots below.");

        // create new and delete buttons
        newSectionButton = new JButton("New Section");
        newSectionButton.setToolTipText("Create and add a new section to the cemetery.");
        newSectionButton.setActionCommand("new section");
        newSectionButton.addActionListener(this);

        deleteSectionButton = new JButton("Delete Section(s)");
        deleteSectionButton.setToolTipText("Permanently delete the selected section(s) from the cemetery.");
        deleteSectionButton.setActionCommand("delete section");
        deleteSectionButton.addActionListener(this);

        JPanel sectionButtonsPanel = new JPanel();
        sectionButtonsPanel.setLayout(new BoxLayout(sectionButtonsPanel, BoxLayout.LINE_AXIS));
        sectionButtonsPanel.add(newSectionButton);
        sectionButtonsPanel.add(deleteSectionButton);

        // add list to main panel
        panel.add(sectionsListScrollPane, BorderLayout.CENTER);
        panel.add(sectionButtonsPanel, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Action listener for sections content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();

        switch (action) {
            case "select all": // select anything in the list
                sectionsListSelectionModel.setSelectionInterval(0, sectionsListModel.size()-1);
                break;
            case "select none": // deselect all things in the list
                sectionsListSelectionModel.clearSelection();
                break;
            case "new section": // TODO
                // add a new section to the cemetery and list/listmodel
                break;
            case "delete section": // TODO
                // delete selected section(s) from the cemetery and list/listmodel
                // what should happen to the plots in that section, if there are any?
                // a) delete them too?
                // b) put them in some kind of "blank" section?
                break;
        }
    }

    /**
     * Item state listener for sections content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }

    /**
     * Get the data from cemetery about sections and load it into the appropriate GUI elements
     */
    public void getSectionsData() {
        for (Section s : cemetery.getSections()) {
            sectionsListModel.addElement(s.getName());
        }
    }

    /**
     * Set the data from the GUI into the Cemetery and Section in the cemetery
     */
    public void setSectionsData() { // TODO on new or delete section(s) probably
        // write the sections data from the GUI fields into the right place in the data layer
        // used when a section is added or deleted
    }

    /**
     * Gets the selected sections
     * @return list of selected section names
     */
    public ArrayList<String> getSelectedSections() {
        return (ArrayList<String>) sectionsList.getSelectedValuesList();
    }

    /**
     * Implementation of ListSelectionListener that is invoked when selections are made on the sections list
     */
    class SectionsListSelectionHandler implements ListSelectionListener {

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
                cemeteryPlotterFrame.cemeteryPlotterPlot.clearPlotData();
                cemeteryPlotterFrame.cemeteryPlotterPlot.setPlotEditable(false);
                cemeteryPlotterFrame.cemeteryPlotterInterredPerson.clearInterredData();
                cemeteryPlotterFrame.cemeteryPlotterInterredPerson.setInterredEditable(false);
                cemeteryPlotterFrame.cemeteryPlotterOwner.clearOwnerData();
                cemeteryPlotterFrame.cemeteryPlotterOwner.setOwnerEditable(false);

                cemeteryPlotterFrame.cemeteryPlotterPlots.clearPlotsList();
                cemeteryPlotterFrame.cemeteryPlotterPeople.clearPeopleList();

                if (!lsm.isSelectionEmpty()) { // find out which indexes are selected.
                    cemeteryPlotterFrame.cemeteryPlotterPlots.getPlotsData((ArrayList<String>) sectionsList.getSelectedValuesList());
                    cemeteryPlotterFrame.cemeteryPlotterPeople.getPeopleData((ArrayList<String>) sectionsList.getSelectedValuesList());
                }
            }
        }
    }
}
