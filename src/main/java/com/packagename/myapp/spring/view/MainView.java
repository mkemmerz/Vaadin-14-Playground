package com.packagename.myapp.spring.view;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLayout;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The MainView represents the view that handles the overall forms of the application.
 */
@Route("main")
public class MainView extends AppLayout implements RouterLayout {

    private Map<Tab, String> tabToUrlMap = new LinkedHashMap<>();

    public MainView() {
        setupNavigationBar();
        setupTabs();
    }

    private void setupNavigationBar() {
        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);
    }

    private void setupTabs() {
        createTabsAndRouting();
        Tabs tabs = createTabsFromTabToUrlMap();
        addToDrawer(appendChangeListener(tabs));
    }

    private Tabs appendChangeListener(Tabs tabs) {
        tabs.addSelectedChangeListener(e ->
                UI.getCurrent().navigate(tabToUrlMap.get(e.getSelectedTab())));

        return tabs;
    }

    private Tabs createTabsFromTabToUrlMap() {
        Tabs tabs = new Tabs(tabToUrlMap.keySet().toArray(new Tab[]{}));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        return tabs;
    }

    private void createTabsAndRouting() {
        RouteConfiguration routeConfiguration = RouteConfiguration.forApplicationScope();
        tabToUrlMap.put(new Tab("Test"), routeConfiguration.getUrl(TestView.class));
        tabToUrlMap.put(new Tab("Progressbar"), routeConfiguration.getUrl(ProgressBarView.class));
        tabToUrlMap.put(new Tab("Addressbook"), routeConfiguration.getUrl(AddressbookView.class));
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        getElement().appendChild(content.getElement());
    }

}
