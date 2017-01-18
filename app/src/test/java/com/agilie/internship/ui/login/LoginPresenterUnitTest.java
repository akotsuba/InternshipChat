package com.agilie.internship.ui.login;

import com.agilie.internship.network.response.LoginResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by serg on 1/18/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterUnitTest {

    @Mock
    LoginContract.Model model;

    @Mock
    LoginContract.View view;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(model, view);
    }

    @Test
    public void navigateToMainScreenShouldBeCalledOnSuccessLogin() {
        String email = "test@test.test";
        String password = "password";

        LoginResponse response = mock(LoginResponse.class);
        when(response.isSuccess()).thenReturn(true);

        when(model.login(email, password)).thenReturn(Observable.just(response));
        presenter.requestLogin(email, password);
        verify(view, times(1)).navigateToMainScreen();
    }

    @Test
    public void showLoginErrorScreenShouldBeCalledOnLoginFailed() {
        String email = "test@test.test";
        String password = "password";
        String error = "test error";

        LoginResponse response = mock(LoginResponse.class);
        when(response.isSuccess()).thenReturn(false);
        when(response.getError()).thenReturn(error);

        when(model.login(email, password)).thenReturn(Observable.just(response));
        presenter.requestLogin(email, password);
        verify(view, times(1)).showLoginError(error);
    }

    @Test
    public void showNetworkErrorScreenShouldBeCalledOnNetworkFailed() {
        String email = "test@test.test";
        String password = "password";

        when(model.login(email, password)).thenReturn(Observable.error(mock(Throwable.class)));
        presenter.requestLogin(email, password);
        verify(view, times(1)).showNetworkError();
    }
}
