package com.agilie.internship.ui.splash_loader;

public class SplashModel implements SplashContract.Model {

    int splashShowDuration;

    public SplashModel(int splashShowDuration) {
        this.splashShowDuration = splashShowDuration;
    }

    @Override
    public int getSplashDuration() {
        return splashShowDuration;
    }
}
