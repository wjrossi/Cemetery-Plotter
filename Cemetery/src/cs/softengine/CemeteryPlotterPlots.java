package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for listing of plots belonging to selected section(s)
 */
public class CemeteryPlotterPlots implements ActionListener, ItemListener {
    private JPanel panel;

    /**
     * Constructs a content pane for listing of plots belonging to selected section(s)
     */
    public CemeteryPlotterPlots() {
        panel = createPlotsPanel();
    }

    /**
     * Get plots panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create plots panel
     * @return panel
     */
    private JPanel createPlotsPanel() {
        JPanel plots;

        plots = new JPanel();

        return plots;
    }

    /**
     * Action listener for plots content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for plots content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
