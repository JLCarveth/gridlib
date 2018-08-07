package com.carvethsolutions.gridlib.exception;

/**
 * This exception is thrown whenever coordinates provided lie out of bounds
 * to the context to which they were applied.
 */
public class CoordinatesOutOfBoundsException extends RuntimeException {

    /**
     * Throws a generic exception
     */
    public CoordinatesOutOfBoundsException() {
        super("Point is out of bounds in context.");
    }

    /**
     * Throws an exception
     * @param x the x coordinate
     * @param y the y coordinate
     * @param bounds the bounds [width, height]
     */
    public CoordinatesOutOfBoundsException(int x, int y, int[] bounds) {
        super("("+x+","+y+")"+" out of bounds for " + bounds[0] + ", " + bounds[1] + ".");
    }
}
