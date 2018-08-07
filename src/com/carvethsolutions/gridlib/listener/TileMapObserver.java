package com.carvethsolutions.gridlib.listener;

import com.carvethsolutions.gridlib.tile.Tile;

/**
 * Observer to be registered to TileMapPanel to notify of any clicks to the panel.
 */
public interface TileMapObserver {
    /**
     * The method to be called when a click is detected on the TileMapPanel
     * @param tile the tile that was clicked
     */
    void onClick(Tile tile);
}
