package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BGClassTeacher on 08.12.2016.
 */
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
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String flag = null;
         String username = (String)req.getParameter("name");
         String password = (String)req.getParameter("password");
         flag = userService.validateUserCredentials(username,password);
         if (flag.equals("OK")) {
             resp.getWriter().println("<!DOCTYPE HTML>");
             resp.getWriter().println("<html><body><center><p>" + "Access granted!" + "</p></center></body></html>");
         } else if (flag.equals("login")) {
             resp.getWriter().println("<!DOCTYPE HTML>");
             resp.getWriter().println("<html><body><center><p>" + "Access denied! Wrong login!" + "</p></center></body></html>");
         } else {
             resp.getWriter().println("<!DOCTYPE HTML>");
             resp.getWriter().println("<html><body><center><p>" + "Access denied! Wrong password!" + "</p></center></body></html>");
         }
    }
}

