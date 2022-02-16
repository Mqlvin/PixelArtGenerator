package me.henry.art.generator;

import me.henry.art.types.SkyType;
import me.henry.art.util.ColourUtils;
import me.henry.art.util.RandomUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas {
    private int width;
    private int height;
    private BufferedImage image;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        createImage();
        saveImage();
    }

    public void createImage() {
        Color[] colours = ColourUtils.generateSkyColours(SkyType.DAY);
        for(int i = 0; i < width; i++) {
            for(int ii = 0; ii < height; ii++) {
                image.setRGB(ii, i, colours[i / 10].getRGB());
            }
        }
    }

    public void saveImage() {
        try {
            ImageIO.write(image, "png", new File("output.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
