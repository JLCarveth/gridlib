package com.carvethsolutions.gridlib.matrix;

import java.lang.reflect.Array;

/**
 * Class representing a Matrix object
 * @author John on 5/8/2018
 * @project gridlib
 */
public abstract class AbstractMatrix<E> implements Iterable<E>{

    private E[][] data;

    private final Class<? extends E> clss;

    private final int width,height;

    @SuppressWarnings("unchecked")
    public AbstractMatrix(int size, Class<? extends E> clss) {
        width = size;
        height = size;

        this.clss = clss;

        data = (E[][]) Array.newInstance(clss, size,size);
    }


    @SuppressWarnings("unchecked")
    public AbstractMatrix(int height, int width, Class<? extends E> clss) {
        this.width = width;
        this.height = height;

        this.clss = clss;
        data = (E[][]) Array.newInstance(clss,height,width);
    }

    public E[][] getData() { return data; }

    public void setData(E[][] data) {
        this.data = data;
    }

    /**
     * Inserts data into the given position within the matrix
     * @param e data to insert
     * @param x coordinate
     * @param y coordinate
     * @throws IndexOutOfBoundsException if x,y lays out of the Matrix's bounds
     */
    public void insertData(E e, int x, int y) throws IndexOutOfBoundsException {
        if (x > width - 1 || x < 0
                || y > width - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        }
        data[y][x] = e;
    }

    /**
     * Returns data at that location in the matrix, if any exists
     * @param x
     * @param y
     * @return the data contained at x,y
     * @throws IndexOutOfBoundsException if x,y, lays out of the Matrix's bounds.
     */
    public E getDataInMatrix(int x, int y) throws IndexOutOfBoundsException {
        if (x > width - 1 || x < 0
                || y > width - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        }
        return data[y][x];
    }

    /**
     * Clears the data at the given position
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the data at that location, if any
     * @throws IndexOutOfBoundsException
     */
    public E clearData(int x, int y) throws IndexOutOfBoundsException {
        if (x > width - 1 || x < 0
                || y > width - 1 || y < 0) {
            throw new IndexOutOfBoundsException();
        }
        E d = data[y][x];
        data[y][x] = null;
        return d;
    }

    /**
     * Returns true if the coordinates are within the bounds of the Matrix
     * @param x
     * @param y
     * @return true if the coordinates are within the bounds of the Matrix
     */
    public boolean checkBounds(int x, int y) {
        return (x <= 0 && y <= 0 && x >= this.getWidth() - 1 && y >= this.getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
