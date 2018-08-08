package com.carvethsolutions.guilib;

import com.carvethsolutions.guilib.listener.ColorChangeListener;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Custom component for displaying and selecting colors
 * @author John L. Carveth, 2018/05/07
 */
public class ColorPalette extends JPanel {

    private List<Color> colors = Arrays.asList(
            Color.BLUE,
            Color.RED,
            Color.GREEN,
            Color.YELLOW,
            Color.ORANGE,
            Color.MAGENTA,
            Color.PINK,
            Color.GRAY,
            Color.WHITE,
            Color.BLACK);

    private int columns;

    private Color selectedColor = colors.get(0);

    public enum Orientation {
        VERTICAL, HORIZONTAL
    }

    private Orientation orientation;

    private ColorChangeListener colorChangeListener;

    /**
     * Constructor
     * @param columns Number of columns the data should be displayed in
     * @param orientation The orientation of the component
     * @param colorChangeListener The listener called when a new color is selected
     */
    public ColorPalette(int columns, Orientation orientation, ColorChangeListener colorChangeListener) {
        super();
        this.orientation = orientation;
        this.columns = columns;
        this.colorChangeListener = colorChangeListener;

        this.setBorder(BorderFactory.createRaisedBevelBorder());

        if (orientation == Orientation.VERTICAL) {
            setLayout(new GridLayout(columns / colors.size(), columns));
        } else {
            setLayout(new GridLayout(columns, columns / colors.size()));
        }

        placeButtons();
    }

    private void placeButtons() {
        this.removeAll();
        revalidate();
        for (Color c : colors) {
            JButton button = new JButton();
            if (c == selectedColor) {
                button.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
            } else {
                button.setBorder(BorderFactory.createLoweredBevelBorder());
            }

            button.setPreferredSize(new Dimension(25,25));
            button.setBackground(c);

            button.addActionListener(e -> {
                colorChangeListener.colorChaned(((JButton) e.getSource()).getBackground());
                selectedColor = ((JButton) e.getSource()).getBackground();
                placeButtons();
            });

            this.add(button);
        }
    }

    public Color getSelectedColor() {
        return selectedColor;
    }
}
