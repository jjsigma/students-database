package org.project.sql_connect;

import org.project.student.Student;
import org.project.teacher.Teacher;

import java.sql.*;

public class TeacherLoginDB {
    private final Connection connection;
    private final Statement statement;
    private boolean isLoggedIn = false;

    private static final String url = "jdbc:mysql://localhost:3306/student_database_schema",
            user = "root",
            password = "root";

    public TeacherLoginDB() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkIfExist(String name, String surname, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM teachers WHERE surname = '%s' AND name = '%s' AND password = '%s'",
                surname, name, password));
        return resultSet.next();
    }
    public int getIDByTeacherData(Teacher teacher) throws SQLException {
//        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM students WHERE name = '%s' AND surname = '%s' AND password = '%s';",
//                teacher.getName(), teacher.getSurname(), (teacher.getPassword() == null ? getPasswordByStudentData(teacher) : teacher.getPassword())));
//        if(resultSet.next()) {
//            return resultSet.getInt("id");
//        }
        return -1;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}
