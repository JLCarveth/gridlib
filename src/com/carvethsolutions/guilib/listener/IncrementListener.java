package com.carvethsolutions.guilib.listener;

import com.carvethsolutions.guilib.IncrementField;

/**
 * Field that allows for finely manipulating a numerical value within a JTextField
 *
 * @author John on 5/7/2018
 * @project gridlib
 */
public class IncrementListener {

    /**
     * The field this listener is attached to.
     */
    private IncrementField subject;

    /**
     * Constructor
     * @param subject The field the listener is listening to.
     */
    public IncrementListener(IncrementField subject) {
        super();
        this.subject = subject;
    }


    /**
     * Called when the increase command has been fired
     */
    public void increment() {
        int value = Integer.parseInt(subject.getText());
        value++;
        subject.setText(String.valueOf(value));
    }

    /**
     * Called when the decrease command has been fired
     */
    public void decrement() {
        int value = Integer.parseInt(subject.getText());
        value--;
        subject.setText(String.valueOf(value));
    }
}
