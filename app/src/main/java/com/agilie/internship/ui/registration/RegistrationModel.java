package com.agilie.internship.ui.registration;

import com.agilie.internship.data.User;
import com.agilie.internship.db.Database;
import com.agilie.internship.network.AuthWebService;
import com.agilie.internship.network.UserWebService;
import com.agilie.internship.network.WebService;
import com.agilie.internship.rx.RetryWithDelay;

import rx.Observable;

public class RegistrationModel implements RegistrationContract.Model {

    WebService webService;
    AuthWebService authWebService;
    UserWebService userWebService;
    Database database;

    public RegistrationModel(WebService webService, AuthWebService authWebService, UserWebService userWebService, Database database) {
        this.webService = webService;
        this.authWebService = authWebService;
        this.userWebService = userWebService;
        this.database = database;
    }

    @Override
    public Observable<User> signUp(String email, String login, String password) {
        return authWebService.sessionCreate(1)
                // retry emitting observable elements in case of errors 3 times with 1000 ms delay (i. e. network error in our case)
                .retryWhen(new RetryWithDelay(3, 1000))
                // save token on success
                .doOnNext(sessionCreateResponse -> webService.setToken(sessionCreateResponse.getToken()))
                // map Observable<SessionCreateResponse> into Observable<SignUpResponse>
                .flatMap(sessionCreateResponse -> userWebService.signUp(email, login, password))
                // map Observable<SignUpResponse> to Observable<User>
                .flatMap(signUpResponse -> Observable.just(signUpResponse.getUser()))
                // save to DB
                .doOnNext(user -> database.saveUser(user));

    }
}
