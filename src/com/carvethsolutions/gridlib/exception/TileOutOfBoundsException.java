package com.carvethsolutions.gridlib.exception;

import com.carvethsolutions.gridlib.tile.Tile;

public class TileOutOfBoundsException extends Exception {

    /**
     * Throws a generic exception
     */
    public TileOutOfBoundsException() {
        super("Point is out of bounds in context.");
    }

    /**
     * Throws an exception
     * @param t the tile that is out of bounds
     * @param bounds the bounds, [width, height]
     */
    public TileOutOfBoundsException(Tile t, int[] bounds) {
        super(t+" out of bounds for " + bounds[0] + ", " + bounds[1] + ".");
    }
}
