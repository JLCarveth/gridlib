package com.carvethsolutions.gridlib;

import com.carvethsolutions.gridlib.tile.Tile;
import com.carvethsolutions.gridlib.tile.TileMap;
import com.carvethsolutions.loglib.Loggable;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * A custom component for displaying a grid
 */
public class TileMapPanel extends JPanel implements Loggable {

    /**
     * Width and height of the canvas, in pixels
     */
    private int width, height;

    /**
     * How many pixels represent one square on the grid
     */
    private int gridScale = 50;

    /**
     * Why are making useful comments so hard?
     *
     * Tilemap holds all the drawing data about the canvas (colors and where to put them)
     */
    private TileMap tilemap;

    private boolean gridLinesVisible = false;

    public TileMapPanel(TileMap tilemap) {
        super();

        width = tilemap.getWidth() * gridScale;
        height = tilemap.getHeight() * gridScale;

        this.tilemap = tilemap;

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.WHITE);
    }

    public TileMapPanel(TileMap tilemap, int gridScale) {
        super();
        this.gridScale = gridScale;
        this.tilemap = tilemap;

        width = tilemap.getWidth() * gridScale;
        height = tilemap.getHeight() * gridScale;

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.WHITE);
    }

    /**
     * Enable or disable grid lines from appearing on the Canvas
     */
    public void toggleGridlines() {
        gridLinesVisible = !gridLinesVisible;
        repaint();
    }

    /**
     * Iterate through our TileMap data structure,
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Called whenever the JPanel is being painted
        // Here we need to get the data from tilemap and paint it
        Iterator<Tile> iterator = tilemap.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            if (tile != null) {
                tile.paint(g, gridScale);
            }
        }

        // Since the iterator stops before the last colorTile...
        // Probably a change to the hasNext() function, or the while loop could fix this without the code repetition
        Tile tile = iterator.next();
        if (tile != null) {
            tile.paint(g, gridScale);
        }

        this.setBackground(Color.WHITE);

        g.setColor(Color.BLACK);
        //Gridlines
        if (gridLinesVisible) {
            // Vertical lines
            for (int x=0; x < width; x += gridScale) {
                g.drawLine(x,0,x,height);
            }
            // Horizontal lines
            for (int y=0; y < height; y += gridScale) {
                g.drawLine(0, y, width, y);
            }
        }
    }


    @Override
    public String getTag() {
        return "TileMapPanel";
    }

    public int getGridScale() {
        return gridScale;
    }

    public TileMap getTilemap() {
        return tilemap;
    }

    public boolean isGridLinesVisible() {
        return gridLinesVisible;
    }

    /**
     * @param gridLinesVisible
     */
    public void setGridLinesVisible(boolean gridLinesVisible) {
        this.gridLinesVisible = gridLinesVisible;
        repaint();
    }
}
