package com.packagename.myapp.spring.login;

import com.packagename.myapp.spring.navigator.Navigator;
import com.packagename.myapp.spring.navigator.NavigatorPage;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The LoginView shows a form for the user to enter username and password.
 * The user has to pass the authentication to be navigated to the main side.
 */
@Route("")
public class LoginView extends VerticalLayout {

    @Autowired
    DummyLoginService service;

    /**
     * Initialize a LoginView and append a LoginListener that handles the entered values for
     * username and password.
     */
    public LoginView()
    {
        LoginForm component = new LoginForm();
        component = appendLoginListener(component);
        add(component);
    }

    private LoginForm appendLoginListener(final LoginForm component)
    {
        component.addLoginListener(e -> {
            final boolean isAuthenticated = service.authenticate(e.getUsername(), e.getPassword());

            if (isAuthenticated)
                Navigator.navigateTo(NavigatorPage.MainPage);
            else
                component.setError(true);
        });

        return component;
    }
}
