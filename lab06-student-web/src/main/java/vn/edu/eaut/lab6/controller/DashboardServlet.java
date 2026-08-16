package vn.edu.eaut.lab6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import vn.edu.eaut.lab6.model.Student;
import vn.edu.eaut.lab6.store.StudentStore;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students =
                StudentStore.findAll();

        // Tổng số sinh viên
        int totalStudents =
                students.size();

        // Đếm sinh viên theo lớp
        Map<String, Integer> classCount =
                new HashMap<>();

        for (Student student : students) {

            String className =
                    student.getClassName();

            classCount.put(
                    className,
                    classCount.getOrDefault(
                            className,
                            0
                    ) + 1
            );
        }

        HttpSession session =
                request.getSession(false);

        Object loginTime = null;

        String username = null;

        if (session != null) {

            loginTime =
                    session.getAttribute("loginTime");

            username =
                    (String) session.getAttribute(
                            "username"
                    );
        }

        request.setAttribute(
                "totalStudents",
                totalStudents
        );

        request.setAttribute(
                "classCount",
                classCount
        );

        request.setAttribute(
                "loginTime",
                loginTime
        );

        request.setAttribute(
                "username",
                username
        );

        request.getRequestDispatcher(
                "/dashboard.jsp"
        ).forward(request, response);
    }
}