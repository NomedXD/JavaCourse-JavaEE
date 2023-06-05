package by.teachmeskills.task2;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.db.DBConnectionManager;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/shop")
//@WebServlet(urlPatterns = {"/task"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (((User) req.getSession().getAttribute("currentUser")).getLogin().equals("None")) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            DBConnectionManager dbConnectionManager = (DBConnectionManager) req.getServletContext().getAttribute("DBManager");
            req.setAttribute("categories", CRUDUtils.getAllCategories(dbConnectionManager.getConnection()));
            getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ServletContext servletContext = req.getServletContext();
        DBConnectionManager dbConnectionManager = (DBConnectionManager) servletContext.getAttribute("DBManager");
        User user = CRUDUtils.getUser(login, password, dbConnectionManager.getConnection());
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            req.setAttribute("categories", CRUDUtils.getAllCategories(dbConnectionManager.getConnection()));
            getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}