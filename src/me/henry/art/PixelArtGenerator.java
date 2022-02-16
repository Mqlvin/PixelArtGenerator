package me.henry.art;

import me.henry.art.generator.Canvas;
import me.henry.art.util.RandomUtils;

import javax.swing.*;
import java.util.Random;

public class PixelArtGenerator {
    public static final Random random = new Random();
    public static int height = 400;
    public static int width = 400;

    public static void main(String[] args) {
        Canvas canvas = new Canvas(50, 50);

        for(int i = 0; i < 100; i++) {
            System.out.println(RandomUtils.coordinatedValues(0, 50));
        }
    }
}
