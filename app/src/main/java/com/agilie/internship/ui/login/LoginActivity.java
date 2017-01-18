package com.agilie.internship.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.agilie.internship.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void setLoginButtonEnabled(boolean enabled) {

    }

    @Override
    public void showLoginError(String error) {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void navigateToMainScreen() {

    }

    @Override
    public void navigateToRegistrationScreen() {

    }
}
