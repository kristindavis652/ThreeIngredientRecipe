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
        String ingredients = request.getParameter("ingredients");
        String recipeInstructions = request.getParameter("recipeInstructions");
        response.setContentType("text/html");
        response.setContentType("text/html");
        response.setContentType("text/html");


        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;
        ResultSet ingredientResultSet = null;
        ResultSet recipeInstructionsResultSet = null;
        java.sql.Statement statement = null;
        java.sql.Statement ingredientStatement = null;
        java.sql.Statement recipeInstructionsStatement = null;
        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            ingredientStatement = conn.createStatement();
            recipeInstructionsStatement = conn.createStatement();
            writer.println("Here is your recipe: ");
            resultSet = statement.executeQuery("SELECT * FROM recipes WHERE name = '" + recipes + "'");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                writer.print(resultSet.getString("name"));
            }
            writer.println(" Here are your ingredients: ");
            System.out.println("Before Query +++++++++++++++++++++++++++++");
            ingredientResultSet = ingredientStatement.executeQuery(" SELECT r.name as recipes, i.ingredient_name as ingredients " +
                    "    FROM recipes r " +
                    "    INNER JOIN recipe_ingredients c ON r.id = c.Recipe_ID " +
                    "    INNER JOIN ingredients i on c.Ingredient_ID = i.ingredient_id " +
                    "    WHERE  name = '" + recipes + "'" +
                    "    ORDER BY r.name ");
            System.out.println("After Query +++++++++++++++++++++++++++++");
            while (ingredientResultSet.next()) {
                System.out.println(ingredientResultSet.getString("ingredients"));
                writer.print(ingredientResultSet.getString("ingredients"));
            }
            writer.println(" Here are the instructions: ");
            System.out.println("Before Query +++++++++++++++++++++++++++++");
            recipeInstructionsResultSet = recipeInstructionsStatement.executeQuery(" SELECT * FROM recipes WHERE name = '" + recipes + "'");
            System.out.println("After Query +++++++++++++++++++++++++++++");
            while (recipeInstructionsResultSet.next()) {
                System.out.println(recipeInstructionsResultSet.getString("recipe_instructions"));
                writer.print(recipeInstructionsResultSet.getString("recipe_instructions"));
            }

            } catch(SQLException e){
            e.printStackTrace();
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



