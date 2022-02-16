package me.henry.art;

import me.henry.art.canvas.Canvas;
import me.henry.art.controller.Controller;
import me.henry.art.types.SkyType;

import java.util.Random;

public class PixelArtGenerator {
    public static void main(String[] args) {
        Controller settings = new Controller();
        settings.setHeight(64);
        settings.setWidth(128);
        settings.setSky(SkyType.DAY);
        settings.setSkyColors(64);
        settings.setLandRatio(0.3);
        settings.setLandSamples(5);
        Canvas canvas = new Canvas(settings);
    }
}
