package vn.edu.eaut.lab6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username)
                && "123456".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            session.setAttribute(
                    "loginTime",
                    new java.util.Date()
            );

            response.sendRedirect(
                    request.getContextPath() + "/welcome.jsp"
            );

            return;
        }

        if ("user".equals(username)
                && "123456".equals(password)) {

            HttpSession session = request.getSession();

            session.setAttribute("username", username);
            session.setAttribute("role", "user");
            session.setAttribute(
                    "loginTime",
                    new java.util.Date()
            );

            response.sendRedirect(
                    request.getContextPath() + "/welcome.jsp"
            );

            return;
        }

        request.setAttribute(
                "error",
                "Sai tên đăng nhập hoặc mật khẩu!"
        );

        request.getRequestDispatcher("/login.jsp")
                .forward(request, response);
    }
}