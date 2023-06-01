package by.teachmeskills.task1.listeners;

import by.teachmeskills.task1.task1.DBConnectionManager;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String dburl = ctx.getInitParameter("dburl");
        String dbpass = ctx.getInitParameter("dbpass");
        String dbuser = ctx.getInitParameter("dbuser");
        DBConnectionManager dbConnectionManager = new DBConnectionManager(dburl, dbuser, dbpass);
        ctx.setAttribute("DBManager", dbConnectionManager);
        System.out.println("site initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        DBConnectionManager dbConnectionManager = (DBConnectionManager) ctx.getAttribute("DBManager");
        dbConnectionManager.closeConnection();
        System.out.println("connection closed, site shutdown");
    }
}
