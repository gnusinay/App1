package com.mercury.gnusin.app1;

import android.graphics.Color;

/**
 * Created by gnusin on 25.08.2016.
 */
public class RainbowItem {
    private String text;
    private Color color;

    public RainbowItem(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
