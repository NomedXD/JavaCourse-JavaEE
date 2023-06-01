package by.teachmeskills.task2;

import by.teachmeskills.task2.db.CRUDUtils;
import by.teachmeskills.task2.db.DBConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnectionManager dbConnectionManager = (DBConnectionManager) getServletContext().getAttribute("DBManager");
        req.setAttribute("products", CRUDUtils.getProductsByCategoryDB(Integer.parseInt(req.getParameter("categoryid")),
                dbConnectionManager.getConnection()));
        getServletContext().getRequestDispatcher("/category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
