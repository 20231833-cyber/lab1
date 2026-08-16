package vn.edu.eaut.lab6.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter("/*")
public class AccessLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        String uri =
                req.getRequestURI();

        String method =
                req.getMethod();

        HttpSession session =
                req.getSession(false);

        String user = "anonymous";

        if (session != null
                && session.getAttribute("username") != null) {

            user =
                    (String) session.getAttribute(
                            "username"
                    );
        }

        String time =
                new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss"
                ).format(new Date());

        System.out.println(
                "[ACCESS LOG]"
                        + " time=" + time
                        + " | method=" + method
                        + " | uri=" + uri
                        + " | user=" + user
        );

        chain.doFilter(request, response);
    }
}