package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterPlot implements ActionListener, ItemListener {
    private JPanel panel;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        panel = createPlotPanel();
    }

    /**
     * Get plot info panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create plot info panel
     * @return panel
     */
    private JPanel createPlotPanel() {
        JPanel plot;

        plot = new JPanel();

        return plot;
    }

    /**
     * Action listener for plot info content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for plot info content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
