package com.agilie.internship.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.agilie.internship.ui.registration.RegistrationActivity;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private static final int SPLASH_SHOW_DELAY = 3 * 1000; // 3 sec

    SplashContract.Presenter presenter;

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // new Handler().postDelayed(this::navigateToRegistration, SPLASH_SHOW_DELAY);

        handler = new Handler();
        runnable = this::navigateToRegistration;

        // presenter = new LeakedSplashPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(runnable, SPLASH_SHOW_DELAY);
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        handler = null;
        runnable = null;

        super.onPause();
    }

    @Override
    public void navigateToRegistration() {
        Intent intent = RegistrationActivity.getIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }
}
