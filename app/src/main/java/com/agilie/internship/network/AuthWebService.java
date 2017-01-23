package com.agilie.internship.network;

import com.agilie.internship.network.response.SessionCreateResponse;

import rx.Observable;

public interface AuthWebService {

    Observable<SessionCreateResponse> sessionCreate(int applicationId);
}
