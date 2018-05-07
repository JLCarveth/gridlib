package com.carvethsolutions.guilib.listener;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Enables hint functionality in JTextFields
 * @author John on 5/7/2018
 * @project gridlib
 */
public class HintListener implements FocusListener {

    private String hint;

    private JTextField subject;

    /**
     *
     * @param hint the hint to display
     * @param subject the text field the listener is listening to.
     */
    public HintListener(String hint, JTextField subject) {
        this.hint = hint;
        this.subject = subject;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (subject.getText().equals(hint)) {
            subject.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (subject.getText().equals("")) {
            subject.setText(hint);
        }
    }
}
