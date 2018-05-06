package com.carvethsolutions.gridlib.tile;

import java.awt.*;

/**
 * @author John on 5/5/2018
 * @project gridlib
 */
public interface Tile<T> {

    /**
     * The tile paints any data it holds to the graphics object
     * @param g the graphics object onto which the tile will be painted
     * @param gridScale used to scale the tile drawing to the same size as others
     */
    void paint(Graphics g, int gridScale);

    /**
     * Removes any data from the tile
     * @return the data, if any
     */
    T clearData();
}
