package com.carvethsolutions.gridlib.matrix;

import com.carvethsolutions.gridlib.exception.CoordinatesOutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

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
    @BeforeEach
    void setupMatrix() {
        numberMatrix = new NumberMatrix(4);
        int n = 0;
        for (int y=0; y < 4; y++) {
            for (int x=0; x < 4; x++) {
                numberMatrix.insertData(n,x,y);
                n++;
            }
        }
    }


    /**
     * Verify that data is inserted into the matrix correctly.
     */
    @Test
    void insertData() {
        int n = 99;

        numberMatrix.insertData(n, 1,1);

        // Ensure the integer is in the correct location
        assertTrue(numberMatrix.getDataInMatrix(1,1) == 99);

        // Ensure an exception is thrown if the user tries to insert data out of the bounds of the matrix.
        assertThrows(CoordinatesOutOfBoundsException.class, () -> {
            numberMatrix.insertData(n,5,5);
        });
    }

    @Test
    void getDataInMatrix() {
        assertTrue(numberMatrix.getDataInMatrix(0,0) == 0);
        assertTrue(numberMatrix.getDataInMatrix(3,3) == 15);
        assertTrue(numberMatrix.getDataInMatrix(1,1) == 5);

        assertThrows(CoordinatesOutOfBoundsException.class, () -> {
           numberMatrix.getDataInMatrix(0,4);
        });
    }

    @Test
    void clearData() {
        // Ensure the proper value is returned
        assertTrue(numberMatrix.clearData(0,0) == 0);
        // Make sure the (0,0) coordinate is now empty
        assertTrue(numberMatrix.getDataInMatrix(0,0) == null);
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
        // Get adjacent points to (2,1). Should be [1,2,3,5,7,9,10,11]
        ArrayList<Integer> adjacent = numberMatrix.getAdjacentData(2,1);
        // Verify the appropriate number of points were returned
        assertTrue(adjacent.size() == 8);
        // Sort the list smallest to largest
        Collections.sort(adjacent);

        // Verify the smallest and largest elements of the list
        assertTrue(adjacent.get(0) == 1);
        assertTrue(adjacent.get(7) == 11);

        // Ensure corners / sides work:
        ArrayList<Integer> adjacentCorner = numberMatrix.getAdjacentData(3,3);
        assertTrue(adjacentCorner.size() == 3);
        assertTrue(adjacentCorner.contains(10)
                && adjacentCorner.contains(11) && adjacentCorner.contains(14));

        ArrayList<Integer> adjacentSide = numberMatrix.getAdjacentData(0,1);
        assertTrue(adjacentSide.size() == 5);
        assertTrue(adjacentSide.contains(0) &&
                adjacentSide.contains(5) && adjacentSide.contains(8));
    }
}