package com.packagename.myapp.spring.navigator;

/**
 * Representing the URLs the application has.
 */
public enum NavigatorPage {
    MainPage("main"), LoginPage("");

    private String urlPostfix;

    NavigatorPage(String postfix) {
        this.urlPostfix = postfix;
    }

    public String getUrlPostfix() {
        return urlPostfix;
    }
}
