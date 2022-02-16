package me.henry.art.util;

import me.henry.art.types.SkyType;

import java.awt.*;
import java.util.ArrayList;

public class ColourUtils {
    // hook up brightness so image deep and shallows aren't super contrasting or super bland.

    public static ArrayList<Color> generateSkyColours(SkyType sky, int skyColors) {
        if(sky.equals(SkyType.DAY)) {
            ArrayList<Color> colors = new ArrayList<>();
            colors.add(RandomUtils.boundedRGB(0, 20, 50, 120, 170, 200));
            String[] lightValues = RandomUtils.coordinatedValues(150, 255).split("\\.");
            colors.add(new Color(Integer.parseInt(lightValues[0]) / 2, Integer.parseInt(lightValues[1]), RandomUtils.boundedRandom(170, 230)));
            for(int i = 0; i < skyColors - 2; i++) {
                colors.add(1, getBetween(colors.get(0), colors.get(colors.size() - 1), (1.0f / (skyColors - 1) * (i + 1))));
            }
            return colors;
        }
        return null;
    }

    public static Color getBetween(Color first, Color second, double ratio) {
        int r = second.getRed() + Integer.parseInt(String.valueOf(((first.getRed() - second.getRed()) * ratio)).split("\\.")[0]);
        int g = second.getGreen() + Integer.parseInt(String.valueOf(((first.getGreen() - second.getGreen()) * ratio)).split("\\.")[0]);
        int b = second.getBlue() + Integer.parseInt(String.valueOf(((first.getBlue() - second.getBlue()) * ratio)).split("\\.")[0]);
        return new Color(r, g, b);
    }
}
