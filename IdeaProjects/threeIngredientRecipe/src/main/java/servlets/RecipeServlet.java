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
import java.util.ArrayList;


public class RecipeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RecipeData userRecipe = new RecipeData();


        String recipes = request.getParameter("recipes");
        response.setContentType("text/html");


        PrintWriter writer = response.getWriter();

        ResultSet resultSet = null;
        ResultSet ingredientResultSet;
        java.sql.Statement statement;
        java.sql.Statement ingredientStatement;

        try {
            Connection conn = new DBConnector().getConn();
            statement = conn.createStatement();
            ingredientStatement = conn.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM recipes WHERE name = '" + recipes + "'");
            while (resultSet.next()) {
                userRecipe.setRecipeName(resultSet.getString("name"));
                userRecipe.setInstructions(resultSet.getString("recipe_instructions"));
                writer.println("Here is your recipe: ");
                writer.println(userRecipe.getRecipeName());
                writer.println(" Here are the instructions: ");
                writer.print(userRecipe.getInstructions());

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
            ArrayList ingredients = new ArrayList();
            while (ingredientResultSet.next()) {
                ingredients.add(ingredientResultSet.getString("ingredients"));
                System.out.println(ingredientResultSet.getString("ingredients"));
            }
            userRecipe.setIngredients(ingredients);

            for(int i = 0; i < ingredients.size(); i++) {
                System.out.println(ingredients);
                writer.println(ingredients.get(i) + ",");
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



