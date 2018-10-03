package com.carvethsolutions.gridlib.matrix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMatrixTest {

    private static NumberMatrix numberMatrix;

    /**
     * Setup a test matrix to be used for all tests.
     * A number matrix as such:
     * 0   1   2   3
     * 4   5   6   7
     * 8   9   10  11
     * 12  13  14  15
     */
    @BeforeAll
    static void setupMatrix() {
        numberMatrix = new NumberMatrix(4);
        int n = 0;
        for (int x=0; x < 4; x++) {
            for (int y=0; y < 4; y++) {
                numberMatrix.insertData(n,x,y);
                n++;
            }
        }
    }

    @Test
    void insertData() {
    }

    @Test
    void getDataInMatrix() {
    }

    @Test
    void clearData() {
    }

    @Test
    void checkBounds() {
        assertFalse(numberMatrix.checkBounds(-1, -1));
        assertFalse(numberMatrix.checkBounds(0,-1));
        assertFalse(numberMatrix.checkBounds(-1,0));
        assertFalse(numberMatrix.checkBounds(4,2));
        assertFalse(numberMatrix.checkBounds(1,4));

        assertTrue(numberMatrix.checkBounds(3,3));
        assertTrue(numberMatrix.checkBounds(0,0));
        assertTrue(numberMatrix.checkBounds(0,3));
        assertTrue(numberMatrix.checkBounds(2,1));
    }

    @Test
    void getWidth() {
        assertEquals(4, numberMatrix.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(4, numberMatrix.getWidth());
    }

    @Test
    void getAdjacentData() {
    }
}