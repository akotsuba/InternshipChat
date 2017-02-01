package com.agilie.internship.ui.splash_loader;

import android.util.Log;

import com.agilie.internship.ui.Presenter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;

public class SplashPresenter implements Presenter {

    private SplashContract.Model model;
    private SplashContract.View view;

    private Subscription subscription;

    public SplashPresenter(SplashContract.Model model) {
        Log.d("test_presenter", "constructor");

        this.model = model;

        subscription = Observable.timer(this.model.getSplashDuration(), TimeUnit.SECONDS).subscribe(aLong -> {
            if (view != null) {
                Log.d("test_presenter", "subscribe view = " + view);
                view.navigateToMainScreen();
            }
        });
    }


    void onAttached(SplashContract.View view) {
        Log.d("test_presenter", "onAttached view = " + view);
        this.view = view;
    }

    void onDetached() {
        Log.d("test_presenter", "onDetached");
        this.view = null;
    }

    @Override
    public void onDestroyed() {
        subscription.unsubscribe();
        Log.d("test_presenter", "onDestroyed");
    }


}
