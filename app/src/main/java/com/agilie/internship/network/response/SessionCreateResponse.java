package com.agilie.internship.network.response;

import com.google.gson.annotations.SerializedName;

public class SessionCreateResponse {

    @SerializedName("token")
    String token;

    public String getToken() {
        return token;
    }
}
