package com.agilie.internship.di_sample.mvp.auth;

import javax.inject.Inject;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginContract.Model model;

    @Inject
    public LoginPresenter(LoginContract.View view, LoginContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onGuestModeClicked() {
        view.navigateToMainScreen();
    }

    @Override
    public void onLoginFbClicked() {
        model.login();
        // SerializationService.getInstance().serializeModel(getActivity(), com.snowracer.app.Constants.USER_FB_KEY, user);
    }
}
