package me.henry.art.canvas;

import me.henry.art.controller.Controller;
import me.henry.art.types.SkyType;
import me.henry.art.util.CanvasUtils;
import me.henry.art.util.ColourUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class Populator {
    private Controller settings;
    private BufferedImage image;

    public Populator(Controller settings, BufferedImage image) {
        this.settings = settings;
        this.image = image;
    }

    public void addSky() {
        ArrayList<Color> colours = ColourUtils.generateSkyColours(SkyType.DAY, settings.getSkyColors());
        for(int i = 0; i < settings.getHeight(); i++) {
            for(int ii = 0; ii < settings.getWidth(); ii++) {
                image.setRGB(ii, i, colours.get(i / (settings.getHeight() / colours.size())).getRGB());
            }
        }
    }

    public void addLand() {
        this.image = CanvasUtils.drawSquare(this.image, 0, (int) (settings.getHeight() - (settings.getHeight() * settings.getLandRatio())), settings.getWidth(), settings.getHeight(), new Color(78, 36, 0));
    }

    public BufferedImage output() {
        return image;
    }
}
