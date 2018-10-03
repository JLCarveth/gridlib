package com.carvethsolutions.test.gridlib.matrix;

import com.carvethsolutions.gridlib.matrix.NumberMatrix;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixIteratorTest {

    private NumberMatrix numberMatrix;

    @org.junit.jupiter.api.BeforeEach
    void setupMatrix() {
        numberMatrix = new NumberMatrix(4);
        int n = 0;
        for (int x=0; x < 4; x++) {
            for (int y=0; y< 4; y++) {
                numberMatrix.insertData(n,x,y);
                n++;
            }
        }
    }

    @org.junit.jupiter.api.Test
    void hasNext() {
        Iterator iter = numberMatrix.iterator();
        int count = 0;
        while (iter.hasNext()) {
            iter.next();
            count++;
        }

        assertEquals(16, count);

    }

    @org.junit.jupiter.api.Test
    void next() {
        int n = 0;
        for (int x=0; x < 4; x++) {
            for (int y=0; y < 4; y++) {
                assertEquals(n, (int)numberMatrix.getDataInMatrix(x,y));
                n++;
            }
        }
    }
}