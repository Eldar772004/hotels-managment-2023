package com.managment.hotels.hotels.service;

import com.hotelijerstvo.hoteli.user.service.UserService;
import com.managment.hotels.hotels.user.User;

import java.util.List;

public interface UserServiceLocal  extends BaseService<User, Integer>{
    UserServiceLocal USER_SERVICE = (UserServiceLocal) new UserService();

    User login(String username, String password);

    User Login(String usernameInput, String passwordInput);

    List<User> findall();
}
