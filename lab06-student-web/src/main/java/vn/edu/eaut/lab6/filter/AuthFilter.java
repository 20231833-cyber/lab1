package vn.edu.eaut.lab6.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {
        "/students",
        "/student-form.jsp",
        "/welcome.jsp",
        "/dashboard"
})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

        System.out.println("AuthFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse resp =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        boolean loggedIn =
                session != null
                        && session.getAttribute("username") != null;

        // Chưa đăng nhập
        if (!loggedIn) {

            resp.sendRedirect(
                    req.getContextPath() + "/login.jsp"
            );

            return;
        }

        String role =
                (String) session.getAttribute("role");

        String uri = req.getRequestURI();

        String path =
                uri.substring(
                        req.getContextPath().length()
                );

        // =========================
        // BÀI 9
        // USER KHÔNG ĐƯỢC THÊM/SỬA/XÓA
        // =========================

        if ("user".equals(role)) {

            // student-form.jsp chỉ Admin
            if (path.equals("/student-form.jsp")) {

                resp.sendRedirect(
                        req.getContextPath() + "/403.jsp"
                );

                return;
            }

            // /students?action=edit
            String action =
                    req.getParameter("action");

            if ("edit".equals(action)
                    || "delete".equals(action)) {

                resp.sendRedirect(
                        req.getContextPath() + "/403.jsp"
                );

                return;
            }

            // POST /students = thêm hoặc sửa
            if ("/students".equals(path)
                    && "POST".equalsIgnoreCase(
                    req.getMethod())) {

                resp.sendRedirect(
                        req.getContextPath() + "/403.jsp"
                );

                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        System.out.println("AuthFilter destroyed");
    }
}