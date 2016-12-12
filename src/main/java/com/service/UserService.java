package com.service;

import com.model.User;

import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
public interface UserService {
    public String validateUserCredentials(String name,String userPassword);
}
