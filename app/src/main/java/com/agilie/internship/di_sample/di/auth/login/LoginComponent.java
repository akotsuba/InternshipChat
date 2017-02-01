package com.agilie.internship.di_sample.di.auth.login;

import com.agilie.internship.di_sample.mvp.auth.LoginViewFragment;

import dagger.Subcomponent;

@Subcomponent(modules = LoginModule.class)
@LoginScope
public interface LoginComponent {
    void inject(LoginViewFragment fragment);
}
