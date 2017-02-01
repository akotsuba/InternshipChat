package com.agilie.internship.di_sample.mvp.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agilie.internship.InternshipApplication;
import com.agilie.internship.R;
import com.agilie.internship.data.User;
import com.agilie.internship.di_sample.di.auth.login.LoginModule;
import com.agilie.internship.ui.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginViewFragment extends Fragment implements LoginContract.View {

    @Inject
    LoginPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        InternshipApplication.get(getActivity()).getAppComponent().plusLoginComponent(new LoginModule(this)).inject(this);
    }

    @OnClick(R.id.fragment_login_button_guest_mode)
    public void onGuestModeClicked() {
        presenter.onGuestModeClicked();
    }

    @OnClick(R.id.fragment_login_button_connect_facebook)
    public void onLoginFbClicked() {
        presenter.onLoginFbClicked();
    }

    @Override
    public void navigateToRegistration(User user) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_login_button_connect_facebook, new Fragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void navigateToMainScreen() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
