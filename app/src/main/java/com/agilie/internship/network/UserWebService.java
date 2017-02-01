package com.agilie.internship.network;

import com.agilie.internship.network.response.SignInResponse;
import com.agilie.internship.network.response.SignUpResponse;

import rx.Observable;

public interface UserWebService {

    Observable<SignInResponse> signIn(String email, String password);
    Observable<SignUpResponse> signUp(String email, String login, String password);
}
