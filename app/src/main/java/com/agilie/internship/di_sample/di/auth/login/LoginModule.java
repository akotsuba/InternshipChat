package com.agilie.internship.di_sample.di.auth.login;


import com.agilie.internship.di_sample.mvp.auth.LoginContract;
import com.agilie.internship.di_sample.mvp.auth.LoginModel;
import com.agilie.internship.network.UserWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    LoginContract.Model provideModel(UserWebService webService) {
        return new LoginModel(webService);
    }

    @Provides
    LoginContract.View provideView() {
        return view;
    }

//    @Provides
//    LoginContract.Presenter providePresenter(LoginContract.Model model) {
//        return new LoginPresenter(view, model);
//    }
}
