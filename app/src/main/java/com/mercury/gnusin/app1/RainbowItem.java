package com.mercury.gnusin.app1;


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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return this.getText().equals(((RainbowItem) obj).getText());
    }
}
