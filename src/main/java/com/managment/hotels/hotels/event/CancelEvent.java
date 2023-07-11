package com.managment.hotels.hotels.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CancelEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.exit(0);
}
}
