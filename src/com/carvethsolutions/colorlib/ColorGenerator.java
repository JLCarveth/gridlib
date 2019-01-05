package com.carvethsolutions.colorlib;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Can be used to generate different combinations of colors.
 * @author John on 2019-01-03
 * @project gridlib
 */
public final class ColorGenerator {

    /**
     * Generates n random, vibrant colors and returns them in an ArrayList.
     * @param n the number of colors to generate. For best results, n<360
     * @return an {@link ArrayList<Color>} containing the generated colors.
     */
    public static ArrayList<Color> generateColors(int n) {
        ArrayList<Color> colors = new ArrayList<>();

        float angleStep = 360 / n;
        float angle = 0;

        for (int i=0; i < n; i++) {
            // Generate the color using Hue, Brightness and Saturation values.
            // Sat. and Bright. are maxed.
            Color c = Color.getHSBColor(angle / 360f, 1f, 1f);
            colors.add(c);

            // Increase the angle
            angle += i * angleStep;
        }
        return colors;
    }

    /**
     * Generates a 5-color monochromatic color palette with a random base color.
     * @return the 5 colors in an {@link ArrayList<Color>}
     */
    public static ArrayList<Color> monochromatic() {
        ArrayList<Color> colors = new ArrayList<>();
        Random r = new Random();
        int hue = r.nextInt(360);

        Color veryLight = Color.getHSBColor(hue / 360f, .4f, 1f);
        Color light = Color.getHSBColor(hue / 360f, .8f, 1f);
        Color baseColor = Color.getHSBColor(hue / 360f, 1f, 1f);
        Color dark = Color.getHSBColor(hue / 360f, 1f, .7f);
        Color veryDark = Color.getHSBColor(hue / 360f, 1f, .4f);

        colors.add(veryLight);
        colors.add(light);
        colors.add(baseColor);
        colors.add(dark);
        colors.add(veryDark);

        return colors;
    }

    /**
     * Similar to {@link #monochromatic() monochromatic} however this method only generates 3 colors.
     * @return the {@link ArrayList<Color>} containing 3 Color objects.
     */
    public static ArrayList<Color> monochromatic3() {
        ArrayList<Color> colors = new ArrayList<>();
        Random r = new Random();
        int hue = r.nextInt(360);

        Color base = Color.getHSBColor(hue / 360f, 1f, 1f);
        Color dark = Color.getHSBColor(hue / 360f, 1f, .6f);
        Color drkr = Color.getHSBColor(hue / 360f, 1f, .3f);

        colors.add(base);
        colors.add(dark);
        colors.add(drkr);

        return colors;
    }

    /**
     * Generates a 5-color analogous color scheme.
     * @return an {@link ArrayList<Color>} containing the generated Color object
     */
    public static ArrayList<Color> analogous() {
        ArrayList<Color> colors = new ArrayList<>();
        Random r = new Random();
        int baseHue = r.nextInt(360);

        Color c1 = Color.getHSBColor(baseHue / 360f, .8f, .8f);
        Color c2 = Color.getHSBColor(((baseHue + 60)%360) / 360f, .8f, .8f);
        Color c3 = Color.getHSBColor(((baseHue + 120)%360) / 360f, .8f, .8f);

        Color dark = Color.getHSBColor(baseHue / 360f, 1f, .3f);
        Color light = Color.getHSBColor(baseHue / 360f, .3f, 1f);

        colors.add(c1);
        colors.add(c2);
        colors.add(c3);
        colors.add(dark);
        colors.add(light);

        return colors;
    }
}
