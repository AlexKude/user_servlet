package com.service;

import com.model.User;

import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
public interface UserService {

    public void addUser(User newUser);

    public List<User> getAllUsers();

}
