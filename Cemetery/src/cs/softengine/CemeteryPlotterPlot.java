package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterPlot implements ActionListener, ItemListener {
    private JPanel plotPanel;

    /**
     * Constructs a content pane for plot info
     */
    public CemeteryPlotterPlot() {
        plotPanel = createPlotPanel();
    }

    /**
     * Get plot info panel
     * @return plotPanel
     */
    public JPanel getPanel() {
        return plotPanel;
    }

    /**
     * Create plot info panel
     * @return panel
     */
    private JPanel createPlotPanel() {
        JPanel panel;
        Border etchedBorder;
        TitledBorder titledBorder;

        panel = new JPanel(new BorderLayout());

        // create an raised, etched, titled border
        etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Plot");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        return panel;
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
