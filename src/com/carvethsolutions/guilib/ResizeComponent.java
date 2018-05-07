package com.carvethsolutions.guilib;

import com.carvethsolutions.guilib.listener.ResizeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Custom component offering resizing capabilities
 * @author John on 5/7/2018
 * @project gridlib
 */
public class ResizeComponent extends JPanel {

    private IncrementField width, height;

    private JButton resizeBtn;

    private ResizeListener listener;

    public ResizeComponent(ResizeListener listener) {
        super();

        width = new IncrementField();
        height = new IncrementField();

        resizeBtn = new JButton("Resize");
        resizeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.resize(width.getValue(), height.getValue());
            }
        });

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;

        this.add(new JLabel("Width: "),c);

        c.gridx = 1;

        this.add(width,c);

        c.gridx = 0;
        c.gridy = 1;

        this.add(new JLabel("Height: "),c);

        c.gridx = 1;

        this.add(height,c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;

        this.add(resizeBtn,c);
    }
}
