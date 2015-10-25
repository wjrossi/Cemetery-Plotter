package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane containing editable information on a plot owner
 */
public class CemeteryPlotterOwner implements ActionListener, ItemListener {
    private JPanel panel;

    /**
     * Constructs a content pane for a plot owner info
     */
    public CemeteryPlotterOwner() {
        panel = createOwnerPanel();
    }

    /**
     * Get plot owner info panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create plot owner panel
     * @return panel
     */
    private JPanel createOwnerPanel() {
        JPanel owner;

        owner = new JPanel();

        return owner;
    }

    /**
     * Action listener for plot owner info content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for plot owner info content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
