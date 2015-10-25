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
        JPanel panel;
        Border etchedBorder;
        TitledBorder titledBorder;

        panel = new JPanel(new BorderLayout());

        // create an raised, etched, titled border
        etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Sections");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        return panel;
    }

    /**
     * Action listener for sections content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for sections content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
