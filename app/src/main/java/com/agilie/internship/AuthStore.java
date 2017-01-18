package com.agilie.internship;

import com.agilie.internship.data.User;

/**
 * Created by serg on 1/18/17.
 */

public interface AuthStore {

    boolean isAuthorized();
    void setAuthorizedUser(User user);
}
