package com.agilie.internship.ui.splash;

import android.os.Handler;

public class LeakedSplashPresenter implements SplashContract.Presenter {

    SplashContract.View view;

    public LeakedSplashPresenter(SplashContract.View view) {
        this.view = view;

        new Handler().postDelayed(view::navigateToRegistration, 30000);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
