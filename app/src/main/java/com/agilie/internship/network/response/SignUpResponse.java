package com.agilie.internship.network.response;

import com.agilie.internship.data.User;
import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    @SerializedName("user")
    private User user;

    public User getUser() {
        return user;
    }
}
