package com.dao;

import com.model.User;

import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
public interface UserDao {

    public List<User> getUserList();

    public void setUserList(List<User> userList);

}
