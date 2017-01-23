package com.agilie.internship.ui.registration;

public class RegistrationPresenter implements RegistrationContract.Presenter {

    RegistrationContract.Model model;
    RegistrationContract.View view;

    public RegistrationPresenter(RegistrationContract.Model model, RegistrationContract.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void signUp(String email, String login, String password) {
        model.signUp(email, login, password)
                .doOnNext(user -> view.showSignUpSuccessMessage())
                .doOnError(throwable -> view.showSignUpError());
    }
}
