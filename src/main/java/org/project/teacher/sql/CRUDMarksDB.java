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
    private final TeacherMarksTableDB teacherMarksTableDB = new TeacherMarksTableDB();
    private final LoginDB loginDB = new LoginDB();
    private String oldDate;
    private int oldMark;
    private String oldComment;

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

    public boolean addMark(String nameSurname, String date, int mark, String comment, String subject) throws SQLException {
        int studentID = loginDB.getIDByStudentData(new Student(nameSurname.split("\\s")[0], nameSurname.split("\\s")[1], null));
        int subjectID = teacherMarksTableDB.getSubjectID(subject);
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM marks WHERE user_id = %d AND subject_id = %d", studentID, subjectID));
        while (resultSet.next()) {
            if(resultSet.getInt("value") == mark &&
                    resultSet.getString("date").equals(date) &&
                    resultSet.getString("comment").equals(comment)) {
                return false;
            }
        }
        statement.executeUpdate(String.format("INSERT INTO marks (subject_id, user_id, date, value, comment) VALUES (%d, %d, '%s', %d, '%s')",
                subjectID, studentID, date, mark, comment));
        return true;
    }
    public void setOldData(String oldDate, int oldMark, String oldComment) {
        this.oldDate = oldDate;
        this.oldMark = oldMark;
        this.oldComment = oldComment;
    }
    public void updateMark(String nameSurname, String date, int mark, String comment, String subject) throws SQLException {
        int subjectID = teacherMarksTableDB.getSubjectID(subject);
        int userID = loginDB.getIDByStudentData(new Student(nameSurname.split("\\s")[0], nameSurname.split("\\s")[1], null));
        statement.executeUpdate(String.format("UPDATE marks SET date = '%s', value = %d, comment = '%s' " +
                        "WHERE user_id = %d AND date = '%s' AND value = '%s' AND comment = '%s' AND subject_id = %d",
                date, mark, comment, userID, oldDate, oldMark, oldComment, subjectID));
    }
    public void deleteMark(String nameSurname, String date, int mark, String comment, String subject) throws SQLException {
        int subjectID = teacherMarksTableDB.getSubjectID(subject);
        int userID = loginDB.getIDByStudentData(new Student(nameSurname.split("\\s")[0], nameSurname.split("\\s")[1], null));
        statement.executeUpdate(String.format("DELETE FROM marks WHERE subject_id = %d AND user_id = %d AND date = '%s' AND value = %d AND comment = '%s';",
                subjectID, userID, date, mark, comment));
    }
}
