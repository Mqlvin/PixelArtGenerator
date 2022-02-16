package me.henry.art.canvas;

import me.henry.art.controller.Controller;
import me.henry.art.types.SkyType;
import me.henry.art.util.CanvasUtils;
import me.henry.art.util.ColourUtils;
import me.henry.art.util.RandomUtils;

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
        ArrayList<Color> samples = new ArrayList<>();
        for(int i = 0; i < settings.getLandSamples(); i++) {
            Color newSample = ColourUtils.boundedRGB(55, 60, 25, 30, 0, 3);
            if(i == 0) {
                samples.add(ColourUtils.brightness(newSample, 0.8));
            } else if(i == settings.getLandSamples() - 1) {
                samples.add(ColourUtils.brightness(newSample, 1.2));
            } else {
                samples.add(newSample);
            }
        }
        this.image = CanvasUtils.drawSquare(this.image, 0, (int) (settings.getHeight() - (settings.getHeight() * settings.getLandRatio())), settings.getWidth(), settings.getHeight(), samples);
    }

    public BufferedImage output() {
        return image;
    }
}
