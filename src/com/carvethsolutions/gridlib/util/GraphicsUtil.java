package com.carvethsolutions.gridlib.util;

import java.awt.*;

public class GraphicsUtil {

    public void drawCenteredCircleFill(Graphics g, int x, int y, int radius) {
        x = x - (radius / 2);
        y = y - (radius / 2);

        g.fillOval(x,y,radius,radius);
    }

    public void drawCenteredCircle(Graphics g, int x, int y, int radius) {
        x = x - (radius / 2);
        y = y - (radius / 2);

        g.drawOval(x,y,radius,radius);
    }
}
