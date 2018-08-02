package com.carvethsolutions.gridlib.view;

import com.carvethsolutions.gridlib.listener.TileMapObserver;
import com.carvethsolutions.gridlib.tile.TileMap;
import com.carvethsolutions.loglib.Loggable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import com.carvethsolutions.gridlib.tile.Tile;


/**
 * TileMapPanel graphically represents the data held by a TileMap data structure.
 * TODO: Add Observer pattern
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

    private ArrayList<TileMapObserver> observers;

    /**
     * Why are making useful comments so hard?
     *
     * Tilemap holds all the drawing data about the canvas (colors and where to put them)
     */
    private TileMap tilemap;

    private boolean gridLinesVisible = false;

    public TileMapPanel(TileMap tilemap) {
        super();

        calculateGridScale(tilemap.getWidth(), tilemap.getHeight());

        width = tilemap.getWidth() * gridScale;
        height = tilemap.getHeight() * gridScale;

        this.tilemap = tilemap;

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.WHITE);

        observers = new ArrayList<>();
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

        // Since the matrix stops before the last Tile...
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

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                notifyObservers(
                        tilemap.getDataInMatrix(
                                e.getX() / gridScale,
                                e.getY() / gridScale));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
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

    public void registerObserver(TileMapObserver listener) {
        observers.add(listener);
        System.out.println(observers);
    }

    public void unregisterObserver(TileMapObserver listener) {
        observers.remove(listener);
    }

    /**
     * Notify all observers
     */
    public void notifyObservers(Tile tile) {
        for (TileMapObserver o : observers) {
            o.onClick(tile);
        }
    }


    @Override
    public String getTag() {
        return "TileMapPanel";
    }

    /**
     * Private function to calculate how large to render each tile
     * We want the panel to have an approximate size of 500x500
     * @param width the width of the tilemap (in tiles)
     * @param height the height of the tilemap (in tiles)
     */
    private void calculateGridScale(int width, int height) {
        int scale;
        if (width > height) {
            double num = (double) 500 / width;
            scale = (int) Math.round(num);
        } else {
            double num = (double) 500 / height;
            scale = (int) Math.round(num);
        }

        gridScale = scale;
    }
}
