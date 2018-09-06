package com.carvethsolutions.gridlib.matrix;

import com.carvethsolutions.gridlib.exception.CoordinatesOutOfBoundsException;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * An abstract class representing a Matrix object (2D array)
 * @author John on 5/8/2018
 * @project gridlib
 */
public abstract class AbstractMatrix<E> implements Iterable<E>{

    private E[][] data;

    private final Class<? extends E> clss;

    private final int width,height;

    /**
     * Creates a new <i>square</i> AbstractMatrix of given size, and holds data of type clss
     * @param size the number of objects spanning one side of the matrix
     * @param clss the class of data the matrix will hold.
     */
    @SuppressWarnings("unchecked")
    public AbstractMatrix(int size, Class<? extends E> clss) {
        width = size;
        height = size;

        this.clss = clss;

        data = (E[][]) Array.newInstance(clss, size,size);
    }

    /**
     * Creates a new AbstractMatrix object with given width and height.
     * @param height the number of objects spanning the y-axis
     * @param width the number of objects spanning the x-axis
     * @param clss the class of data the matrix will hold.
     */
    @SuppressWarnings("unchecked")
    public AbstractMatrix(int height, int width, Class<? extends E> clss) {
        this.width = width;
        this.height = height;

        this.clss = clss;
        data = (E[][]) Array.newInstance(clss,height,width);
    }

    /**
     * Returns a 2D array of the data within the matrix.
     * @return a 2D array of the data within the matrix.
     */
    public E[][] getData() { return data; }

    /**
     * Overwrites all data within the matrix. insertData should be used
     * for most cases.
     * @param data the new data, must be of the same dimensions.
     */
    public void setData(E[][] data) throws IllegalArgumentException{
        if (data.length != getHeight() || data[0].length != getWidth()) {
            throw new IllegalArgumentException("Given 2D array must have the same dimensions.");
        } else { this.data = data; }
    }

    /**
     * Inserts data into the given position within the matrix
     * @param e data to insert
     * @param x coordinate
     * @param y coordinate
     * @throws CoordinatesOutOfBoundsException if x,y lays out of the Matrix's bounds
     */
    public void insertData(E e, int x, int y) throws CoordinatesOutOfBoundsException {
        if (!checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException(x,y, new int[]{width,height});
        }
        data[y][x] = e;
    }

    /**
     * Returns data at that location in the matrix, if any exists
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the data contained at x,y
     * @throws CoordinatesOutOfBoundsException if x,y, lays out of the Matrix's bounds.
     */
    public E getDataInMatrix(int x, int y) throws CoordinatesOutOfBoundsException {
        if (!checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException(x,y, new int[]{width,height});
        }
        return data[y][x];
    }

    /**
     * Clears the data at the given position
     * @param x the x coordinate
     * @param y the y coordinate
     * @return the data at that location, if any
     * @throws CoordinatesOutOfBoundsException if the given coordinates do not exist in this matrix.
     */
    public E clearData(int x, int y) throws CoordinatesOutOfBoundsException {
        if (!checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException(
                    x,y,
                    new int[]{this.width,this.height});
        }
        E d = data[y][x];
        data[y][x] = null;
        return d;
    }

    /**
     * Returns true if the coordinates are within the bounds of the Matrix
     * @param x the x coordinate to check
     * @param y the y coordinate to check
     * @return true if the coordinates are within the bounds of the Matrix
     */
    public boolean checkBounds(int x, int y) {
        return ((x >= 0 && x < this.getWidth()) && (y >= 0 && y < this.getHeight()));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Gets all data adjacent (8-way) to the given point.
     * A beautifully long method!
     * @param x the x coordinate
     * @param y the y coordinate
     * @return an ArrayList of all data that is adjacent to the given point
     * @throws CoordinatesOutOfBoundsException if the given coordinates do not exist within the matrix
     */
    public ArrayList<E> getAdjacentData(int x, int y)
            throws CoordinatesOutOfBoundsException {
        if (!checkBounds(x,y)) {
            throw new CoordinatesOutOfBoundsException(x,y, new int[]{width,height});
        }
        ArrayList<E> adjacent = new ArrayList<>();

        if (x == 0) {
            // left side x==0
            if (y == 0) {
                // Top Left Corner
                adjacent.add(this.getDataInMatrix(x+1,y));
                adjacent.add(this.getDataInMatrix(x+1,y+1));
                adjacent.add(this.getDataInMatrix(x,y+1));
            } else if (y == height-1) {
                // Bottom left corner
                adjacent.add(this.getDataInMatrix(x,y-1));
                adjacent.add(this.getDataInMatrix(x+1,y-1));
                adjacent.add(this.getDataInMatrix(x+1,y));
            } else {
                // left side
                adjacent.add(this.getDataInMatrix(x,y+1));
                adjacent.add(this.getDataInMatrix(x,y-1));
                adjacent.add(this.getDataInMatrix(x+1,y));
                adjacent.add(this.getDataInMatrix(x+1,y-1));
                adjacent.add(this.getDataInMatrix(x+1,y+1));
            }
        } else if (x == width-1) {
            // Right side
            if (y == 0) {
                // Top right corner
                adjacent.add(this.getDataInMatrix(x,1));
                adjacent.add(this.getDataInMatrix(x-1,1));
                adjacent.add(this.getDataInMatrix(x-1,0));
            } else if (y == height-1) {
                //Bottom right corner
                adjacent.add(this.getDataInMatrix(x-1,y-1));
                adjacent.add(this.getDataInMatrix(x,y-1));
                adjacent.add(this.getDataInMatrix(x-1,y));
            } else {
                // Right side
                adjacent.add(this.getDataInMatrix(x-1,y-1));
                adjacent.add(this.getDataInMatrix(x-1,y));
                adjacent.add(this.getDataInMatrix(x,y+1));
                adjacent.add(this.getDataInMatrix(x-1,y+1));
                adjacent.add(this.getDataInMatrix(x,y-1));
            }
        } else if (y == 0) {
            // Top row. We know x != 0, x != max
            adjacent.add(this.getDataInMatrix(x-1,y));
            adjacent.add(this.getDataInMatrix(x-1,y+1));
            adjacent.add(this.getDataInMatrix(x,y+1));
            adjacent.add(this.getDataInMatrix(x+1,y+1));
            adjacent.add(this.getDataInMatrix(x+1,y));
        } else if (y == height-1) {
            // Bottom row. We know x !=0, x != max
            adjacent.add(this.getDataInMatrix(x-1,y));
            adjacent.add(this.getDataInMatrix(x-1,y-1));
            adjacent.add(this.getDataInMatrix(x,y-1));
            adjacent.add(this.getDataInMatrix(x+1,y-1));
            adjacent.add(this.getDataInMatrix(x+1,y));
        } else {
            // Within the grid, with 8 neighbors.
            adjacent.add(this.getDataInMatrix(x,y-1));
            adjacent.add(this.getDataInMatrix(x,y+1));
            adjacent.add(this.getDataInMatrix(x-1,y));
            adjacent.add(this.getDataInMatrix(x-1,y+1));
            adjacent.add(this.getDataInMatrix(x-1,y-1));
            adjacent.add(this.getDataInMatrix(x+1,y+1));
            adjacent.add(this.getDataInMatrix(x+1,y));
            adjacent.add(this.getDataInMatrix(x+1,y-1));
        }
        return adjacent;
    }

    /**
     *
     * @return a String representation of the matrix, assuming the data it holds has a valid toString() method.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y=0; y < this.getHeight()-1; y++) {
        for (int y=0; y < this.getHeight()-1; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < this.getWidth()-1; x++) {
                row.append(this.getDataInMatrix(x,y).toString());
                if (x < this.getWidth() - 1) {
                    row.append(" ");
                }
            }
            sb.append(row);
            sb.append("\n");
        }
        return sb.toString();
    }

}
