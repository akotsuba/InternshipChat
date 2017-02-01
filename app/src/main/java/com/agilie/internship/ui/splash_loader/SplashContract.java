package com.agilie.internship.ui.splash_loader;

/**
 * Created by serg on 2/1/17.
 */

public interface SplashContract {

    interface Model {
        int getSplashDuration();
    }

    interface View {
        void navigateToMainScreen();
    }
}
