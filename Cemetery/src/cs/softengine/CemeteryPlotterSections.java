package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for selecting section(s) of the cemetery
 */
public class CemeteryPlotterSections implements ActionListener, ItemListener {
    private JPanel panel;

    /**
     * Constructs a content pane for selecting section(s)
     */
    public CemeteryPlotterSections() {
        panel = createSectionsPanel();
    }

    /**
     * Get section panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create section panel
     * @return panel
     */
    private JPanel createSectionsPanel() {
        JPanel sections;

        sections = new JPanel();

        return sections;
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
