package com.carvethsolutions.gridlib.tile;

import com.carvethsolutions.gridlib.matrix.AbstractMatrix;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import com.carvethsolutions.gridlib.matrix.MatrixIterator;

/**
 * TileMap is a data-structure for organizing Tiles in a 2D grid
 */
public class TileMap extends AbstractMatrix<Tile> {

    /**
     * Constructor
     * @param width number of tiles
     * @param height number of tiles
     */
    public TileMap(int height, int width) {
        super(height,width,Tile.class);
    }

    /**
     * Constructor for making a square tilemap
     * @param size the number of tiles on one side
     */
    public TileMap(int size) {
        super(size,size,Tile.class);
    }

    /**
     * Inserts data into the matrix
     * @param tile the tile to insert
     * @throws IndexOutOfBoundsException
     */
    public void insertData(Tile tile) throws IndexOutOfBoundsException {
        if (tile.getX() > getWidth() - 1 || tile.getX() < 0
                || tile.getY() > getHeight() - 1 || tile.getY() < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Tile[][] data = this.getData();
            data[tile.getY()][tile.getX()] = tile;
            this.setData(data);
        }
    }

    @Override
    public Tile getDataInMatrix(int x, int y) throws IndexOutOfBoundsException {
        if (x > getWidth() - 1 || x < 0
                || y > getHeight() - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        } else return this.getData()[y][x];
    }

    /**
     * Removes any data from the
     * @param x
     * @param y
     */
    public void removeTile(int x, int y) {
        this.getData()[y][x].clearData();
    }

    @NotNull
    @Override
    public Iterator<Tile> iterator() {
        return new MatrixIterator<>(this);
    }
}
