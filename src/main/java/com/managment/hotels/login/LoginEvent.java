package com.managment.hotels.login;

import com.managment.hotels.gui.components.ProgressForm;
import com.managment.hotels.hotels.admin.AdminBorderPane;
import com.managment.hotels.hotels.admin.UserAdminPanel;
import com.managment.hotels.hotels.privilege.Privilege;
import com.managment.hotels.hotels.service.UserServiceFactory;
import com.managment.hotels.hotels.service.UserServiceLocal;
import com.managment.hotels.hotels.user.User;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jdk.internal.platform.SystemMetrics;

import java.util.Objects;

public class LoginEvent<Controller> implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        ProgressForm progressForm = new ProgressForm();
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                for (int i = 0; i < 10; i++) {
                    updateProgress(i, 10);
                    Thread.sleep(200);

            }
                updateProgress(10,10);
                return null;
            }
        };
        progressForm.activateProgressBar(task);
        task.setOnSucceeded(event ->
            progressForm.getDialogStage().close());
    };
    private SystemMetrics Controller;
    controller controller;

    {
        controller = (com.managment.hotels.login.controller) Controller.instance();
        LoginGridPane loginGridPane = controller.getloginView();
        String usernameInput = loginGridPane.getUsernameTextField().getText();
        if(usernameInput == null || usernameInput.isBlank()){
            Label messageLabel = loginGridPane.getMessageLabel();
            messageLabel.setText("Korsničko ime je prazno");

    }
        String passwordInput = loginGridPane.getPasswordfield().getText();
        if (passwordInput == null  || passwordInput.isBlank()){
            Label messageLabel = loginGridPane.getMessageLabel();
            messageLabel.setText("Neispravna kombinacija korisničkog imena i lozinke");

    }
        UserServiceLocal userServiceLocal = UserServiceFactory.USER_SERVICE.get();
        User user = userServiceLocal.Login(usernameInput,passwordInput);
        if (user == null){
            Label messageLabel = loginGridPane.getMessageLabel();
            messageLabel.setText("Neispravna kombinacija korisničkog imena i lozinke");

}
        controller.setLoggedUser(user);
        swapView();
}

    private void swapView() {
        controller controller  = (com.managment.hotels.login.controller) Controller.instance();
        User user = controller.getLoggedUser();
        Privilege privilege = user.getPrivilege();
        if ("admin".equalsIgnoreCase(privilege.getName())){
            UserAdminPanel userAdminPanel = new UserAdminPanel();
            showAdminView(userAdminPanel);
        }else{
    }
}

    private void showAdminView(UserAdminPanel userAdminPanel) {
        controller controller = (com.managment.hotels.login.controller) Controller.instance();
        UserBorderPane userView = new UserBorderPane();
        controller.setUserView(userView);
        controller.getMainStage().setTitle("User Panel");
        setupOnStage(userView);
    }

    private void setupOnStage(UserBorderPane userView) {
        Controller controller = (Controller) Controller.instance();
        AdminBorderPane adminView = new AdminBorderPane();
    }

    private Object userAdminPanel;
    AdminBorderPane adminView = new AdminBorderPane(userAdminPanel);
    private void showUserView(){
        Controller controller = (Controller) Controller.instance();
        UserBorderPane userView = new UserBorderPane();
        Controller controller1 = controller;
        setupOnStage(userView);
    }

}







