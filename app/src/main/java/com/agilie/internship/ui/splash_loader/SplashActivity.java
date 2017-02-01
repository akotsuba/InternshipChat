package com.agilie.internship.ui.splash_loader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.agilie.internship.ui.PresenterLoader;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private static final int SPLASH_SHOW_DELAY = 3; // 3 sec

    private static final int LOADER_ID = 1;
    private static final String TAG = "tag";

    SplashPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportLoaderManager().initLoader(LOADER_ID, null, new LoaderManager.LoaderCallbacks<SplashPresenter>() {
            @Override
            public final Loader<SplashPresenter> onCreateLoader(int id, Bundle args) {
                Log.i(TAG, "onCreateLoader");
                return new PresenterLoader<>(SplashActivity.this, getFactory(), TAG);
            }

            @Override
            public final void onLoadFinished(Loader<SplashPresenter> loader, SplashPresenter presenter) {
                Log.i(TAG, "onLoadFinished");
                SplashActivity.this.presenter = presenter;
                // onPresenterPrepared(presenter);
            }

            @Override
            public final void onLoaderReset(Loader<SplashPresenter> loader) {
                Log.i(TAG, "onLoaderReset");
                SplashActivity.this.presenter = null;
                // onPresenterDestroyed();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttached(this);
    }

    @Override
    protected void onStop() {
        presenter.onDetached();
        super.onStop();
    }

    @Override
    public void navigateToMainScreen() {
        Log.d("test_presenter", "navigateToMainScreen");
    }

    private SplashPresenterFactory getFactory() {
        SplashContract.Model model = new SplashModel(SPLASH_SHOW_DELAY);
        return new SplashPresenterFactory(model);
    }
}
