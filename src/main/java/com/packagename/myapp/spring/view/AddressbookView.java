package com.packagename.myapp.spring.view;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(layout = MainView.class)
public class AddressbookView  extends Div {

    public AddressbookView() {
        Image image = new Image("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/32/Categories-applications-internet-icon.png", "Image");
        HorizontalLayout horizont = new HorizontalLayout();

        Div name = new Div();
        name.setText("Foo");

        VerticalLayout datum = new VerticalLayout();
        Div tag = new Div();
        tag.setText("07.11.2019");
        Div uhrzeit = new Div();
        uhrzeit.setText("18:30");
        datum.add(tag, uhrzeit);

        horizont.add(image, name, datum);
        add(horizont);

    }
}
