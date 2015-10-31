package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

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

        // add things to main panel

        // create buttons
        selectAllButton = new JButton("Select All");
        selectNoneButton = new JButton("Select None");

        selectAllButton.setActionCommand("select all");
        selectNoneButton.setActionCommand("select none");

        selectAllButton.addActionListener(this);
        selectNoneButton.addActionListener(this);

        // put buttons in a button panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.add(selectAllButton);
        buttons.add(selectNoneButton);

        // add button panel to main panel
        panel.add(buttons, BorderLayout.PAGE_START);

        // create list of sections
        sectionsListModel = new DefaultListModel<String>();
        sectionsList = new JList<String>(sectionsListModel);
        sectionsListSelectionModel = (DefaultListSelectionModel) sectionsList.getSelectionModel();
        sectionsListSelectionModel.addListSelectionListener(new SectionsListSelectionHandler());
        sectionsListScrollPane = new JScrollPane(sectionsList);
        sectionsListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sectionsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sectionsList.setLayoutOrientation(JList.VERTICAL);
        sectionsList.setPrototypeCellValue("ABCDEFGH");

        sectionsList.setToolTipText("Select the section(s) to list their plots below");

        // create new and delete buttons
        newSectionButton = new JButton("New Section");
        deleteSectionButton = new JButton("Delete Section(s)");

        newSectionButton.setToolTipText("Create and add a new section to the cemetery");
        deleteSectionButton.setToolTipText("Permanently delete the selected section(s) from the cemetery");

        newSectionButton.setActionCommand("new section");
        deleteSectionButton.setActionCommand("delete section");

        newSectionButton.addActionListener(this);
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
            case "select all": // TODO
                // select anything in the list/listmodel
                sectionsListSelectionModel.setSelectionInterval(0, sectionsListModel.size()-1);
                // currently will highlight all items, this should trigger something in CemeteryPlotterPlots i guess
                break;
            case "select none": // TODO
                // deselect all things in the list/listmodel
                sectionsListSelectionModel.clearSelection();
                // currently un-highlights all items, this should also trigger something in CemeteryPlotterPlots i guess
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

    class SectionsListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();

            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting();

            cemeteryPlotterFrame.cemeteryPlotterPlots.clearPlotsList();

            if (!lsm.isSelectionEmpty() && !isAdjusting) { // find out which indexes are selected.
                int min = lsm.getMinSelectionIndex();
                int max = lsm.getMaxSelectionIndex();

                for (int index = min; index <= max; index++) {
                    if (lsm.isSelectedIndex(index)) {
                        // then list the plots and the people
                        cemeteryPlotterFrame.cemeteryPlotterPlots.getPlotsData(sectionsListModel.get(index));
                    }
                }
            }
        }
    }
}
