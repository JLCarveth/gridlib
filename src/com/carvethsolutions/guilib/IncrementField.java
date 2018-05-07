package com.carvethsolutions.guilib;

import com.carvethsolutions.guilib.listener.IncrementListener;

import javax.swing.*;
import java.awt.*;

/**
 * Field for allowing fine manipulation of a number within a JTextField
 *
 * @author John on 5/7/2018
 * @project gridlib
 */
public class IncrementField extends JPanel {

    private StackedButton sb;

    private JTextField field;

    private IncrementListener incrementListener;

    /**
     * Default constructor starts with a value of 0
     */
    public IncrementField() {
        super();

        setupComponent();

    }

    /**
     *
     * @param value The value at which to start incrementing
     */
    public IncrementField(int value) {
        super();

        setupComponent();
    }

    private void setupComponent() {
        field = new JTextField(6);

        sb = new StackedButton();

        this.setLayout(new GridBagLayout());

        field.setPreferredSize(new Dimension(field.getWidth(),50));


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 6;

        this.add(field, c);

        c.gridx = 6;
        c.gridy = 0;

        this.add(sb, c);

        field.setText("0");

        this.addIncrementListener(new IncrementListener(this));
    }

    public String getText() {
        return field.getText();
    }

    public void setText(String text) {
        field.setText(text);
    }

    public void addIncrementListener(IncrementListener incrementListener) {
        this.incrementListener = incrementListener;
    }

    public int getValue() {
        return Integer.parseInt(field.getText());
    }

    /**
     * Private class to encapsulate the stacked button code.
     */
    private class StackedButton extends JPanel {
        private JButton up,down;

        public StackedButton() {
            super();
            this.setLayout(new GridBagLayout());

            up = new JButton("\u25b4");
            up.setBackground(null);
            up.setPreferredSize(new Dimension(50,25));
            up.addActionListener(e -> {
                if (incrementListener != null) {
                    try {
                        int value = Integer.parseInt(field.getText());
                        value ++;
                    } catch (NumberFormatException e1) {

                    }
                    incrementListener.increment();
                }
            });

            down = new JButton("\u25be");
            down.setBackground(null);
            down.setPreferredSize(new Dimension(50,25));
            down.addActionListener(e ->  {
                if (incrementListener != null) {
                    incrementListener.decrement();
                }});

            GridBagConstraints c = new GridBagConstraints();

            c.gridx = 0;
            c.gridy = 0;
            c.gridheight = 1;
            c.gridwidth = 2;

            this.add(up, c);

            c.gridx = 0;
            c.gridy = 1;
            c.gridheight = 1;
            c.gridwidth = 2;

            this.add(down, c);

            this.setPreferredSize(new Dimension(50,50));

        }
    }
}
