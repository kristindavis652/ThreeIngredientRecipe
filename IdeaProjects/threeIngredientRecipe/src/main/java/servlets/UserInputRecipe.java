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

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserInputRecipe extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/userRecipe.jsp");
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        PreparedStatement insertRecipe = null;
        String sqlName = "INSERT INTO recipes (name, recipe_instructions) VALUES (?,?)";
        //Statement.RETURN_GENERATED_KEYS);
        String name = request.getParameter("recipeTitle");
        String instructions = request.getParameter("instructions");


        try {
            Connection conn = new DBConnector().getConn();
            insertRecipe = conn.prepareStatement(sqlName);
            insertRecipe.setString(1, name);
            insertRecipe.setString(2, instructions);
            int i = insertRecipe.executeUpdate();
            writer.print("Now You're Cooking!");


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getErrorCode());


        }
    }
}