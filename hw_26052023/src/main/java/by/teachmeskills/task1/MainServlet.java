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
        if (((User)req.getSession().getAttribute("currentUser")).getLogin().equals("None")) {
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
        User user = CRUDUtils.getUserDB(login, password, dbConnectionManager.getConnection());
        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("currentUser", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            /*
            Почему я выводил просто текст, а не возвращал страницу логина: по заданию нужно использовать фильтр.
            Причем его можно использовать только в doPost. То есть, если убрать кодировку с самой страницы,
            то в методе doGet при получении страницы будут стремные символы.
            Если делать перенаправление(возврат) странички логина
            через requestDispatcher здесь, то фильтр не применится, ведь setContentType в фильтре делается для
            response, а dispatcher работает через request *задумчивое лицо*
             */
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}