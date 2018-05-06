package com.carvethsolutions.gridlib.tile;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TileMap is a data-structure for organizing data in a 2D Array.
 */
public class TileMap implements Iterable<Tile> {

    private Tile[][] data;

    private final int width, height;

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<Tile> iterator() {
        return new TileMapIterator();
    }

    private class TileMapIterator implements Iterator<Tile> {

        private int currentRow, currentColumn;

        public TileMapIterator() {
            currentRow = currentColumn = 0;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return !(currentRow == height - 1 && currentColumn == width - 1);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Tile next() {
            Tile tile = new ColorTile(-99,-99);
            try {
                tile = data[currentRow][currentColumn];

                if (currentColumn == width - 1) {
                    currentColumn = 0;
                    currentRow++;
                } else {
                    currentColumn++;
                }

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }

            return tile;
        }
    }

    /**
     * Constructor
     * @param width number of tiles
     * @param height number of tiles
     */
    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        data = new Tile[height][width];
    }

    /**
     * Constructor for making a square tilemap
     * @param size
     */
    public TileMap(int size) {
        this(size,size);
    }

    public void placeTile(Tile t, int x, int y) {
        data[y][x] = t;
    }

    /**
     * Returns the tile located at the x,y coordinates, if one exists
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the tile, if it exists
     * @throws IndexOutOfBoundsException if the coordinates are not within the bounds of the tilemap
     */
    public Tile getTile(int x, int y) {
        if (!(x > 0 && x < width && y > 0 && y < height)) {
            throw new IndexOutOfBoundsException();
        }
        return data[y][x];
    }

    /**
     * Removes any data from the
     * @param x
     * @param y
     */
    public void removeTile(int x, int y) {
        data[y][x].clearData();
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }
}
