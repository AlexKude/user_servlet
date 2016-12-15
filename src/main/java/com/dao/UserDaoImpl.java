package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by BGClassTeacher on 08.12.2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public List<User> userList = new ArrayList<User>();


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

