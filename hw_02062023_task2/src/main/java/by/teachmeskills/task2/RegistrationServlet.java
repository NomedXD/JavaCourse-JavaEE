package by.teachmeskills.task2;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.db.ConnectionPool;
import by.teachmeskills.task2.validator.ValidatorUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (((User) req.getSession().getAttribute("currentUser")).getMail().equals("None")) {
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
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
        String email = req.getParameter("mail");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        if (ValidatorUtils.validateRegistration(email, name, surname, password, repeatPassword)) {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();
            User user = CRUDUtils.registerUser(email, name, surname, password, "0$", connection);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user);
                req.setAttribute("categories", CRUDUtils.getAllCategories(connection));
                connectionPool.closeConnection(connection);
                getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
            } else {
                connectionPool.closeConnection(connection);
                getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
    }
}
