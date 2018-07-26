package com.carvethsolutions.gridlib.tile;

import java.awt.*;

/**
 * A visual tile can be represented in a user-interface using a java.awt.Graphics object
 * @param <T> the data the tile holds.
 */
public abstract class VisualTile<T> extends Tile<T>{

    public VisualTile(int x, int y) {
        super(x, y);
    }

    public VisualTile(int x, int y, T data) {
        super(x, y, data);
    }

    /**
     * This function is called when the tile needs to draw some data onto a Graphics object.
     *
     * @param g the graphics object onto which the tile will paint what it needs to
     * @param gridScale used to scale the tile drawing to the same size as others
     */
    public abstract void paint(Graphics g, int gridScale);
}
