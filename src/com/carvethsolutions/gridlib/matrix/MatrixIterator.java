package com.carvethsolutions.gridlib.matrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator to iterate through Matrix / 2D Array data structures
 *
 * @author John on 5/8/2018
 * @project gridlib
 */
public class MatrixIterator<T> implements Iterator<T> {

    private AbstractMatrix<T> matrix;

    private int currentCol, currentRow;


    public MatrixIterator(AbstractMatrix matrix) {
        this.matrix = matrix;
        currentCol = -1;
        currentRow = 0;

    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return !(currentRow == matrix.getHeight() - 1 && currentCol == matrix.getWidth() - 2);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
        T t = null;
        try {
            if (currentCol == matrix.getWidth() - 1) {
                currentCol = 0;
                currentRow++;
            } else {
                currentCol++;
            }

            t = matrix.getDataInMatrix(currentCol, currentRow);

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        return t;
    }
}
