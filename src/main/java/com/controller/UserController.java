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
@WebServlet(urlPatterns = "/users", asyncSupported = true)
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
        String login = req.getParameter("login");
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password2");

        if (login!= null && surname!= null && name!= null && age!= null &&
                phone!= null && email!= null && address!= null && password!= null) {
            User user = new User(login, surname, name, age, phone, email, address, password);
            userService.addUser(user);
            userWasCreateSuccess(resp);
        } else {
            errorMsg(resp, "Something went wrong! Please try again!");
        }
    }

    private void userWasCreateSuccess(HttpServletResponse resp) throws IOException {
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

    private void errorMsg(HttpServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
            writer.print("<!DOCTYPE HTML>");
            writer.print("<html><body><center>");
            writer.print("<p>" + message + "</p>");
            writer.print("<p><a href=\"index.jsp\">OK</a></p>");
            writer.print("<center><body><html>");
            writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}

