package com.service;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String validateUserCredentials(String name,String userPassword){
        String validPassword = userDao.getUserCredentials(name);
        if (validPassword == null) return "login";
        if(userPassword.equals(validPassword)) return "OK";
        return "password";
    }
}

