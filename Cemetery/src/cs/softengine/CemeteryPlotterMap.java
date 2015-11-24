package cs.softengine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Content pane for plot info
 */
public class CemeteryPlotterMap extends CemeteryPlotter {
    private JPanel mapPanel;
    private ScrollablePicture map;
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

        // load image
        java.net.URL imgURL = getClass().getResource("/resources/map.png");
        map = new ScrollablePicture(new ImageIcon(imgURL), 10);
        //map = new ScrollablePicture(new ImageIcon("resources/map.png"), 10);
        mapScrollPane = new JScrollPane(map);
        mapScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mapScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        map.addMouseListener(new MouseListener() {
            /**
             * Get the coordinates of a mouse click event
             * @param e MouseEvent
             */
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
            public void mouseEntered(MouseEvent e) {
                if (cemeteryPlotterFrame.cemeteryPlotterPlot.isEditable())
                    mapScrollPane.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) { }
        });

        // add map scroll pane to main panel
        panel.add(mapScrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Set the view of the scrollable picture to show the map location
     * @param mapLocation "(x, y)"
     */
    public void setView(String mapLocation) {
        int x = Integer.parseInt(mapLocation.substring(1, mapLocation.indexOf(',')));
        int y = Integer.parseInt(mapLocation.substring(mapLocation.indexOf(", ") + 2, mapLocation.length() - 1));
        Point point = new Point(x - (mapScrollPane.getWidth() / 2), y - (mapScrollPane.getHeight() / 2));
        map.showLocation(true, x, y);
        mapScrollPane.getViewport().setViewPosition(point);
    }

    /**
     * Clear map data by hiding the location indicator
     */
    public void clearMapData() {
        map.showLocation(false, 0, 0);
    }

    /**
     * A scrollable picture
     */
    private class ScrollablePicture extends JLabel implements Scrollable, MouseMotionListener {
        private int maxUnitIncrement = 1;
        private boolean missingPicture = false;
        private boolean visible = false;
        private int x = 0;
        private int y = 0;

        /**
         * Default constructor
         * @param i image icon
         * @param m increment
         */
        public ScrollablePicture(ImageIcon i, int m) {
            super(i);

            if (i == null) {
                missingPicture = true;
                setText("No picture found.");
                setHorizontalAlignment(CENTER);
                setOpaque(true);
                setBackground(Color.white);
            }

            maxUnitIncrement = m;

            setAutoscrolls(true); // enable synthetic drag events
            addMouseMotionListener(this); // handle mouse drags
        }

        public void mouseMoved(MouseEvent e) { }

        public void mouseDragged(MouseEvent e) {
            // the user is dragging, so scroll
            Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
            scrollRectToVisible(r);
        }

        public Dimension getPreferredSize() {
            if (missingPicture)
                return new Dimension(320, 480);
            else
                return super.getPreferredSize();
        }

        public Dimension getPreferredScrollableViewportSize() {
            return getPreferredSize();
        }

        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            // get the current position.
            int currentPosition = 0;

            if (orientation == SwingConstants.HORIZONTAL)
                currentPosition = visibleRect.x;
            else
                currentPosition = visibleRect.y;

            // return the number of pixels between currentPosition and the nearest tick mark in the indicated direction
            if (direction < 0) {
                int newPosition = currentPosition - (currentPosition / maxUnitIncrement) * maxUnitIncrement;
                return (newPosition == 0) ? maxUnitIncrement : newPosition;
            } else {
                return ((currentPosition / maxUnitIncrement) + 1) * maxUnitIncrement - currentPosition;
            }
        }

        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            if (orientation == SwingConstants.HORIZONTAL)
                return visibleRect.width - maxUnitIncrement;
            else
                return visibleRect.height - maxUnitIncrement;
        }

        public boolean getScrollableTracksViewportWidth() {
            return false;
        }

        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

        public void setMaxUnitIncrement(int pixels) {
            maxUnitIncrement = pixels;
        }

        /**
         * Show the location indicator on the image
         * @param visible boolean
         * @param x int
         * @param y int
         */
        public void showLocation(boolean visible, int x, int y) {
            this.visible = visible;
            this.x = x;
            this.y = y;
            super.repaint();
        }

        /**
         * Paint the component and draw the location indicator if visible is set to true
         * @param g graphics
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (visible) {
                g.setColor(Color.GREEN);
                g.fillRect(x-8, y-8, 16, 16);
            }
        }
    }
}