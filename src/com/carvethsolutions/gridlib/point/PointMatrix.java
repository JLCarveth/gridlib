package com.carvethsolutions.gridlib.point;

import com.carvethsolutions.gridlib.exception.CoordinatesOutOfBoundsException;
import com.carvethsolutions.gridlib.matrix.AbstractMatrix;
import com.carvethsolutions.gridlib.matrix.MatrixIterator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of AbstractMatrix, with the intent of storing graph data.
 * A PointMatrix is a square grid of empty Point objects.
 */
public class PointMatrix extends AbstractMatrix<Point> {

    /**
     * Constructor.
     * @param size the number of points on one side of the matrix
     */
    public PointMatrix(int size) {
        super(size, Point.class);
        Point[][] data = this.getData();

        for (int x=0; x < size; x++) {
            for (int y=0; y < size; y++) {
                data[y][x] = new Point(x,y);
            }
        }

        this.setData(data);
    }

    /**
     * Forms a connection between two points.
     * @param x1 x coordinate of the first point
     * @param y1 y coordinate of the first point
     * @param x2 x coordinate of the second point
     * @param y2 y coordinate of the second point
     * @return true if the points were connected before, or are connected now.
     * @throws CoordinatesOutOfBoundsException if one of the points is out of bounds.
     */
    public void connect(int x1, int y1, int x2, int y2)
            throws CoordinatesOutOfBoundsException {
        if (!this.checkBounds(x1,y1)) {
            throw new CoordinatesOutOfBoundsException(
                    x1,y1,
                    new int[]{this.getSize(), this.getSize()});
        }
        if (!this.checkBounds(x2,y2)) {
            throw new CoordinatesOutOfBoundsException(
                    x2,y2,
                    new int[]{this.getSize(), this.getSize()});
        }

        Point point1 = this.getDataInMatrix(x1,y1);
        Point point2 = this.getDataInMatrix(x2,y2);

        point1.addConnection(point2);
    }

    /**
     * Breaks a connection FROM point1 TO point2
     * @param x1 Point1 x coordinate
     * @param y1 Point1 y coordinate
     * @param x2 Point2 x coordinate
     * @param y2 Point2 y coordinate
     */
    public void disconnect(int x1, int y1, int x2, int y2)
            throws CoordinatesOutOfBoundsException {
        if (!this.checkBounds(x1,y1)) {
            throw new CoordinatesOutOfBoundsException(
                    x1,y1,
                    new int[]{this.getSize(), this.getSize()});
        }
        if (!this.checkBounds(x2,y2)) {
            throw new CoordinatesOutOfBoundsException(
                    x2,y2,
                    new int[]{this.getSize(), this.getSize()});
        }

        Point point1 = this.getDataInMatrix(x1,y1);
        Point point2 = this.getDataInMatrix(x2,y2);

        point1.removeConnection(point2);
    }

    /**
     * Find all connections to a certain point.
     * @param x the x coordinate
     * @param y the y coordinate
     * @return all points to which the given point was connected to, if any
     * @throws CoordinatesOutOfBoundsException if the provided point is out of bounds.
     */
    public ArrayList<Point> getConnections(int x, int y)
            throws CoordinatesOutOfBoundsException {
        if (!this.checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException(x,y, new int[]{this.getHeight(),this.getHeight()});
        }

        return this.getDataInMatrix(x,y).getConnected();
    }

    /**
     * For simplicity's sake... Since the height and width are always the same, no need to
     * make the code confusing when calling for only one or the other.
     * @return the size of the matrix (# of Points on one side)
     */
    public int getSize() { return this.getHeight(); }

    @NotNull
    @Override
    public Iterator<Point> iterator() {
        return new MatrixIterator<>(this);
    }
}
