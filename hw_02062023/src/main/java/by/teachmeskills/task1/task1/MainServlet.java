package by.teachmeskills.task1.task1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/aboutme")
//@WebServlet(urlPatterns = {"/task"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnectionManager dbConnectionManager = (DBConnectionManager) req.getServletContext().getAttribute("DBManager");
        req.setAttribute("info", CRUDUtils.getInfo(dbConnectionManager.getConnection()).get(0));
        req.setAttribute("imgpath", CRUDUtils.getInfo(dbConnectionManager.getConnection()).get(1));
        req.setAttribute("maininfo", CRUDUtils.getInfo(dbConnectionManager.getConnection()).get(2));
        getServletContext().getRequestDispatcher("/businesscard.jsp").forward(req, resp);
    }
}