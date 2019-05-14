package servlets;

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

public class IngredientServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            RequestDispatcher dispatcher = request.getRequestDispatcher("/recipe.jsp");
            dispatcher.forward(request, response);

        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String ingredients = request.getParameter("ingredients");
            response.setContentType("text/html");


            PrintWriter writer = response.getWriter();

            ResultSet resultSet = null;
            java.sql.Statement statement = null;
            try {
                Connection conn = new DBConnector().getConn();
                statement = conn.createStatement();
                writer.println("Here are your ingredients: ");
                System.out.println("test");
                resultSet = statement.executeQuery("SELECT * FROM ingredients WHERE name = '" + ingredients + "'");
                System.out.println("test");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                    writer.print(resultSet.getString("name"));
                }

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

