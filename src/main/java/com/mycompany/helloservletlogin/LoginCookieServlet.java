package com.mycompany.helloservletlogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginCookieServlet", urlPatterns = {"/LoginCookieServlet"})
public class LoginCookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("trung".equals(user) && "123".equals(pass)) {
            Cookie usernameCookie = new Cookie("username", user);
            usernameCookie.setMaxAge(30);
            response.addCookie(usernameCookie);
            response.sendRedirect("ProfileCookieServlet");
        } else {
            response.sendRedirect("LoginCookie.html");
        }
    }
}