package me.henry.art.util;

public class MathUtils {
    public static float clamp(float value, float max, float min) {
        return Math.max(min, Math.min(max, value));
    }
}
