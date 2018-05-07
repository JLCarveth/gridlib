package com.carvethsolutions.guilib;

import com.carvethsolutions.guilib.listener.HintListener;
import javax.swing.*;

/**
 * Shows a hint when the focus is not on the field and it holds no data. Hint dissapears
 * when the field gains focus, and reappears if nothing was typed upon losing focus.
 *
 * @author John on 5/7/2018
 * @project gridlib
 */
public class HintTextField extends JTextField {

    private String hint;

    /**
     * Constructor
     * @param hint the hint to display
     */
    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;

        this.addFocusListener(new HintListener(hint, this));
    }

}
