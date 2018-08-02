package com.carvethsolutions.gridlib.view;

import com.carvethsolutions.gridlib.point.Point;
import com.carvethsolutions.gridlib.point.PointMatrix;
import com.carvethsolutions.gridlib.util.GraphicsUtil;
import com.carvethsolutions.loglib.Loggable;
import com.carvethsolutions.loglib.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * TODO Merge the two Panel classes and extract a superclass
 */
public class PointMatrixPanel extends JPanel implements Loggable {

    /**
     * The size of the panel, in pixels. PointMatrix objects are only square
     */
    private int size;

    /**
     * The space between each point on the graph, in pixels
     */
    private int gridScale = 20;

    /**
     * Our PointMatrix object that holds the data to be displayed
     */
    private PointMatrix pointMatrix;

    private GraphicsUtil gu = new GraphicsUtil();

    public PointMatrixPanel(PointMatrix matrix) {
        pointMatrix = matrix;
        this.size = pointMatrix.getSize() * gridScale;

        this.setPreferredSize(new Dimension(size,size));
        this.setBackground(Color.WHITE);
    }

    /**
     * Paints the panel with information from the matrix.
     * There is an offset so the matrix appears central to the panel.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator<Point> iterator = pointMatrix.iterator();

        int offset = gridScale / 2;

        // Iterate through each point in the Matrix
        while (iterator.hasNext()) {
            Point point = iterator.next();
            // If the point is isolated, draw a small grey dot.
            if (point.isIsolated()) {
                g.setColor(Color.DARK_GRAY);
                gu.drawCenteredCircleFill(
                        g,
                        point.getX() * gridScale + offset,
                        point.getY() * gridScale + offset,
                        (gridScale / 20));
                g.setColor(Color.BLACK);
            } else {
                gu.drawCenteredCircleFill(g,
                        point.getX() * gridScale + offset,
                        point.getY() * gridScale + offset,
                        2 * (gridScale / 20));
            }
            // For each connection the point has, draw it.
            for (Point c : point.getConnected()) {
                g.drawLine(
                        point.getX() * gridScale + offset,
                        point.getY() * gridScale + offset,
                        c.getX() * gridScale + offset,
                        c.getY() * gridScale + offset);
            }
        }
    }

    public int getGridScale() {
        return gridScale;
    }

    /**
     * Change the gridScale, and recalculate the panel size.
     * @param gridScale
     */
    public void setGridScale(int gridScale) {
        this.gridScale = gridScale;
        this.size = pointMatrix.getSize() * gridScale;
        Logger.log(this, gridScale + " Hmm " + size, Logger.levels.DEBUG);
        this.setPreferredSize(new Dimension(this.size + 10,this.size + 10));
        Logger.log(this, this.getPreferredSize() + " size", Logger.levels.INFO);
    }

    public PointMatrix getPointMatrix() {
        return pointMatrix;
    }

    @Override
    public String getTag() { return "PointMatrixPanel"; }
}
