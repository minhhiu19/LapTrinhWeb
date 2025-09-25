package com.mycompany.helloservletlogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProfileCookieServlet", urlPatterns = {"/ProfileCookieServlet"})
public class ProfileCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    username = c.getValue();
                    break;
                }
            }
        }

        if (username != null) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html><html><head><title>Trang cá nhân</title></head><body>");
                out.println("<h1>Xin chào, " + username + "!</h1>");
                out.println("<p>Bạn đã đăng nhập thành công bằng Cookie.</p>");
                out.println("<p>Cookie sẽ hết hạn sau 30 giây.</p>");
                out.println("<a href='LogoutCookieServlet'>Đăng xuất</a>");
                out.println("</body></html>");
            }
        } else {
            response.sendRedirect("LoginCookie.html");
        }
    }
}