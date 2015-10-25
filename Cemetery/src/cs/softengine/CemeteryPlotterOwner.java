package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane containing editable information on a plot owner
 */
public class CemeteryPlotterOwner implements ActionListener, ItemListener {
    private JPanel ownerPanel;

    /**
     * Constructs a content pane for a plot owner info
     */
    public CemeteryPlotterOwner() {
        ownerPanel = createOwnerPanel();
    }

    /**
     * Get plot owner info panel
     * @return ownerPanel
     */
    public JPanel getPanel() {
        return ownerPanel;
    }

    /**
     * Create plot owner panel
     * @return panel
     */
    private JPanel createOwnerPanel() {
        JPanel panel;
        Border etchedBorder;
        TitledBorder titledBorder;

        panel = new JPanel(new BorderLayout());

        // create an raised, etched, titled border
        etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Owner");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        return panel;
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
