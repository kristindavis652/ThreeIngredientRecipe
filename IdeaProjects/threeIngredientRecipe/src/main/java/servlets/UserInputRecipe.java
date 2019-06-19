package servlets;

import com.mysql.cj.xdevapi.Statement;
import database.DBConnector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInputRecipe extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/userRecipe.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        PreparedStatement insertRecipe = null;
        String sql = "INSERT INTO recipes (name) values (?)";
        String name = request.getParameter("recipeTitle");
        try {
            Connection conn = new DBConnector().getConn();
            insertRecipe = conn.prepareStatement(sql);
            insertRecipe.setString(1, name);
            int i = insertRecipe.executeUpdate();
            writer.print("Now You're Cooking!");


        } catch (SQLException e) {
            System.out.println(e.getErrorCode());


        }
    }
}