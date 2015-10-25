package cs.softengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Content pane containing editable information of an interred person
 */
public class CemeteryPlotterInterredPerson implements ActionListener, ItemListener {
    private JPanel panel;

    /**
     * Constructs a content pane for an interred person info
     */
    public CemeteryPlotterInterredPerson() {
        panel = createInterredPersonPanel();
    }

    /**
     * Get interred person info panel
     * @return panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Create interred person info panel
     * @return panel
     */
    private JPanel createInterredPersonPanel() {
        JPanel interredPerson;

        interredPerson = new JPanel();

        return interredPerson;
    }

    /**
     * Action listener for interred person info content pane
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        //
    }

    /**
     * Item state listener for interred person info content pane
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //
    }
}
