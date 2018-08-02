package com.carvethsolutions

import com.carvethsolutions.gridlib.matrix.NumberMatrix
import com.carvethsolutions.gridlib.point.PointMatrix
import com.carvethsolutions.gridlib.tile.ColorTile
import com.carvethsolutions.gridlib.tile.SpriteTile
import com.carvethsolutions.gridlib.tile.TileMap
import com.carvethsolutions.gridlib.view.PointMatrixPanel
import com.carvethsolutions.gridlib.view.TileMapPanel
import com.carvethsolutions.guilib.SDFrame
import java.awt.Color

/**
 * An Example of how the TileMap can be used with Tile objects and a TileMapPanel
 */
fun main(args: Array<String>) {
    val matrix = NumberMatrix(50)
    matrix.populate(0,9)

    val tileMap = TileMap(16)
    val tmp = TileMapPanel(tileMap)

    for (x in 0..15) {
        for (y in 0..15) {
            if (x == 7 && y == 8) {
                tileMap.insertData(ColorTile(Color.RED,x,y))
            }else {
                tileMap.insertData(SpriteTile("./res/grass.png",x,y))
            }
        }
    }


    tmp.registerObserver({
        println("Click Detected... @$it")
    })

    tileMap.insertData(ColorTile(Color.ORANGE, 0,0))
    val frame = SDFrame()
    frame.add(tmp)
    frame.pack()
    frame.isVisible = true


    val pointMatrix = PointMatrix(10)
    pointMatrix.connect(0,0,9,9)
    pointMatrix.connect(9,0,0,9)
    pointMatrix.connect(0,0,0,9)

    for (x in 5..8) {
        for (y in 4..8) {
            pointMatrix.connect(x,y,y,x)
        }
    }

    val pmp = PointMatrixPanel(pointMatrix)
    pmp.gridScale = 50
    val frame2 = SDFrame()

    frame2.add(pmp)
    frame2.pack()
    frame2.isVisible = true
}