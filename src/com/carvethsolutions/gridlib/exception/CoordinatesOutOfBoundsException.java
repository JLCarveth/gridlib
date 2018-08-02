package com.carvethsolutions.gridlib.exception;

import com.carvethsolutions.gridlib.point.Point;

public class CoordinatesOutOfBoundsException extends Exception {

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
