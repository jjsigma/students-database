package org.project.teacher.sql;

import org.project.student.Student;
import org.project.student.sql.LoginDB;
import org.project.teacher.Teacher;

import java.sql.*;

public class TeacherMarksTableDB {
    private Connection connection;
    private Statement statement;
    private String[][] tableData;
    private final String[] columns = {"Date", "Mark", "Comment"};
    private final String[][] nullData = new String[0][3];
    private String subject;

    public TeacherMarksTableDB() {
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

    public String[] getClassLettersByGrade(int grade) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM classes;");
        int all = 0;
        if(resultSet.next()) {
            all = resultSet.getInt(1);
        }
        String[] subjects = new String[all];
        ResultSet resultSet1 = statement.executeQuery("SELECT letter FROM classes WHERE grade = "+grade);
        int i = 0;
        while (resultSet1.next()) {
            subjects[i] = resultSet1.getString("letter");
            System.out.println(subjects[i]);
            i++;
        }
        System.out.println("----");
        return subjects;
    }
    public String[] getStudentsByClassData(String data) throws SQLException{
        char grade = data.charAt(0);
        char letter = data.charAt(1);
        int classID = new LoginDB().getClassID(String.valueOf(grade), String.valueOf(letter));
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM students WHERE class_id = " + classID);
        int all = 0;
        if(resultSet.next()) {
            all = resultSet.getInt(1);
        }
        System.out.println(all);
        String[] students = new String[all];
        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM students WHERE class_id = " + classID);
        int i =0;
        while(resultSet1.next()) {
            students[i] = resultSet1.getString("name")+" "+resultSet1.getString("surname");
            i++;
        }
        return students;
    }
    public int getSubjectID(String name) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM subjects WHERE name = '%s'", name));
        if(resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }
    public String[][] getTableData(String name, String surname, String classData) {
        try {
            int classID = new LoginDB().getClassID(String.valueOf(classData.charAt(0)), String.valueOf(classData.charAt(1)));
            ResultSet countSet = statement.executeQuery(String.format(
                    "SELECT COUNT(*) FROM marks WHERE user_id = (SELECT id FROM students WHERE name = '%s' AND surname = '%s' AND class_id = %d) AND subject_id = %d;",
                    name, surname, classID, getSubjectID(subject)));
            int count = 0;
            if (countSet.next()) {
                count = countSet.getInt(1);
            }
            tableData = new String[count][3];

            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM marks WHERE user_id = (SELECT id FROM students WHERE name = '%s' AND surname = '%s' AND class_id = %d) AND subject_id = %d ORDER BY date;",
                    name, surname, classID, getSubjectID(subject)));
            int i = 0;
            while (resultSet.next()) {
                tableData[i][0] = String.valueOf(resultSet.getDate("date"));
                tableData[i][1] = String.valueOf(resultSet.getInt("value"));
                tableData[i][2] = resultSet.getString("comment");
                System.out.println(tableData[i][0] +" "+tableData[i][1] +" "+tableData[i][2]);
                i++;
            }
        } catch(SQLException w) {
            w.printStackTrace();
        }
        return tableData;
    }

    public String[][] getNullData() {
        return nullData;
    }

    public String getSubject() {
        return subject;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
