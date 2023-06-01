package by.teachmeskills.task2.listeners;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.db.DBConnectionManager;
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
        ctx.setAttribute("categories", CRUDUtils.getAllCategoriesDB(dbConnectionManager.getConnection()));
        System.out.println("app initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        DBConnectionManager dbConnectionManager = (DBConnectionManager) ctx.getAttribute("DBManager");
        dbConnectionManager.closeConnection();
        System.out.println("connection closed, app shutdown");
    }
}
