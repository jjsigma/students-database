package org.project.sql_connect;

import org.project.Student;

import java.sql.*;

public class LoginDB {
    private Connection connection;
    private Statement statement;
    private boolean isLoggedIn = false;
    private Student loggedInData;


    public LoginDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String url = "jdbc:mysql://localhost:3306/student_database_schema",
                         user = "root",
                         password = "root";

    public void add(Student student) throws SQLException {
        statement.executeUpdate(String.format("INSERT INTO students (name, surname, phone_number, class_id, password, gender) " +
                        "VALUES ('%s', '%s', '%s', %d, '%s', '%s')",
                student.getName(),
                student.getSurname(),
                student.getPhoneNumber(),
                student.getClassID(),
                student.getPassword(),
                student.getGender()));
    }
    public void close() throws SQLException {
        connection.close();
    }
    public boolean checkIfExist(String name, String surname, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM students WHERE surname = '%s' AND name = '%s' AND password = '%s'",
                surname, name, password));
        return resultSet.next();
    }
    public int getClassID(String grade, String letter) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM classes WHERE grade = %d AND letter = '%s'", Integer.parseInt(grade), letter));
        int id;
        if(!resultSet.next()) id = -1;
        else id = resultSet.getInt(1);
        return id;
    }
    public int getLoggedInUserID(String ip) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT student_id FROM logged_in_users WHERE ip = '%s'", ip));
        if(!resultSet.next()) return -1;
        else return resultSet.getInt(1);
    }
    public int getIDByStudentData(Student student) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM students WHERE name = '%s' AND surname = '%s' AND password = '%s';",
                student.getName(), student.getSurname(), student.getPassword()));
        if(resultSet.next()) {
            return resultSet.getInt("id");
        }
        return -1;
    }
    public Student getStudentByID(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM students WHERE id = %d", id));
        Student student = null;
        if (resultSet.next()) {
            student = new Student(
                    resultSet.getString("surname"),
                    resultSet.getString("name"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("class_id"),
                    resultSet.getString("gender"),
                    resultSet.getString("password"));
        }
        return student;
    }
    public String getClassData(Student student) throws SQLException {
        int classID = student.getClassID();
        ResultSet resultSet = statement.executeQuery("SELECT grade, letter FROM classes WHERE id = "+classID);
        String data = null;
        if(resultSet.next()) {
            data = resultSet.getString(1)+resultSet.getString(2);
        }
        return data;
    }
    public void deleteUserByID(int id) throws SQLException {
        statement.executeUpdate("DELETE FROM logged_in_users WHERE student_id = "+id);
    }
    public void addIPToUsersDB(String ip, int userID) throws SQLException {
        System.out.println(userID);
        if(userID == -1) throw new IllegalArgumentException("Id is illegal to add in Ip database!");
        statement.executeUpdate(String.format("INSERT INTO logged_in_users (ip, student_id) VALUES ('%s', %d)", ip, userID));
    }
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public void setLoggedInData(Student loggedInData) {
        this.loggedInData = loggedInData;
    }
}
