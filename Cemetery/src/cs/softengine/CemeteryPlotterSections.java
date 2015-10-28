package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for selecting section(s) of the cemetery
 */
public class CemeteryPlotterSections extends CemeteryPlotter implements ActionListener, ItemListener {
    private JPanel sectionsPanel;
    private JButton selectAllButton;
    private JButton selectNoneButton;
    private JList<String> sectionList;
    private JScrollPane sectionListScrollPane;
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

        // put buttons in a button panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.add(selectAllButton);
        buttons.add(selectNoneButton);

        // add button panel to main panel
        panel.add(buttons, BorderLayout.PAGE_START);

        // create list of sections
        sectionList = new JList<String>();
        sectionListScrollPane = new JScrollPane(sectionList);
        sectionListScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sectionList.setLayoutOrientation(JList.VERTICAL);
        sectionList.setPrototypeCellValue("ABCDEFGH");

        sectionList.setToolTipText("Select the section(s) to list their plots below");

        // create new and delete buttons
        newSectionButton = new JButton("New Section");
        deleteSectionButton = new JButton("Delete Section(s)");

        newSectionButton.setToolTipText("Create and add a new section to the cemetery");
        deleteSectionButton.setToolTipText("Permanently delete the selected section(s) from the cemetery");

        JPanel sectionButtonsPanel = new JPanel();
        sectionButtonsPanel.setLayout(new BoxLayout(sectionButtonsPanel, BoxLayout.LINE_AXIS));
        sectionButtonsPanel.add(newSectionButton);
        sectionButtonsPanel.add(deleteSectionButton);

        // add list to main panel
        panel.add(sectionListScrollPane, BorderLayout.CENTER);
        panel.add(sectionButtonsPanel, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Action listener for sections content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
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
        // do stuff to list all the sections in the list
    }
}
