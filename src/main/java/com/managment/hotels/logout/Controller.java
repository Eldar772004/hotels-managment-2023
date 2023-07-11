package com.managment.hotels.logout;

import com.managment.hotels.hotels.admin.AdminBorderPane;
import com.managment.hotels.hotels.event.EventBus;
import com.managment.hotels.login.LoginGridPane;
import com.managment.hotels.login.UserBorderPane;
import com.managment.hotels.user.User;
import javafx.stage.Stage;


public class Controller {
    private static Controller INSTANCE = null;

    private LoginGridPane loginView;
    private UserBorderPane userView;
    private AdminBorderPane adminView;

    private Stage mainStage;

    private User loggedUser;

    private final EventBus eventBus = new EventBus();

    private Controller(){
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public void setLoginView(LoginGridPane loginView) {
        this.loginView = loginView;
    }

    public LoginGridPane getLoginView() {
        return loginView;
    }

    public void setAdminView(AdminBorderPane adminView) {
        this.adminView = adminView;
    }

    public AdminBorderPane getAdminView() {
        return adminView;
    }

    public void setUserView(UserBorderPane userView) {
        this.userView = userView;
    }

    public UserBorderPane getUserView() {
        return userView;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public static Controller instance(){
        if(INSTANCE == null){
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
}





