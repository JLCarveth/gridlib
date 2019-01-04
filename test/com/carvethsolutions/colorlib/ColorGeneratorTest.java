package com.carvethsolutions.colorlib;

import com.carvethsolutions.gridlib.tile.ColorTile;
import com.carvethsolutions.gridlib.tile.TileMap;
import com.carvethsolutions.gridlib.view.TileMapPanel;
import com.carvethsolutions.guilib.SDFrame;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for this class are fairly redundant. Only need to ensure the arrays contain
 * the correct objects ({@link Color}).
 * @author John on 2019-01-04
 * @project gridlib
 */
class ColorGeneratorTest {
    @Test
    void monochromatic() {
        ArrayList<Color> colors = ColorGenerator.monochromatic();
        boolean result = true;
        for (int i=0; i < 5; i++) {
            if (colors.get(i) == null) {
                result = false;
            }
        }

        assertTrue(result);
    }

    @Test
    void monochromatic3() {
        ArrayList<Color> colors = ColorGenerator.monochromatic3();
        boolean result = true;

        for (int i=0; i < 3; i++) {
            if (colors.get(i) == null) {
                result = false;
            }
        }
        assertTrue(result);
    }

    @Test
    void analogous() {
        ArrayList<Color> colors = ColorGenerator.analogous();
        boolean result = true;

        for (int i=0; i < 3; i++) {
            if (colors.get(i) == null) {
                result = false;
            }
        }
        assertTrue(result);
    }

    /**
     * Ensure no colors are equal to one another, and that the proper number of
     * colors are generated.
     */
    @Test
    void generateColors() {
        ArrayList<Color> colors = ColorGenerator.generateColors(360);
        assertTrue(colors.size() == 360);

        int x = 0;
        boolean result = true;

        while (!colors.isEmpty()) {
            Color c = colors.remove(x);
            if (colors.contains(c)) {
                result = false;
                break;
            }
        }
        assertTrue(result);
    }

}