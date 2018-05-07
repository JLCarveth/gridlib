package com.carvethsolutions.guilib.listener;

import java.awt.*;

/**
 * Listener for ColorPalette
 * @author John on 5/7/2018
 * @project gridlib
 */
public interface ColorChangeListener {
    /**
     * Called whenever a new color is selected from the ColorPalette
     * @param color the new color
     */
    void colorChaned(Color color);
}
