package com.agilie.internship.network;

import com.agilie.internship.network.response.LoginResponse;

import rx.Observable;

/**
 * Created by serg on 1/18/17.
 */

public interface UserWebService {
    Observable<LoginResponse> login(String email, String password);
}
