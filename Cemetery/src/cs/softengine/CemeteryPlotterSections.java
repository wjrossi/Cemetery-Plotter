package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for selecting section(s) of the cemetery
 */
public class CemeteryPlotterSections implements ActionListener, ItemListener {
    private JPanel sectionsPanel;

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
    public JPanel getPanel() {
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
        JButton selectAllButton = new JButton("Select All");
        JButton selectNoneButton = new JButton("Select None");

        // put buttons in a button panel
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.LINE_AXIS));
        buttons.add(selectAllButton);
        buttons.add(selectNoneButton);

        // add button panel to main panel
        panel.add(buttons, BorderLayout.PAGE_START);

        // create list of sections
        JList<String> sectionList = new JList<String>();
        JScrollPane sectionListScrollPane = new JScrollPane(sectionList);
        sectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        sectionList.setLayoutOrientation(JList.VERTICAL);
        sectionList.setPrototypeCellValue("ABCDEFGH");

        // add list to main panel
        panel.add(sectionListScrollPane, BorderLayout.CENTER);

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
}
