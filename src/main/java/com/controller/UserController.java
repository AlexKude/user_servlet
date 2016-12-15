package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
@WebServlet(urlPatterns = "/users")
public class UserController extends HttpServlet {
    @Autowired
    private UserService userService;

    @Override
    public void init() throws ServletException {
        AutowireCapableBeanFactory factory = WebApplicationContextUtils.
                getWebApplicationContext(getServletContext())
                .getAutowireCapableBeanFactory();
        factory.autowireBean(this);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setSurname(req.getParameter("surname"));
        user.setName(req.getParameter("name"));
        user.setAge(Integer.valueOf(req.getParameter("age")));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setAddress(req.getParameter("address"));
        user.setPassword(req.getParameter("password"));
        userService.addUser(user);
        PrintWriter writer = resp.getWriter();
        writer.println("Your account was successfully created!");
        writer.println("===========================");
        writer.println("List of all users:");
        List<User> userNameList = userService.getAllUsers();
        for (User userFromList : userNameList) {
            writer.println(userFromList);
        }
        writer.println("==============================");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}

