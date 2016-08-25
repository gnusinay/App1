package com.mercury.gnusin.app1;


/**
 * Created by gnusin on 25.08.2016.
 */
public class RainbowItem {
    private String text;
    private Integer color;

    public RainbowItem(String text, Integer color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }
}
