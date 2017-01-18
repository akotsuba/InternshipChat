package com.agilie.internship.ui.login;

import com.agilie.internship.network.response.LoginResponse;

import rx.Observable;

public interface LoginContract {

    interface Model {
        Observable<LoginResponse> login(String email, String password);
        void saveUser(LoginResponse response);
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
