package com.carvethsolutions.gridlib.matrix;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Random;

/**
 * An implementation of @{link #AbstractMatrix} that holds Integer objects.
 */
public class NumberMatrix extends AbstractMatrix<Integer> {

    public NumberMatrix(int size) {
        super(size, Integer.class);
    }

    public NumberMatrix(int width, int height) {
        super(height, width, Integer.class);
    }

    /**
     * Populates the Matrix with random numbers
     * @param min the min random number
     * @param max the max random number
     */
    public void populate(int min, int max) {
        Random r = new Random();

        for (int x=0; x < getWidth(); x++) {
            for (int y=0; y < getHeight(); y++) {
                System.out.println("x: " + x + " y: " + y);
                insertData(r.nextInt(((max - min) + 1) + min), x, y);
            }
        }
    }

    /**
     * Note: Unless each number within the matrix is of the same digit count,
     * then the matrix will not print perfectly square.
     * @return String representation of the matrix
     */
    public String toString() {
        StringBuilder bigSB = new StringBuilder();
        for (int y=0; y < getHeight(); y++) {
            StringBuilder rowSB = new StringBuilder();
            for (int x=0; x < getWidth(); x++) {
                rowSB.append(this.getDataInMatrix(x,y));
                rowSB.append(' ');
            }
            bigSB.append(rowSB.toString());
            bigSB.append("\n");
        }

        return bigSB.toString();
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new MatrixIterator<>(this);
    }
}
