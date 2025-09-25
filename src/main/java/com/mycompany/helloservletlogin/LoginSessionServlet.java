package com.mycompany.helloservletlogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSessionServlet", urlPatterns = {"/LoginSessionServlet"})
public class LoginSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("trungnh".equals(username) && "123".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("name", username);
            response.sendRedirect("ProfileSessionServlet");
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>Tài khoản hoặc mật khẩu không chính xác</h1>");
                request.getRequestDispatcher("LoginSession.html").include(request, response);
            }
        }
    }
}