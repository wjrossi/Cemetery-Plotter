package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Content pane for selecting section(s) of the cemetery
 */
public class CemeteryPlotterSections extends CemeteryPlotter implements ActionListener {
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
        deleteSectionButton.setToolTipText("Delete the selected section(s) from the cemetery and their plots, if any exist.");
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
            case "new section": // add a new section
                newSection();
                break;
            case "delete section": // delete selected section(s)
                deleteSection();
                break;
        }
    }

    /**
     * Create a new section
     */
    public void newSection() {
        Section section;

        String name = (String) JOptionPane.showInputDialog(
                cemeteryPlotterFrame.getFrame(),
                "Section Name:",
                "Add New Section",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");

        if (name != null && !name.isEmpty()) {
            section = new Section(name);
            cemetery.add(section);
            refreshSectionsList();
            cemetery.setModified(true);
        }
    }

    /**
     * Delete the selected section(s)
     */
    public void deleteSection() {
        boolean plotsExist = false;
        int delete;

        for (String section : getSelectedSections()) {
            plotsExist = cemetery.get(new Section(section)).getSize() > 0;
        }

        // if there are plots in any of the selected sections display a warning
        if (plotsExist) {
            delete = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "You are about to delete section(s) that contain plots.\n" +
                            "All section(s) and plots will be deleted.\n" +
                            "Are you sure you want to continue?",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);
        } else {
            delete = JOptionPane.showOptionDialog(cemeteryPlotterFrame.getFrame(),
                    "You are about to delete section(s).\n" +
                            "Are you sure you want to continue?",
                    "Are you sure?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    null,
                    null);
        }

        if (delete == JOptionPane.YES_OPTION) { // delete section(s) and their plots
            for (String s : getSelectedSections()) {
                Section section = cemetery.get(new Section(s));
                cemetery.remove(section);
                for (Plot plot : section.getPlots()) {
                    cemetery.getPlots().remove(plot);
                    cemetery.getInterred().remove(plot.getInterred());
                    cemetery.getContacts().remove(plot.getContact());
                }
            }
            refreshSectionsList();
            cemetery.setModified(true);
        }
    }

    /**
     * Get the data from cemetery about sections and load it into the appropriate GUI elements
     */
    public void getSectionsData() {
        ArrayList<String> sections = new ArrayList<>();

        for (Section section : cemetery.getSections()) {
            sections.add(section.getName());
        }

        sectionsListModel.clear();

        // sort the list of people using default String comparator
        Collections.sort(sections);

        // add each person to the people list
        for (String section : sections) {
            sectionsListModel.addElement(section);
        }
    }

    /**
     * Gets the selected sections
     * @return list of selected section names
     */
    public Collection<String> getSelectedSections() {
        return sectionsList.getSelectedValuesList();
    }

    /**
     * Refresh the sections list when sections have been updated
     */
    public void refreshSectionsList() {
        getSectionsData();
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
                cemeteryPlotterFrame.cemeteryPlotterContact.clearContactData();
                cemeteryPlotterFrame.cemeteryPlotterContact.setContactEditable(false);

                cemeteryPlotterFrame.cemeteryPlotterPlots.clearPlotsList();
                cemeteryPlotterFrame.cemeteryPlotterPeople.clearPeopleList();

                if (!lsm.isSelectionEmpty()) { // find out which indexes are selected.
                    cemeteryPlotterFrame.cemeteryPlotterPlots.getPlotsData(sectionsList.getSelectedValuesList());
                    cemeteryPlotterFrame.cemeteryPlotterPeople.getPeopleData(sectionsList.getSelectedValuesList());

                    // a single selection only
                    if (sectionsList.getMinSelectionIndex() == sectionsList.getMaxSelectionIndex()) {
                        cemeteryPlotterFrame.cemeteryPlotterPlots.setPlotsEditable(true);
                    } else { // multiple selections
                        cemeteryPlotterFrame.cemeteryPlotterPlots.setPlotsEditable(false);
                    }
                } else { // no selection
                    cemeteryPlotterFrame.cemeteryPlotterPlots.setPlotsEditable(false);
                }
            }
        }
    }
}
