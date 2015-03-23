package com.mycompany.study.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Path Listener
 * Created by hjl on 2015-3-23.
 */
@WebListener
public class PathListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        String path = application.getContextPath();
        application.setAttribute("path", path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
