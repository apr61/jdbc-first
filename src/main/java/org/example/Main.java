package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String LOAD_DRIVER = "com.mysql.cj.java.Driver";

    public static final String URL = "jdbc:mysql://localhost:3306/studentdb";

    public static final String USERNAME = "root";

    public static final String PASSWORD = "rootroot";

    public static void main(String[] args) {
        // Steps to connect to MYSQL using JDBC
        try{
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create Connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 3. Create statement
            Statement statement = connection.createStatement();
            // 4. Create Query
            String query = "select * from course";
            // 5. Execute query
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String course = rs.getString("course");
                System.out.println("ID: " + id + ", name : " + name + ", course : " + course);
            }
            // 6. Close Connection
            connection.close();

            // JDBC -> Hibernate -> Spring Data JPA
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}