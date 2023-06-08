package by.teachmeskills.task2;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.db.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/shop")
//@WebServlet(urlPatterns = {"/task"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (((User) req.getSession().getAttribute("currentUser")).getMail().equals("None")) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            req.setAttribute("categories", CRUDUtils.getAllCategories(connection));
            connectionPool.closeConnection(connection);
            getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        User user = CRUDUtils.getUser(mail, password, connection);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            req.setAttribute("categories", CRUDUtils.getAllCategories(connection));
            connectionPool.closeConnection(connection);
            getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
        } else {
            connectionPool.closeConnection(connection);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}