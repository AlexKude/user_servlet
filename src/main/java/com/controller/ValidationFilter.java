package com.controller;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by Main Server on 14.12.2016.
 */
@WebFilter(urlPatterns = "/users/*")
public class ValidationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        String login = req.getParameter("login");
        if (!StringUtils.isEmpty(login)) {
            if (!login.matches("\\w{4,10}")) {
                errorMsg(resp, "Wrong Login format! Please write only figures and letters!");
                return;
            }
            String surname = req.getParameter("surname");
            if (!surname.matches("[A-Z][a-z]+")) {
                errorMsg(resp, "Wrong Family Name format! Please write letters only. For example: Johnson");
                return;
            }
            String name = req.getParameter("name");
            if (!name.matches("[A-Z][a-z]+")) {
                errorMsg(resp, "Wrong First Name format! Please write letters only. For example: John");
                return;
            }
            String age = req.getParameter("age");
            if (!age.matches("\\d+")) {
                errorMsg(resp, "Wrong Age format! Please write figures only");
                return;
            }
            String phone = req.getParameter("phone");
            if (!phone.matches("[(]\\d{3}[)]\\d{3}[-]\\d{2}[-]\\d{2}")) {
                errorMsg(resp, "Wrong Phone Number format! Please write as per sample:(305)748-37-53");
                return;
            }
            String email = req.getParameter("email");
            if (!email.matches("\\w+[@]\\w+[.]\\w+")) {
                errorMsg(resp, "Wrong e-mail format! Please write as per sample:test@hotmail.com");
                return;
            }
            String password1 = req.getParameter("password1");
            if (!password1.matches("\\w{4,10}")) {
                errorMsg(resp, "Wrong Password format! Please write only figures and letters!");
                return;
            }

            String password2 = req.getParameter("password2");
            if (!password2.equals(password1)) {
                errorMsg(resp, "You password and retype password do not match! Please try again!");
                return;
            }
            String pin = req.getParameter("pin");
            if (!StringUtils.isEmpty(pin)) {
                InputStream resourceAsStream =
                        ValidationFilter.class.getClassLoader().
                                getResourceAsStream("pinCode.properties");
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                String pin_from_property = properties.getProperty("pin");
                resourceAsStream.close();
                if (!pin.equals(pin_from_property)) {
                    errorMsg(resp, "You Pin Code is not valid. Please contact Provider for valid Pin Code");
                    return;
                }
            } else {
                errorMsg(resp, "Please Enter Your Provider Pin Code");
                return;
            }
            chain.doFilter(req, resp);
        } else {
            errorMsg(resp, "To create user go on WEB page ");
        }

    }

    private void errorMsg(ServletResponse resp, String message) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<!DOCTYPE HTML>");
        writer.print("<html><body><center>");
        writer.print("<p>" + message + "</p>");
        writer.print("<p><a href=\"index.jsp\">OK</a></p>");
        writer.print("<center><body><html>");
        writer.flush();
    }


    public void destroy() {

    }
}
