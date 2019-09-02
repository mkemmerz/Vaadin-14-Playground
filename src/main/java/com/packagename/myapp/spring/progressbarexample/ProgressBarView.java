package com.packagename.myapp.spring.progressbarexample;

import com.packagename.myapp.spring.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.Route;


@Route(layout = MainView.class)
public class ProgressBarView extends VerticalLayout {

    private final static double MIN_VALUE_PROGBAR = 0;
    private final static double MAX_VALUE_PROGBAR = 100;

    private final static int INCREASE_PROGBAR_BY = 5;

    private ProgressBar progressBar;

    public ProgressBarView() {
        createAndAddProgressBar();
        createAndAddProgressButton();
        createAndAddResetButton();
    }

    private void createAndAddProgressBar() {
        progressBar = new ProgressBar(MIN_VALUE_PROGBAR, MAX_VALUE_PROGBAR, MIN_VALUE_PROGBAR);
        add(progressBar);
    }

    private void createAndAddProgressButton() {
        Button progressButton = new Button("Make progress", e -> {
            double value = progressBar.getValue() + INCREASE_PROGBAR_BY;

            if (isProgressBarMaxed(value))
            {
                sendProgBarMaxedNotification();
                progressBar.setValue(MAX_VALUE_PROGBAR);
                return;
            }

            progressBar.setValue(value);
        });

        add(progressButton);
    }

    private boolean isProgressBarMaxed(final double value) {
        return value >= progressBar.getMax();
    }

    private void sendProgBarMaxedNotification()
    {
        Notification notification = new Notification("Progressbar has reached it max.",
                5000, Notification.Position.TOP_START);
        notification.open();
    }

    private void createAndAddResetButton() {
        Button resetProgress = new Button("Reset progress", e -> {
            progressBar.setValue(MIN_VALUE_PROGBAR);
        });
        add(resetProgress);
    }

}
