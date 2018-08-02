package com.carvethsolutions.gridlib.listener;

import com.carvethsolutions.gridlib.tile.Tile;

public interface TileMapObserver {
    /**
     * The method to be called when a click is detected on the TileMapPanel
     * @param tile the tile that was clicked
     */
    void onClick(Tile tile);
}
