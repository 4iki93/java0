package ua.com.owu.servlet.servlet;

import ua.com.owu.servlet.connect.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



        String name = request.getParameter("name");
        DbConnection dbConnection =new DbConnection();
        dbConnection.save(name);

        System.out.println(request.getParameter("name"));
        request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/userPage.jsp").forward(request,response);


    }
}
