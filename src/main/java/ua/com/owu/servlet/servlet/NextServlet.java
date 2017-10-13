package ua.com.owu.servlet.servlet;

import ua.com.owu.servlet.connect.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NextServlet")
public class NextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DbConnection dbConnection = new DbConnection();
        List<String> users = dbConnection.selectAll();
        request.setAttribute("userList",users);

        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request,response);

    }
}
