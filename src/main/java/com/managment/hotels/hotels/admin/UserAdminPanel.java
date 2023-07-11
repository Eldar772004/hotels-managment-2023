package com.managment.hotels.hotels.admin;

import com.managment.hotels.hotels.event.PrivilegeServiceLocal;
import com.managment.hotels.hotels.service.UserServiceFactory;
import com.managment.hotels.hotels.service.UserServiceLocal;
import com.managment.hotels.hotels.user.Privilege;
import com.managment.hotels.hotels.user.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

import static java.util.Collections.addAll;

public class UserAdminPanel extends VBox {
    private final Label titleLabel = new Label("Administracija korisnika");
    private final TableView<User> userTableView = new TableView<>();

    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final TextField nameTextField = new TextField();
    private final TextField surnameTextField = new TextField();
    private final ChoiceBox<Object> privilegeChoiceBox = new ChoiceBox<Object>();
    private final Button addButton = new Button("Dodaj korisnika");
    private final Button deleteButton = new Button("Obriši");



    private ObservableList<User> observableUserList;

    private User selectedUser = null;
    private Object newUser;
    public void UserAdminPanell(){
        titleLabel.setFont(new Font("Arial",20));
        setSpacing(5);
        setPadding(new Insets(10));
        bindTableWithData();
        configureTableView();



        getChildren().addAll(titleLabel,userTableView,getForm());
}

    private void bindTableWithData() {
    }

    private HBox getForm() {

        HBox usernameFormHBox = new HBox();
        usernameFormHBox.setSpacing(5);
        usernameTextField.setPromptText("Enter username...");
        passwordField.setPromptText("Enter password..");
        nameTextField.setPromptText("Enter name...");
        surnameTextField.setPromptText("Enter surname...");
        List<Object> privilegeList = PrivilegeServiceLocal.SERVICE.findAll();
        ObservableList<Object> observableList = FXCollections.observableList(privilegeList);
        privilegeChoiceBox.setItems(observableList);
        privilegeChoiceBox.getSelectionModel().select(0);
        usernameFormHBox.
                getChildren();
        addAll(usernameTextField,
                passwordField,
                nameTextField,
                surnameTextField,
                privilegeChoiceBox,
                addButton,
                deleteButton);
        addButton.setOnAction(this::onAddButtonHandle);
        deleteButton.setOnAction(this::onDeleteUserHandle);
        return usernameFormHBox;

    }

    private void onEditUserHandle(ActionEvent actionEvent) {
        final User user = userTableView.getSelectionModel().getSelectedItem();

    }
    private void onDeleteUserHandle(ActionEvent actionEvent) {
       if (selectedUser != null) {
        //UserServiceLocal userService = UserServiceLocal.USER_SERVICE.delete(selectedUser);
           observableUserList.remove(selectedUser);
       }
    }


    private void addAll(TextField usernameTextField, PasswordField passwordField, TextField nameTextField, TextField surnameTextField, ChoiceBox<Object> privilegeChoiceBox, Button addButton, Button deleteButton) {
    }




    private void onAddButtonHandle(ActionEvent actionEvent) {
        String usernameInput = usernameTextField.getText();
        String passwordInput = passwordField.getText();
        String nameInput =  nameTextField.getText();
        String surnameInput = surnameTextField.getText();
        Privilege privilege = (Privilege) privilegeChoiceBox.getSelectionModel().getSelectedItem();
        User user = new User(usernameInput,passwordInput,nameInput,surnameInput,privilege);
        UserServiceLocal.USER_SERVICE.save(user);
        clearinput();
        observableUserList.add(user);
    }

    private void clearinput() {
        usernameTextField.clear();
        passwordField.clear();
        nameTextField.clear();
        surnameTextField.clear();
        privilegeChoiceBox.getSelectionModel().select(0);
    }

    private void configureTableView() {
        TableColumn<User,String> nameColumn = new TableColumn<>("Ime");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<User,String> surnameColumn = new TableColumn<>("Prezime");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));


        TableColumn<User,String> usernameColumn = new TableColumn<>("Korisničko ime");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));


        TableColumn<User, Privilege> privilegeColumn = new TableColumn<>("Privilegija");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("privilege"));

        userTableView.getColumns().addAll(nameColumn,surnameColumn,usernameColumn,privilegeColumn);
        TableView.TableViewSelectionModel<User> selectionModel =  userTableView.getSelectionModel();
        return selectionModel.selectedItemProperty().addListener(new ChangeListener<User>() {

            @Override
            public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) {
                System.out.println("STARI USER " + oldValue);
                System.out.println("NOVI USER" + newValue);
                selectedUser = newValue;
                setupForm(newValue);
            }

            private void setupForm(User newValue) {

            }

            private void bindTableWithData() {
                UserServiceLocal userService = UserServiceFactory.USER_SERVICE.get();
                List<User> userList = userService.findall();
                observableUserList = FXCollections.observableList(userList);
                userTableView.setItems(observableUserList);
            }

        };

    ;};


}

