package com.managment.hotels.login;

import com.managment.hotels.hotels.event.EventBus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


import java.util.Collection;

public class LoginGridPane extends GridPane {
    private final Label usernameLabel = new Label("Korisničko ime");
    private final Label passwordLabel = new Label("Lozinka");
    private final TextField usernameTextField = new TextField();
    public String getUsernameTextField;
    public String getPasswordfield;
    private PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Prijava");
    private final Button cancelButton = new Button("Odustani");
    private final Label messageLabel = new Label();

    public LoginGridPane() {
    }
    public <SystemMetrics> TextField LoginGridPane(int LoginButton, jdk.internal.platform.SystemMetrics controller){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25,25,25,25));
        setAlignment(Pos.CENTER);

        add(usernameLabel,0,0);
        add(usernameTextField,1,0);
        add(passwordLabel,0,1);
        add(passwordField,1,1);
        FlowPane buttonFlowPane = new FlowPane();
        buttonFlowPane.setAlignment(Pos.CENTER_RIGHT);
        buttonFlowPane.getChildren().addAll(LoginButton, (Collection<? extends Node>) cancelButton);
        add(buttonFlowPane,1,2);
        add(messageLabel,1,2);


        controller = null;
        EventBus eventBus = (EventBus) controller.instance();
        loginButton.setOnAction((EventHandler<ActionEvent>) eventBus.getLoginEvent());
        cancelButton.setOnAction((EventHandler<ActionEvent>) eventBus.getCancelEvent());

        TextField getUsernameTextField;{
            return usernameTextField;

        }

    }

    public Label getMessageLabel() {
        return messageLabel;
    }

    public ButtonType getPasswordfield() {
        return null;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }
}




