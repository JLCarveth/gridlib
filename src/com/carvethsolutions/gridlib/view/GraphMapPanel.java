package com.carvethsolutions.gridlib.view;

import com.carvethsolutions.gridlib.point.GraphMap;

import javax.swing.*;

/**
 * Swing Component to visualize GraphMap objects
 * @author John on 5/8/2018
 * @project gridlib
 */
public class GraphMapPanel extends JPanel {

    /**
     * GraphMap that holds data to be visualized
     */
    private GraphMap graphMap;

    /**
     * Fields that control the dimensions of the component in pixels
     */
    private int width,height;

    /**
     * If true, points and lines are visible, otherwise just the lines
     */
    private boolean pointsVisible = true;

    public GraphMapPanel() {
        this(new GraphMap());
    }

    public GraphMapPanel(GraphMap graphMap) {

    }
}
