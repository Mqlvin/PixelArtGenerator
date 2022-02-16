package me.henry.art.controller;

import me.henry.art.types.SkyType;

public class Controller {
    private int width = 128;
    private int height = 128;

    private SkyType sky = SkyType.DAY;
    private int skyColors = 5;

    private double landRatio = 0.3;
    private int landSamples = 5;

    public Controller() {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public SkyType getSky() {
        return sky;
    }

    public void setSky(SkyType sky) {
        this.sky = sky;
    }

    public int getSkyColors() {
        return skyColors;
    }

    public void setSkyColors(int skyColors) {
        this.skyColors = skyColors;
    }

    public double getLandRatio() {
        return landRatio;
    }

    public void setLandRatio(double landRatio) {
        this.landRatio = landRatio;
    }

    public int getLandSamples() {
        return landSamples;
    }

    public void setLandSamples(int landSamples) {
        this.landSamples = landSamples;
    }
}
