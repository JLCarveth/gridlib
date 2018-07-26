package com.carvethsolutions.gridlib.tile;

import java.awt.*;

/**
 * Abstract Tile class. All Tile classes must implement this abstract class.
 *
 * @author John on 5/5/2018
 * @project gridlib
 */
public abstract class Tile<T> {

    /**
     * The coordinates of the tile.
     * A tile cannot be moved (since it could be moved out of the bounds of it's data structure), hence final
     */
    private final int x,y;

    /**
     * The data held by the color. This could be the Tile's color, sprite, or some object with other information.
     */
    private T data;

    /**
     * Constructor that initializes with null data
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.data = null;
    }

    /**
     * Secondary Constructor
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @param data the data the tile will hold
     */
    public Tile(int x, int y, T data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    /**
     * Removes any data from the tile
     * @return the data, if any
     */
    public abstract T clearData();

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the distance between two points.
     * @param tile the other tile to measure distance between
     * @return the distance between the two tiles.
     */
    public double getEuclideanDistance(Tile tile) {
        return Math.sqrt(Math.pow((this.x - tile.x),2.0)
                + Math.pow((this.y - tile.y), 2.0));
    }
}
