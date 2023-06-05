package by.teachmeskills.task1.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/aboutme")
//@WebServlet(urlPatterns = {"/task"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnectionManager dbConnectionManager = (DBConnectionManager) req.getServletContext().getAttribute("DBManager");
        Map<String, String> userData = CRUDUtils.getInfo(dbConnectionManager.getConnection());
        req.setAttribute("userData", userData);
        getServletContext().getRequestDispatcher("/businesscard.jsp").forward(req, resp);
    }
}