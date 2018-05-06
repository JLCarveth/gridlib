package com.carvethsolutions.gridlib.tile;

import java.awt.*;

/**
 * ColorTile class used to represent a point in 2D space
 * @author John L. Carveth on 2018/05/01
 */
public class ColorTile implements Tile<Color> {
    private Color color;
    private int x,y;

    /**
     * If no color is provided, the default is white.
     * @param x
     * @param y
     */
    public ColorTile(int x, int y) {
        color = Color.white;
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor
     * @param color The Color of the tile
     * @param x The x position of the tile
     * @param y The y position of the tile
     */
    public ColorTile(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "ColorTile (x: " + this.x + ", y: " + this.y + ")";
    }

    /**
     * The tile paints any data it holds to the graphics object
     *
     * @param g
     */
    @Override
    public void paint(Graphics g, int gridScale) {
        g.setColor(this.getColor());
        g.fillRect(this.getX() * gridScale, this.getY() * gridScale, gridScale, gridScale);
    }

    /**
     * Removes any data from the tile
     *
     * @return the data, if any
     */
    @Override
    public Color clearData() {
        Color c = this.getColor();
        this.setColor(null);

        return c;
    }
}
