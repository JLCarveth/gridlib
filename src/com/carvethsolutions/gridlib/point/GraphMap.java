package com.carvethsolutions.gridlib.point;

import com.carvethsolutions.gridlib.matrix.AbstractMatrix;
import com.carvethsolutions.gridlib.matrix.MatrixIterator;

import java.util.Iterator;

/**
 * Like a TileMap, the GraphMap is a data structure made to store / process Point objects in a 2D array
 * Not done yet I don't think. Haven't worked on this in months...
 *
 * @author John on 5/8/2018
 * @project gridlib
 */
public class GraphMap extends AbstractMatrix<Point> implements Iterable<Point> {

    public GraphMap() {
        this(16);
    }

    public GraphMap(int size) {
        this(size,size);
    }

    public GraphMap(int width, int height) {
        super(width, height);

    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Point> iterator() {
        return new MatrixIterator<>(this);
    }

    @Override
    public void insertData(Point point, int x, int y) {

    }

    @Override
    public Point getDataInMatrix(int x, int y) {
        return null;
    }
}
