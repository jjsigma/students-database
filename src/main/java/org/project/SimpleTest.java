package org.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SimpleTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_database_schema", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT grade, letter, students.id, name, surname, phone_number, class_id " +
                "FROM classes JOIN students ON classes.id = students.class_id");

        while (resultSet.next()) {
            int grade = resultSet.getInt("grade");
            String letter = resultSet.getString("letter");
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String phoneNumber = resultSet.getString("phone_number");
            int classId = resultSet.getInt("class_id");
            String dot = "| ";
            if(String.valueOf(resultSet.getRow()).length() == 1) dot =" "+dot; // Спорная строчка!!! (не будет работать с id >=100)
            System.out.println(resultSet.getRow() + dot + grade + "\t" + letter + "\t" + id + "\t" + name + "\t" + surname + "\t" + phoneNumber + "\t" + classId);
        }
        connection.close();
    }
}
