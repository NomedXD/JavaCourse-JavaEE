package by.teachmeskills.task1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
//@WebServlet(urlPatterns = {"/task"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!((boolean) req.getSession().getAttribute("loggedIn"))) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        ServletContext servletContext = getServletContext();
        DBConnectionManager dbConnectionManager = (DBConnectionManager) servletContext.getAttribute("DBManager");
        User user = dbConnectionManager.getUserDB(login, password);
        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("loggedIn", true);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            PrintWriter writer = resp.getWriter();
            writer.write("Ваши данные неверны!");
        }
    }
}