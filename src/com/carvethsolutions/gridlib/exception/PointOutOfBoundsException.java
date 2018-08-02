package com.carvethsolutions.gridlib.exception;

import com.carvethsolutions.gridlib.point.Point;

public class PointOutOfBoundsException extends Exception {

    /**
     * Throws a generic exception
     */
    public PointOutOfBoundsException() {
        super("Point is out of bounds in context.");
    }

    /**
     * Throws an exception
     * @param p the point that is out of bounds
     * @param bounds the bounds [width, height]
     */
    public PointOutOfBoundsException(Point p, int[] bounds) {
        super(p+" out of bounds for " + bounds[0] + ", " + bounds[1] + ".");
    }
}
