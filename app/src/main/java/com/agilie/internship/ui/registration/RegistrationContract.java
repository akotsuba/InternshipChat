package com.agilie.internship.ui.registration;

import com.agilie.internship.data.User;

import rx.Observable;

public interface RegistrationContract {

    interface Model {
        Observable<User> signUp(String email, String login, String password);
    }

    interface View {
        void showSignUpSuccessMessage();
        void showSignUpError();
    }

    interface Presenter {
        void signUp(String email, String login, String password);
    }
}
