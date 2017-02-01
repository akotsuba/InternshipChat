package com.agilie.internship.ui.splash_loader;

import com.agilie.internship.ui.PresenterFactory;

public class SplashPresenterFactory implements PresenterFactory<SplashPresenter> {

    SplashContract.Model model;

    public SplashPresenterFactory(SplashContract.Model model) {
        this.model = model;
    }

    @Override
    public SplashPresenter create() {
        return new SplashPresenter(model);
    }
}
