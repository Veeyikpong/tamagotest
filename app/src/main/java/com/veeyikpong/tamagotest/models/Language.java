package com.veeyikpong.tamagotest.models;

public class Language {
    private int color;
    private int language;

    public Language(int color,int language){
        this.color = color;
        this.language = language;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }
}
