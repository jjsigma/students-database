package org.project.teacher.sql;

import org.project.student.sql.LoginDB;
import org.project.teacher.Teacher;

import java.sql.*;

public class TeacherLoginDB {
    private final Connection connection;
    private final Statement statement;
    private boolean isLoggedIn;

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
    public Teacher getTeacherByID(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM teachers WHERE id = %d", id));
        Teacher teacher = null;
        if (resultSet.next()) {
            teacher = new Teacher(
                    resultSet.getString("surname"),
                    resultSet.getString("name"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("id_subject"),
                    resultSet.getString("password"));
        }
        return teacher;
    }
    public String getSubjectData(Teacher teacher) throws SQLException {
        int subjectID = teacher.getSubjectID();
        ResultSet resultSet = statement.executeQuery("SELECT name FROM subjects WHERE id = "+subjectID);
        if(resultSet.next()) {
            return resultSet.getString("name");
        }
        return null;
    }
    private String getPasswordByTeacherData(Teacher teacher) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT password FROM teachers WHERE name = '%s' AND surname = '%s';",
                teacher.getName(), teacher.getSurname()));
        if(resultSet.next()) {
            return resultSet.getString("password");
        }
        return null;
    }
    public int getIDByTeacherData(Teacher teacher) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM teachers WHERE name = '%s' AND surname = '%s' AND password = '%s';",
                teacher.getName(), teacher.getSurname(), (teacher.getPassword() == null ? getPasswordByTeacherData(teacher) : teacher.getPassword())));
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
        return -1;
    }
    public int getLoggedInTeacherID(String ip) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT teacher_id FROM logged_in_teachers WHERE ip = '%s'", ip));
        if(!resultSet.next()) return -1;
        else return resultSet.getInt(1);
    }
    public void addIPToTeachersDB(String ip, int userID) throws SQLException {
        if(userID == -1) throw new IllegalArgumentException("ID is illegal to add in IP database!");
        statement.executeUpdate(String.format("INSERT INTO logged_in_teachers (ip, teacher_id) VALUES ('%s', %d)", ip, userID));
    }
    public void deleteTeacherByID(int id) throws SQLException {
        statement.executeUpdate("DELETE FROM logged_in_teachers WHERE teacher_id = "+id);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
