package com.example.testvirtualapp;

import android.graphics.drawable.Drawable;

public class ItemApp {

    private String nameApp;
    private Drawable drawable;

    public ItemApp(String nameApp, Drawable drawable) {
        this.nameApp = nameApp;
        this.drawable = drawable;
    }

    public String getNameApp() {
        return nameApp;
    }

    public void setNameApp(String nameApp) {
        this.nameApp = nameApp;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
