package com.agilie.internship.di_sample.mvp.auth;

import com.agilie.internship.network.UserWebService;
import com.agilie.internship.network.response.SignInResponse;

import rx.Observable;

public class LoginModel implements LoginContract.Model {

    UserWebService webService;

    public LoginModel(UserWebService webService) {
        this.webService = webService;
    }

    @Override
    public Observable<SignInResponse> signIn(String email, String password) {
        return webService.signIn(email, password);
    }
}
