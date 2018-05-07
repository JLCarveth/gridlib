package com.carvethsolutions.gridlib.tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * An implementation of a Tile that holds an image.
 * @author John on 5/5/2018
 * @project gridlib
 */
public class SpriteTile extends Tile<Image> {


    public SpriteTile(String image, int x, int y) {
        super(x,y);
        try {
            this.setData(ImageIO.read(new File(image)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor with a default sprite prodived
     */
    public SpriteTile(int x, int y) {
        this("res/grass.png", x, y);
    }

    /**
     * The tile paints any data it holds to the graphics object
     *
     * @param g         the graphics object onto which the tile will be painted
     * @param gridScale used to scale the tile drawing to the same size as others
     */
    @Override
    public void paint(Graphics g, int gridScale) {
        this.setData(this.getData().getScaledInstance(gridScale, gridScale, Image.SCALE_FAST));
        g.drawImage(this.getData(), this.getX() * gridScale, this.getY() * gridScale, null);
    }

    /**
     * Removes any data from the tile
     *
     * @return the data, if any
     */
    @Override
    public Image clearData() {
        Image image = this.getData();
        this.setData(null);

        return image;
    }
}
