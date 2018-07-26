package com.carvethsolutions.gridlib.matrix;

/**
 * Class representing a Matrix object
 * @author John on 5/8/2018
 * @project gridlib
 */
public abstract class AbstractMatrix<E> {

    private E[][] data;

    private final int width,height;

    public AbstractMatrix(E[][] data) {
        this.data = data;

        width = data[0].length;
        height = data.length;
    }

    public AbstractMatrix(int size) {
        width = size;
        height = size;

        data = (E[][]) new Object[size][size];
    }

    public AbstractMatrix(int width, int height) {
        this.width = width;
        this.height = height;

        data = (E[][]) new Object[height][width];
    }

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

    /**
     * Clears the data at the given position
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the data at that location, if any
     * @throws IndexOutOfBoundsException
     */
    public E clearData(int x, int y) {
        if (x > width - 1 || x < 0
                || y > width - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        }
        E d = data[y][x];
        data[y][x] = null;
        return d;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
