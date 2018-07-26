package com.carvethsolutions.gridlib.tile;

import com.carvethsolutions.gridlib.matrix.AbstractMatrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TileMap is a data-structure for organizing data in a 2D Array.
 */
public class TileMap extends AbstractMatrix<Tile> implements Iterable<Tile>  {

    private Tile[][] data;

    /**
     * Constructor
     * @param width number of tiles
     * @param height number of tiles
     */
    public TileMap(int height, int width) {
        super(new Tile[height][width]);
    }

    /**
     * Returns an matrix over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Tile> iterator() {
        return new TileMapIterator(this.getHeight(), this.getWidth());
    }

    private class TileMapIterator implements Iterator<Tile> {

        private int currentRow, currentColumn;

        private int height, width;

        public TileMapIterator(int height, int width) {
            this.height = height;
            this.width = width;
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



    @Override
    public void insertData(Tile tile, int x, int y) throws IndexOutOfBoundsException {
        if (x > getWidth() - 1 || x < 0
                || y > getHeight() - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        } else data[y][x] = tile;
    }

    @Override
    public Tile getDataInMatrix(int x, int y) throws IndexOutOfBoundsException {
        if (x > getWidth() - 1 || x < 0
                || y > getHeight() - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        } else return data[y][x];
    }

    /**
     * Constructor for making a square tilemap
     * @param size
     */
    public TileMap(int size) {
        super(size,size);
    }


    /**
     * Removes any data from the
     * @param x
     * @param y
     */
    public void removeTile(int x, int y) {
        data[y][x].clearData();
    }
}
