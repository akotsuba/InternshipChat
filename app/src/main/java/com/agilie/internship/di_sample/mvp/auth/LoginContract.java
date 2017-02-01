package com.agilie.internship.di_sample.mvp.auth;

import com.agilie.internship.data.User;
import com.agilie.internship.network.response.SignInResponse;

import rx.Observable;

public interface LoginContract {

    interface Model {
        Observable<SignInResponse> signIn(String email, String password);
    }

    interface View {
        // navigation
        void navigateToRegistration(User user);
        void navigateToMainScreen();
    }

    interface Presenter {
        void onGuestModeClicked();
        void onLoginFbClicked();
    }
}
