package com.agilie.internship.ui.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agilie.internship.R;

public class RegistrationActivity extends AppCompatActivity {

    private RegistrationContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        presenter.signUp("e@ma.il", "superuser", "password");
    }
}
