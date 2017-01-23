package com.agilie.internship.ui.login;

import com.agilie.internship.network.response.SignInResponse;

import rx.Observable;

public interface LoginContract {

    interface Model {
        Observable<SignInResponse> login(String email, String password);
        void saveUser(SignInResponse response);
    }

    interface View {
        void showProgressBar();
        void hideProgressBar();

        void setLoginButtonEnabled(boolean enabled);

        void showLoginError(String error);
        void showNetworkError();

        void navigateToMainScreen();
        void navigateToRegistrationScreen();
    }

    interface Presenter {
        void onDestroy();

        void requestLogin(String email, String password);
    }
}
