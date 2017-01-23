package com.agilie.internship.ui.login;

import com.agilie.internship.AuthStore;
import com.agilie.internship.data.User;
import com.agilie.internship.network.UserWebService;
import com.agilie.internship.network.response.SignInResponse;

import rx.Observable;

/**
 * Created by serg on 1/18/17.
 */

public class LoginModel implements LoginContract.Model {

    private UserWebService userWebService;
    private AuthStore authStore;

    public LoginModel(UserWebService userWebService, AuthStore authStore) {
        this.userWebService = userWebService;
        this.authStore = authStore;
    }

    @Override
    public Observable<SignInResponse> login(String email, String password) {
        return userWebService.signIn(email, password);
    }

    @Override
    public void saveUser(SignInResponse loginResponse) {
        Observable.just(loginResponse).map(response -> {
            User user = new User();
            user.setId(response.getId());
            user.setEmail(response.getEmail());
            return user;
        }).doOnNext(user -> authStore.setAuthorizedUser(user));
    }
}
