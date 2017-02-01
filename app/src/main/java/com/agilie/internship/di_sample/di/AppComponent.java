package com.agilie.internship.di_sample.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.agilie.internship.di_sample.di.auth.login.LoginComponent;
import com.agilie.internship.di_sample.di.auth.login.LoginModule;
import com.agilie.internship.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RxModule.class, RetrofitModule.class})
public interface AppComponent {

    Context appContext();
    SharedPreferences sharedPreferences();
    SchedulerProvider networkSchedulerProvider();

    LoginComponent plusLoginComponent(LoginModule module);
}
