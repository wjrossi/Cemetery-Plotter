package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane allowing for the searching and listing of people in the cemetery
 */
public class CemeteryPlotterPeople {
    private JPanel peoplePanel;

    /**
     * Constructs a content pane for searching and listing of people
     */
    public CemeteryPlotterPeople() {
        peoplePanel = createPeoplePanel();
    }

    /**
     * Get people panel
     * @return peoplePanel
     */
    public JPanel getPanel() {
        return peoplePanel;
    }

    /**
     * Create people panel
     * @return panel
     */
    private JPanel createPeoplePanel() {
        JPanel panel;
        Border etchedBorder;
        TitledBorder titledBorder;

        panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        titledBorder = BorderFactory.createTitledBorder(etchedBorder, "People");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        return panel;
    }

    /**
     * Action listener for people content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for people content pane
     * @param e item event
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
