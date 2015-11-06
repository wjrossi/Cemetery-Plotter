package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterMap extends CemeteryPlotter implements ActionListener {
    private JPanel mapPanel;
    private JEditorPane mapPane;

    /**
     * Constructs a content pane for map
     */
    public CemeteryPlotterMap() {
        mapPanel = createMapPanel();
    }

    /**
     * Get map panel
     * @return plotPanel
     */
    public JPanel getMapPanel() {
        return mapPanel;
    }

    /**
     * Create plot info panel
     * @return panel
     */
    private JPanel createMapPanel() {
        JPanel panel = new JPanel(new BorderLayout(), true);

        // create an raised, etched, titled border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Map");
        titledBorder.setTitleJustification(TitledBorder.LEFT);
        panel.setBorder(titledBorder);

        // add things to panel

        // create map pane
        mapPane = new JEditorPane();
        mapPane.setEditable(false);
        JScrollPane mapScrollPane = new JScrollPane(mapPane);
        mapScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //mapScrollPane.setPreferredSize(new Dimension(320, 240));

        // add map scroll pane to main panel
        panel.add(mapScrollPane, BorderLayout.CENTER);

        // create map controls panel
        JPanel mapControls = new JPanel();
        mapControls.setLayout(new BoxLayout(mapControls, BoxLayout.LINE_AXIS));

        // add buttons to map control panel
        // TODO

        //add map controls to main panel
        panel.add(mapControls, BorderLayout.PAGE_END);

        return panel;
    }

    /**
     * Load URL in map pane after other GUI elements
     */
    public void getMapData() {
        URL mapURL;
        try { // TODO what do we put in the map and how
            mapURL = new URL("http://bethshalompgh.org/"); // super temporary!! may want to do this after loading gui!!
            mapPane.setPage(mapURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Action listener for plot info content pane
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
        //
    }
}
