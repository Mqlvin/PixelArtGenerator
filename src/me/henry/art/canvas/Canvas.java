package me.henry.art.canvas;

import me.henry.art.PixelArtGenerator;
import me.henry.art.controller.Controller;
import me.henry.art.types.SkyType;
import me.henry.art.util.CanvasUtils;
import me.henry.art.util.ColourUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Canvas {
    private int width;
    private int height;
    private BufferedImage image;

    private Controller settings;
    private Populator populator;

    public Canvas(Controller settings) {
        this.width = settings.getWidth();
        this.height = settings.getHeight();
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.settings = settings;

        createImage();
        saveImage();
    }

    public void createImage() {
        populator = new Populator(settings, image);
        populator.addSky();
        populator.addLand();
        image = populator.output();



    }

    public void saveImage() {
        try {
            ImageIO.write(image, "png", new File("output.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
