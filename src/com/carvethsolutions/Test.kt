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
 * A very messy test file I have been using to demonstrate how the libraries can be used.
 */
fun main(args: Array<String>) {
    // Create a NumberMatrix, n=50
    val matrix = NumberMatrix(50)
    // Populate that matrix (currently filled with null) with values between 0-9
    matrix.populate(0,9)

    // Create a TileMap object, 16 tiles by 16 tiles
    val tileMap = TileMap(16)
    // Create a TileMapPanel object, linking it to the TileMap
    val tmp = TileMapPanel(tileMap)

    // Fill in the TileMap with Tile objects
    for (x in 0..15) {
        for (y in 0..15) {
            if (x == 7 && y == 8) {
                tileMap.insertData(ColorTile(Color.RED,x,y))
            } else if (x == 3) {
                tileMap.insertData(ColorTile(null, x,y))
            }else {
                tileMap.insertData(SpriteTile("./res/grass.png",x,y))
            }
        }
    }

    //TileMapPanel allows us to register Observer classes, that will be called
    //whenever the panel detects a click.
    tmp.registerObserver({
        println("Click Detected... @$it")
    })

    // Just another insertData test. Notice our TileMap can hold/display
    // all subclasses of Tile.
    tileMap.insertData(ColorTile(Color.ORANGE, 0,0))

    // A Self-Destructing Frame
    val frame = SDFrame()
    // Add out TileMapPanel
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

    testMatrixAdjacency()
}

fun testMatrixAdjacency() {
    val matrix = NumberMatrix(10)
    matrix.populate(0,9)

    println(matrix.getAdjacentData(0,0))
    println(matrix.getAdjacentData(0,9))
    println(matrix.getAdjacentData(9,0))
    println(matrix.getAdjacentData(9,9))
    println(matrix.getAdjacentData(3,5))

    println(matrix)
}