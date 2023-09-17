package org.project.sql_connect;

import org.project.Student;
import org.project.util.Util;

import java.sql.*;

public class LoginDB {
    private Connection connection;
    public LoginDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String sql = "INSERT INTO students(surname, name, phone_number, class_id) " +
            "VALUES ('%s', '%s', '%s', %d)";
    private static final String url = "jdbc:mysql://localhost:3306/student_database_schema",
                         user = "root",
                         password = "root";

    public void add(Student student) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(String.format(sql, student.getSurname(),student.getName(), student.getPhoneNumber(), student.getClassID()));
        connection.close();
    }
    public boolean checkIfExist(Student student) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM students WHERE surname = '%s' AND name = '%s' AND phone_number = '%s'",
                student.getSurname(), student.getName(), student.getPhoneNumber()));
        return resultSet.next();
    }
    public int getClassID(String grade, String letter) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM classes WHERE grade = %d AND letter = '%s'", Integer.parseInt(grade), letter));
        int id;
        if(!resultSet.next()) id = -1;
        else id = resultSet.getInt(1);
        return id;
    }

    public static void main(String[] args) {
//        try {
//            new LoginDB().add(new Student("Барабуев", "Руслан", Util.generatePhoneNumber(), 6));
//            System.out.println(new LoginDB().getClassID(2, "Г"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
