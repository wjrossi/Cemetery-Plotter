package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterMap extends CemeteryPlotter {
    private JPanel mapPanel;
    private JEditorPane mapPane;
    private JScrollPane mapScrollPane;

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
        mapScrollPane = new JScrollPane(mapPane);
        mapScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        mapPane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cemeteryPlotterFrame.cemeteryPlotterPlot.isEditable())
                    cemeteryPlotterFrame.cemeteryPlotterPlot.setMapLocationField(e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

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

    public void setView(String mapLocation) {
        int x = Integer.parseInt(mapLocation.substring(1, mapLocation.indexOf(',')));
        int y = Integer.parseInt(mapLocation.substring(mapLocation.indexOf(", ") + 2, mapLocation.length() - 1));
        Point point = new Point(x, y);
        mapScrollPane.getViewport().setViewPosition(point);
    }

    /**
     * Load URL in map pane after other GUI elements
     */
    public void getMapData() {
        String mapURL;
        try {
            mapURL = new File("resources/map.html").toURI().toURL().toString();
            mapPane.setPage(mapURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
