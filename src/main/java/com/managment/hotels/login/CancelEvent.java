package com.managment.hotels.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CancelEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) { System.exit(0);

    }
}
