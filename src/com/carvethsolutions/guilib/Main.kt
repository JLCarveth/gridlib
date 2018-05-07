package com.carvethsolutions.guilib

import com.carvethsolutions.guilib.listener.ResizeListener

/**
 *
 * @project gridlib
 * @author John on 5/7/2018
 */

fun main(args: Array<String>) {
    val frame = SDFrame()

    frame.add(ResizeComponent(ResizeListener { width, height ->
        println("Resize $width, $height")
    }))

    frame.pack()
    frame.show()
}
