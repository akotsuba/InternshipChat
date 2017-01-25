package com.agilie.internship.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

import com.agilie.internship.R;
import com.agilie.internship.ui.registration.RegistrationActivity;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import rx.functions.Action1;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText loginEditText = (EditText) findViewById(R.id.loginEditText);

        RxTextView.textChanges(loginEditText).subscribe(charSequence -> { /* Something here */ });
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
