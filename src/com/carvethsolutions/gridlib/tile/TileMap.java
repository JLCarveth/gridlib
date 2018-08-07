package com.carvethsolutions.gridlib.tile;

import com.carvethsolutions.gridlib.exception.CoordinatesOutOfBoundsException;
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
     * @throws CoordinatesOutOfBoundsException
     */
    public void insertData(Tile tile) throws CoordinatesOutOfBoundsException {
        if (!checkBounds(tile.getX(),tile.getY())) {
            throw new CoordinatesOutOfBoundsException(tile.getX(),
                    tile.getY(), new int[]{getWidth(),getHeight()});
        } else {
            Tile[][] data = this.getData();
            data[tile.getY()][tile.getX()] = tile;
            this.setData(data);
        }
    }

    /**
     * Gets the data at a specific point within
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the data at the given coordinates
     * @throws CoordinatesOutOfBoundsException if the given coords lie out of bounds
     */
    @Override
    public Tile getDataInMatrix(int x, int y) throws CoordinatesOutOfBoundsException {
        if (!checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException();
        } else return this.getData()[y][x];
    }

    /**
     * Removes any data from the
     * @param x the x coordinate
     * @param y the y coordinate
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
