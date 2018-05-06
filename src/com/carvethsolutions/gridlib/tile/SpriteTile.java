package com.carvethsolutions.gridlib.tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author John on 5/5/2018
 * @project gridlib
 */
public class SpriteTile implements Tile<Image> {

    private Image tileImage;

    private int x,y;

    public SpriteTile(String image, int x, int y) {
        try {
            tileImage = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
    }

    //TODO Add a default constructor that links to a default graphic
    /**
     * The tile paints any data it holds to the graphics object
     *
     * @param g         the graphics object onto which the tile will be painted
     * @param gridScale used to scale the tile drawing to the same size as others
     */
    @Override
    public void paint(Graphics g, int gridScale) {
        Image image = tileImage.getScaledInstance(gridScale, gridScale, Image.SCALE_DEFAULT);
        g.drawImage(image, this.x * gridScale, this.y * gridScale, null);
    }

    /**
     * Removes any data from the tile
     *
     * @return the data, if any
     */
    @Override
    public Image clearData() {
        return null;
    }
}
