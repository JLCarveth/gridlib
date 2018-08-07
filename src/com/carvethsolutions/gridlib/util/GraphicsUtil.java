package com.carvethsolutions.gridlib.util;

import java.awt.*;

/**
 * Utility class that offers extra functionality when using java.awt.Graphics
 */
public class GraphicsUtil {

    /**
     * Draws a filled circle with the center of the circle at point x,y.
     * Color must be set on the graphics object before calling this method.
     * @param g the graphics object
     * @param x the x coordinate of the circle
     * @param y the y coordiante of the circle
     * @param radius the radius of the circle
     */
    public static void drawCenteredCircleFill(Graphics g, int x, int y, int radius) {
        x = x - (radius / 2);
        y = y - (radius / 2);

        g.fillOval(x,y,radius,radius);
    }

    /**
     * Draws an unfilled circle with the center of the circle at point x,y.
     * Color must be set on the graphics object before calling this method.
     * @param g the graphics object
     * @param x the x coordinate of the circle
     * @param y the y coordiante of the circle
     * @param radius the radius of the circle
     */
    public static void drawCenteredCircle(Graphics g, int x, int y, int radius) {
        x = x - (radius / 2);
        y = y - (radius / 2);

        g.drawOval(x,y,radius,radius);
    }
}
