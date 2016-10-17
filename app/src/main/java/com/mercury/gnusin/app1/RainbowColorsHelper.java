package com.mercury.gnusin.app1;
import android.graphics.Color;



public class RainbowColorsHelper {

    public static class RainbowColor {
        private String title;
        private Integer color;

        public RainbowColor(String title, Integer color) {
            this.title = title;
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public Integer getColor() {
            return color;
        }
    }

    private static RainbowColor[] rainbowColors = { new RainbowColor("None", null),
                                                    new RainbowColor("Red", Color.RED),
                                                    new RainbowColor("Orange", Color.rgb(239, 179, 16)),
                                                    new RainbowColor("Yellow", Color.YELLOW),
                                                    new RainbowColor("Green",  Color.GREEN),
                                                    new RainbowColor("Blue", Color.BLUE),
                                                    new RainbowColor("Dark blue", Color.rgb(37, 141, 246)),
                                                    new RainbowColor("Purple", Color.rgb(162, 37, 246)) };


    public static RainbowColor getColorByPosition(int position) {
        return rainbowColors[position];
    }

    public static int getColorsCount() {
        return rainbowColors.length;
    }
}
