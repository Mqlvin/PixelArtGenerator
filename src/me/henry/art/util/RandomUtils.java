package me.henry.art.util;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static Color randomRGB() {
        return new Color(random(255), random(255), random(255));
    }

    public static String coordinatedValues(int min, int max) {
        int first = boundedRandom(min, max);
        int second = 0;
        while(Math.abs(first - second) < max / 10 || second == 0) {
            second = boundedRandom(first - (max / 10), first + (max / 10));
        }
        return String.valueOf(MathUtils.clamp(first, max, min)).split("\\.")[0] + "." + String.valueOf(MathUtils.clamp(second, max, min)).split("\\.")[0];
    }

    public static int random(int bound) { // include bound
        return new Random().nextInt(bound + 1);
    }

    public static int boundedRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
