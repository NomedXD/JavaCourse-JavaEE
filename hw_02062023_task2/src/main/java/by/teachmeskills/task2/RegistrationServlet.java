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
        if (((User) req.getSession().getAttribute("currentUser")).getMail() == null) {
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            req.setAttribute("categories", CRUDUtils.getAllCategories());
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
            User user = CRUDUtils.saveUser(email, name, surname, password, "0$");
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user);
                req.setAttribute("categories", CRUDUtils.getAllCategories());
                getServletContext().getRequestDispatcher("/shop.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
    }
}
