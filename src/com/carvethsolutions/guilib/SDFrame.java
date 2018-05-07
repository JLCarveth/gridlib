package com.carvethsolutions.guilib;

import javax.swing.*;

/**
 * Self-Destructing JFrame, so they don't hang around after the window is closed.
 * @author John on 5/7/2018
 * @project gridlib
 */
public class SDFrame extends JFrame {

    public SDFrame(String message) {
        super(message);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public SDFrame() {
        this("SDFrame");
    }
}
