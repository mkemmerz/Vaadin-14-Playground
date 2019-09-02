package com.packagename.myapp.spring.navigator;

import com.vaadin.flow.component.UI;

/**
 * Class handles the navigation between Components.
 *
 * Example: To move from the Login to the MainPage.
 */
public interface Navigator {

    /**
     * Navigate to a specific application URL.
     * Example: NavigatorPage.MainPage would lead the application to the main side.
     *
     * @param destinationPage The page you want to navigate to.
     */
    static void navigateTo(NavigatorPage destinationPage) {
        UI.getCurrent().navigate(destinationPage.getUrlPostfix());
    }
}
