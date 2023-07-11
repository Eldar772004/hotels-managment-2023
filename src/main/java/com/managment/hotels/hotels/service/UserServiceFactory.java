package com.managment.hotels.hotels.service;

import com.hotelijerstvo.hoteli.user.service.UserService;

public enum UserServiceFactory {
    USER_SERVICE(new UserService());

    private UserServiceLocal userServiceLocal;

    UserServiceFactory(UserService userServiceLocal){
    }

    public UserServiceLocal get() {
        return userServiceLocal;
    }
}
