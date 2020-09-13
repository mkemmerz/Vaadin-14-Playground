package com.packagename.myapp.spring.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
public class TestView extends VerticalLayout {

    public TestView() {
        add("Welcome to this example application.");
    }
}
