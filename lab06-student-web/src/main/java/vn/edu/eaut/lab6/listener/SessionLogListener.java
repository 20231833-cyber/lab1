package vn.edu.eaut.lab6.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionLogListener
        implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {

        System.out.println(
                "Session created: "
                        + event.getSession().getId()
        );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        System.out.println(
                "Session destroyed: "
                        + event.getSession().getId()
        );
    }
}