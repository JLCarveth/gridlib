package com.carvethsolutions.gridlib.tile;

import com.carvethsolutions.gridlib.matrix.AbstractMatrix;

import java.util.Random;

public class NumberMatrix extends AbstractMatrix<Integer> {
    public NumberMatrix(Integer[][] data) {
        super(data);
    }

    public NumberMatrix(int size) {
        super(size);
    }

    public NumberMatrix(int width, int height) {
        super(width, height);
    }

    /**
     * Populates the
     * @param min
     * @param max
     */
    public void populate(int min, int max) {
        Random r = new Random();

        for (int x=0; x < getWidth() - 1; x++) {
            for (int y=0; y < getHeight() - 1; y++) {
                insertData(r.nextInt(((max - min) + 1) + min), x, y);
            }
        }
    }

    public String toString() {
        StringBuilder bigSB = new StringBuilder();
        for (int y=0; y < getHeight()-1; y++) {
            StringBuilder rowSB = new StringBuilder();
            for (int x=0; x < getWidth()-1; x++) {
                rowSB.append(this.getDataInMatrix(x,y));
            }
            bigSB.append(rowSB.toString());
            bigSB.append("\n");
        }

        return bigSB.toString();
    }
}
