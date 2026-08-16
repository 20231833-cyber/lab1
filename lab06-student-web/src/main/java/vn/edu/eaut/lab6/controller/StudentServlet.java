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
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    // Kiểm tra Admin
    private boolean isAdmin(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }

        String role = (String) session.getAttribute("role");

        return "admin".equals(role);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // =========================
        // BÀI 7: XÓA
        // =========================

        if ("delete".equals(action)) {

            if (!isAdmin(request)) {

                response.sendRedirect(
                        request.getContextPath() + "/403.jsp"
                );

                return;
            }

            String id = request.getParameter("id");

            StudentStore.delete(id);

            response.sendRedirect(
                    request.getContextPath() + "/students"
            );

            return;
        }

        // =========================
        // BÀI 8: FORM SỬA
        // =========================

        if ("edit".equals(action)) {

            if (!isAdmin(request)) {

                response.sendRedirect(
                        request.getContextPath() + "/403.jsp"
                );

                return;
            }

            String id = request.getParameter("id");

            Student student = StudentStore.findById(id);

            request.setAttribute("student", student);

            request.getRequestDispatcher(
                    "/student-form.jsp"
            ).forward(request, response);

            return;
        }

        // =========================
        // BÀI 6: TÌM KIẾM
        // =========================

        String keyword = request.getParameter("keyword");

        List<Student> students;

        if (keyword == null || keyword.trim().isEmpty()) {

            students = StudentStore.findAll();

        } else {

            students = StudentStore.searchByName(keyword);
        }

        request.setAttribute("students", students);
        request.setAttribute("keyword", keyword);

        request.getRequestDispatcher(
                "/student-list.jsp"
        ).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Chỉ Admin được thêm/sửa
        if (!isAdmin(request)) {

            response.sendRedirect(
                    request.getContextPath() + "/403.jsp"
            );

            return;
        }

        String action = request.getParameter("action");

        // =========================
        // BÀI 8: CẬP NHẬT
        // =========================

        if ("update".equals(action)) {

            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String className = request.getParameter("className");
            String email = request.getParameter("email");

            Student student = new Student(
                    id,
                    name,
                    className,
                    email
            );

            StudentStore.update(student);

            response.sendRedirect(
                    request.getContextPath() + "/students"
            );

            return;
        }

        // =========================
        // BÀI 2 + BÀI 3: THÊM
        // =========================

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String className = request.getParameter("className");
        String email = request.getParameter("email");

        Student student = new Student(
                id,
                name,
                className,
                email
        );

        StudentStore.add(student);

        response.sendRedirect(
                request.getContextPath() + "/students"
        );
    }
}