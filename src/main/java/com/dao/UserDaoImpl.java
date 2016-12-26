package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by BGClassTeacher on 08.12.2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    EntityManager manager = Persistence.createEntityManagerFactory("NewPersistenceUnit").createEntityManager();

    public List<User> getUserList() {
        manager.getTransaction().begin();
        Query nativeQuery = manager.createNativeQuery("SELECT * FROM user_account.users", User.class);
        manager.getTransaction().commit();
        List<User> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public void addUser(User user) {
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
    }

}

