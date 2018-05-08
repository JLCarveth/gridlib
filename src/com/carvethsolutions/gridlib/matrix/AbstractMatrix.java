package com.carvethsolutions.gridlib.matrix;

/**
 * Class representing a Matrix object
 * @author John on 5/8/2018
 * @project gridlib
 */
public abstract class AbstractMatrix<E> {

    private E[][] data;

    private final int width,height;

    public E[][] getData() { return data; }

    /**
     * Inserts data into the given position within the matrix
     * @param e data to insert
     * @param x coordinate
     * @param y coordinate
     * @throws IndexOutOfBoundsException if x,y lays out of the Matrix's bounds
     */
    public abstract void insertData(E e, int x, int y)
        throws IndexOutOfBoundsException;

    /**
     * Returns data at that location in the matrix, if any exists
     * @param x
     * @param y
     * @return the data contained at x,y
     * @throws IndexOutOfBoundsException if x,y, lays out of the Matrix's bounds.
     */
    public abstract E getDataInMatrix(int x, int y)
        throws IndexOutOfBoundsException;

    public AbstractMatrix(E[][] data) {
        this.data = data;

        width = data[0].length;
        height = data.length;
    }

    public AbstractMatrix(int size) {
        this(size,size);
    }

    public AbstractMatrix(int width, int height) {
        this.width = width;
        this.height = height;

        data = (E[][]) new Object[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
