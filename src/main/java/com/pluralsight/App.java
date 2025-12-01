package com.pluralsight;

import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = args[0];
        String password = args[1];

        //1. open connection to database
        Connection connection = DriverManager.getConnection(url, username, password);

        //create statement
        //statement is tied to open connection
        Statement statement = connection.createStatement();

        //define your query
        String query = "SELECT productName FROM products ";

        //2. Execute your query
        ResultSet results = statement.executeQuery(query);

        System.out.println(results);

        // process the results
        while (results.next()) {
            String productName = results.getString("productName");
            System.out.println(productName);
        }
        // 3. Close the connection
        connection.close();

        //if productName instances don't match, it will not work
        //productName from string query, in the while loop string name, in getString method or sout parameters

    }
}

