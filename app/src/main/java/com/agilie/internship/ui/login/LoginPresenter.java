package com.agilie.internship.ui.login;

import com.agilie.internship.utils.RxUtils;

import rx.subscriptions.CompositeSubscription;

public class LoginPresenter implements LoginContract.Presenter {

    private CompositeSubscription subscription;

    private LoginContract.Model model;
    private LoginContract.View view;

    public LoginPresenter(LoginContract.Model model, LoginContract.View view) {
        this.model = model;
        this.view = view;

        subscription = RxUtils.getNewCompositeSubIfUnsubscribed(subscription);
    }

    @Override
    public void onDestroy() {
        this.model = null;
        this.view = null;

        RxUtils.unsubscribeIfNotNull(subscription);
    }

    @Override
    public void requestLogin(String email, String password) {
        subscription.clear();
        subscription.add(model.login(email, password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .doOnRequest(onRequest -> view.showProgressBar())
                .doOnUnsubscribe(() -> view.hideProgressBar())
                .subscribe(loginResponse -> {
                    if (loginResponse.isSuccess()) {
                        model.saveUser(loginResponse);
                        view.navigateToMainScreen();
                    } else {
                        view.showLoginError(loginResponse.getError());
                    }
                }, error -> {
                    view.showNetworkError();
                }));
    }
}
