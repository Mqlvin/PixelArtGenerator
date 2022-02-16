package me.henry.art.util;

import me.henry.art.types.SkyType;

import java.awt.*;
import java.util.Random;

public class ColourUtils {
    // hook up brightness so image deep and shallows aren't super contrasting or super bland.

    public static Color[] generateSkyColours(SkyType sky) {
        if(sky.equals(SkyType.DAY)) {
            Color deepest = RandomUtils.boundedRGB(30, 50, 80, 150, 170, 230);
            String[] lightValues = RandomUtils.coordinatedValues(120, 230).split("\\.");
            Color shallowest = new Color(Integer.parseInt(lightValues[0]) / 2, Integer.parseInt(lightValues[1]), RandomUtils.boundedRandom(170, 230));

            Color middle = getBetween(deepest, shallowest, 0.5);
            Color deeper = getBetween(deepest, shallowest, 0.75);
            Color shallower = getBetween(deepest, shallowest, 0.25);
            return new Color[]{deepest, deeper, middle, shallower, shallowest};
        }

        // TODO: ITS GOING BACKWARDS NOW
        return null;
    }

    public static Color getBetween(Color first, Color second, double ratio) {
        int r = second.getRed() + Integer.parseInt(String.valueOf(((first.getRed() - second.getRed()) * ratio)).split("\\.")[0]);
        int g = second.getGreen() + Integer.parseInt(String.valueOf(((first.getGreen() - second.getGreen()) * ratio)).split("\\.")[0]);
        int b = second.getBlue() + Integer.parseInt(String.valueOf(((first.getBlue() - second.getBlue()) * ratio)).split("\\.")[0]);
        return new Color(r, g, b);
    }
}
