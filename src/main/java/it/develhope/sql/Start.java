package it.develhope.sql;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        List<String> lastNames = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "admin", "admin");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT last_name, first_name FROM students");

            while (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");

                lastNames.add(lastName);
                System.out.println(firstName);
            }
            System.out.println(lastNames);
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

