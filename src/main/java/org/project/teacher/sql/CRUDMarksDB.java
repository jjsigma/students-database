package org.project.teacher.sql;

import org.project.student.Student;
import org.project.student.sql.LoginDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class CRUDMarksDB {
    private Connection connection;
    private Statement statement;

    public CRUDMarksDB() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static final String url = "jdbc:mysql://localhost:3306/student_database_schema",
            user = "root",
            password = "root";

    public void addMark(String nameSurname, String date, int mark, String comment, String subject) throws SQLException {
        int studentID = new LoginDB().getIDByStudentData(new Student(nameSurname.split("\\s")[0], nameSurname.split("\\s")[1], null));
        int subjectID = new TeacherMarksTableDB().getSubjectID(subject);
        System.out.println(subjectID);
        statement.executeUpdate(String.format("INSERT INTO marks (subject_id, user_id, date, value, comment) VALUES (%d, %d, '%s', %d, '%s')",
                subjectID, studentID, date, mark, comment));
    }
}
