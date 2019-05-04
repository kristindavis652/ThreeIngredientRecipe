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
import java.sql.ResultSet;
import java.sql.SQLException;


public class RecipeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipes = request.getParameter("recipes");
        response.setContentType("text/html");


        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;
        java.sql.Statement statement = null;
        java.sql.Statement ingredientStatement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            writer.println("Here is your recipe: ");
            resultSet = statement.executeQuery("SELECT * FROM Recipes WHERE name = '" + recipes + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name"));
            }

            ingredientStatement = conn.createStatement();
            writer.println("Here are your ingredients: " + ",");
            resultSet = ingredientStatement.executeQuery("SELECT t1.col, t3.col FROM table1 join table2 ON table1.primarykey = table2.foreignkey join table3 ON table2.primarykey = table3.foreignkey");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name")); }

            } catch(SQLException e){
                System.out.println(e.getErrorCode());
            } finally{
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException sqlEx) {
                        System.out.println(sqlEx);
                    }
                }


            }
        }

    }



