package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane allowing for the searching and listing of people in the cemetery
 */
public class CemeteryPlotterPeople {
    private JPanel panel;

    /**
     * Constructs a content pane for searching and listing of people
     */
    public CemeteryPlotterPeople() {
        panel = createPeoplePanel();
    }

    /**
     * Get people panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create people panel
     * @return panel
     */
    private JPanel createPeoplePanel() {
        JPanel people;

        people = new JPanel();

        return people;
    }

    /**
     * Action listener for people content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for people content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
