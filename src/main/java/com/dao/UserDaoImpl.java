package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public String getUserCredentials(String name) {
        String password;
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("src/main/resources/credentials.properties");;
            Properties properties = new Properties();
            properties.load(fis);
            password = properties.getProperty(name);
            return password;
        } catch (IOException e) {
            throw new RuntimeException("Authentification failed");
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException("Authentification failed");
            }
        }
    }
}

