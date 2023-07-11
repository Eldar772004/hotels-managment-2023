package com.managment.hotels.hotels.admin;

import com.managment.hotels.logout.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AdminBorderPane {
    public AdminBorderPane(Object userAdminPanel) {
        final ToggleButton userToggleButton = new ToggleButton("Korisnici");
        final ToggleButton roomToggleButton = new ToggleButton("Sobe");
        RoomAdminPanel roomAdminPanel;
        final Button logoutButton = new Button("Odjava");

            new AdminBorderPane();{
            userAdminPanel = new UserAdminPanel();
            setCenter(userAdminPanel);

            ToggleGroup toggleGroup = new ToggleGroup();
            userToggleButton.setToggleGroup(toggleGroup);
            userToggleButton.setSelected(true);
            roomToggleButton.setToggleGroup(toggleGroup);
            userToggleButton.setOnAction(this::setUserAdminPanel);
            roomToggleButton.setOnAction(this::setRoomAdminPanel);

            HBox mainMenuHBox = new HBox();
            mainMenuHBox.setSpacing(5);
            mainMenuHBox.setPadding(new Insets(10));
            mainMenuHBox.getChildren().addAll(userToggleButton, roomToggleButton);
    }
}

    public AdminBorderPane() {

    }

    private void setRoomAdminPanel(ActionEvent actionEvent) {
        RoomAdminPanel roomAdminPanel = new RoomAdminPanel();
        setCenter(roomAdminPanel);
    }

    private void setUserAdminPanel(ActionEvent actionEvent) {
        UserAdminPanel userAdminPanel = new UserAdminPanel();
        setCenter(userAdminPanel);
    }

    private void setCenter(Object userAdminPanel) {

    }
}
