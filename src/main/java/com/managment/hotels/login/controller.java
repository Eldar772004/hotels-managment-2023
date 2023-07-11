package com.managment.hotels.login;

import com.managment.hotels.hotels.admin.AdminBorderPane;
import com.managment.hotels.hotels.event.EventBus;
import com.managment.hotels.hotels.user.User;
import javafx.stage.Stage;

import java.util.Objects;

public class controller {

    public static Object instance;
    private static controller INSTANCE = null;
    private LoginGridPane loginView;

    public LoginGridPane getloginView() {
        return null;
    }

    private UserBorderPane userView;
    private AdminBorderPane adminView;
    private Stage mainStage;
    private User LoggedUser;

    private final EventBus eventBus = new EventBus();

    private controller() {
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

    public static controller instance(){
        if(INSTANCE == null){
            INSTANCE = new controller();


}
        return INSTANCE;
    }
    public void setLoginView(LoginGridPane loginView) {
        this.loginView = loginView;

    }
    public LoginGridPane getLoginView() {
        return loginView;
    }
    public void setUserView(UserBorderPane userView) {
        this.userView = userView;
    }

    public UserBorderPane getUserView() {
        return userView;
    }

    public void setLoggedUser(User loggedUser) {
        this.LoggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return LoggedUser;
    }

}