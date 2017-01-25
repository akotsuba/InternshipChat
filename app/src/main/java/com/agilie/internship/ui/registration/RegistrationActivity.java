package com.agilie.internship.ui.registration;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.agilie.internship.R;

public class RegistrationActivity extends AppCompatActivity {

    private RegistrationContract.Presenter presenter;

    public static Intent getIntent(Context context) {
        return new Intent(context, RegistrationActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // presenter.signUp("e@ma.il", "superuser", "password");
    }
}
