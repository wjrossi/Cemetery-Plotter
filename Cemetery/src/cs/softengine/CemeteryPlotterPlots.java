package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane for listing of plots belonging to selected section(s)
 */
public class CemeteryPlotterPlots implements ActionListener, ItemListener {
    private JPanel plotsPanel;

    /**
     * Constructs a content pane for listing of plots belonging to selected section(s)
     */
    public CemeteryPlotterPlots() {
        plotsPanel = createPlotsPanel();
    }

    /**
     * Get plots panel
     * @return plotsPanel
     */
    public JPanel getPanel() {
        return plotsPanel;
    }

    /**
     * Create plots panel
     * @return panel
     */
    private JPanel createPlotsPanel() {
        JPanel panel;
        Border etchedBorder;
        TitledBorder titledBorder;

        panel = new JPanel(new BorderLayout());

        // create an raised, etched, titled border
        etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Plots");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        return panel;
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
