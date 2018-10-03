package com.carvethsolutions.gridlib.tile;

import java.awt.*;

/**
 * ColorTile class used to represent a point in 2D space
 * @author John L. Carveth on 2018/05/01
 */
public class ColorTile extends Tile<Color> {

    /**
     * If no color is provided, the default is white.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public ColorTile(int x, int y) {
        super(x,y, Color.WHITE);
    }

    /**
     * Constructor
     * @param color The Color of the tile
     * @param x The x position of the tile
     * @param y The y position of the tile
     */
    public ColorTile(Color color, int x, int y) {
        super(x,y, color);
    }


    @Override
    public String toString() {
        return "ColorTile (x: " + this.getX() + ", y: " + this.getY() + ")";
    }

    /**
     * The tile paints its color onto the graphics object.
     * @param g the graphics object onto which the tile is painted.
     */
    @Override
    public void paint(Graphics g, int gridScale) {
        if (this.getData() == null) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getX() * gridScale, this.getY() * gridScale, gridScale, gridScale);
        } else {
            g.setColor(this.getData());
            g.fillRect(this.getX() * gridScale, this.getY() * gridScale, gridScale, gridScale);
        }
    }

    /**
     * Removes any data from the tile
     *
     * @return the data, if any
     */
    @Override
    public Color clearData() {
        Color c = this.getData();
        this.setData(Color.WHITE);

        return c;
    }

}
