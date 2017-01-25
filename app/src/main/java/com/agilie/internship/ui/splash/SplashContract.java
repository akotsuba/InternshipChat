package com.agilie.internship.ui.splash;

public interface SplashContract {

    interface Model {

    }

    interface View {
        void navigateToRegistration();
    }

    interface Presenter {
        void resume();
        void pause();
    }
}
