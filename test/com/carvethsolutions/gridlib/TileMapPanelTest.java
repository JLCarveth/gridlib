package com.carvethsolutions.gridlib;

import com.carvethsolutions.gridlib.tile.SpriteTile;
import com.carvethsolutions.gridlib.tile.TileMap;
import com.carvethsolutions.gridlib.view.TileMapPanel;
import com.carvethsolutions.loglib.Loggable;
import com.carvethsolutions.loglib.Logger;

import javax.swing.*;

/**
 * @author John on 5/7/2018
 * @project gridlib
 */
class TileMapPanelTest {
    public static void main(String args[]) {
        Logger.enableFileLogging();

        // Test how efficiently the TileMap paints large amounts of data
        testPaintingEfficiency(32,8);
        testPaintingEfficiency(32,16);
        testPaintingEfficiency(32,32);
        testPaintingEfficiency(32,64);

        testPaintingEfficiency(64,8);
        testPaintingEfficiency(64,16);
        testPaintingEfficiency(64,32);
        testPaintingEfficiency(64,64);

        testPaintingEfficiency(128,8);
        testPaintingEfficiency(128,16);
        testPaintingEfficiency(128,32);
        testPaintingEfficiency(128,64);
    }

    /**
     * Function to test how quickly the TileMapPanel draws data of certain sizes
     * @param size
     * @param gridScale
     */
    static void testPaintingEfficiency(int size, int gridScale) {
        TileMap tilemap = new TileMap(size);

        long start = System.currentTimeMillis();
        for (int x=0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tilemap.placeTile(new SpriteTile(x,y));
            }
        }

        TileMapPanel tmp = new TileMapPanel(tilemap, gridScale);
        JFrame frame = new JFrame();
        frame.add(tmp);
        frame.pack();
        frame.show();

        long stop = System.currentTimeMillis();
        long time = stop - start;

        Logger.log(new Loggable(){},
                "Painted Sprite Tiles ("+size+","+size+")" +
                        " Gridscale("+gridScale+")- " + time + "ms.", Logger.levels.INFO);

        frame.dispose();
    }

}