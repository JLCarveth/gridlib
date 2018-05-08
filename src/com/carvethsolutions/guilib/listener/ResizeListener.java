package com.carvethsolutions.guilib.listener;

/**
 *
 * @author John on 5/7/2018
 * @project gridlib
 */
public interface ResizeListener {

    /**
     * Called to pass resize parameters to the appropriate class.
     * @param width the value from the width field
     * @param height the value from the height field
     */
    void resize(int width, int height);
}
