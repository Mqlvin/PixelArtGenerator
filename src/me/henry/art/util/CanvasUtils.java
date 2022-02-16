package me.henry.art.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CanvasUtils {
    public static BufferedImage drawSquare(BufferedImage image, int x1, int y1, int x2, int y2, Color color) {
        int repeatX = x2 - x1;
        int repeatY = y2 - y1;
        for(int x = 0; x < repeatX; x++) {
            for(int y = 0; y < repeatY; y++) {
                image.setRGB(x1 + x, y1 + y, color.getRGB());
            }
        }
        return image;
    }
}
