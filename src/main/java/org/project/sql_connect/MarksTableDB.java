package org.project.sql_connect;

import org.project.Student;

import java.sql.*;

public class MarksTableDB {
    private Connection connection;
    private Statement statement;
    private Student student;  // Data = surname, name, phone number, class id
    private String[][] tableData;
    private String[] columns = {"Date", "Mark", "Comment"};
    private String[][] nullData = new String[0][3];
    private String subject;


    public MarksTableDB() {
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

    public String[][] getTableData() {
        try {
            int studentID = refreshData();
            ResultSet countSet = statement.executeQuery(String.format("SELECT COUNT(*) FROM marks WHERE user_id = %d AND subject_id = %d;",
                    studentID, getSubjectIDByName(subject)));
            int count = 0;
            if (countSet.next()) {
                count = countSet.getInt(1);
            }
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM marks WHERE user_id = %d AND subject_id = %d;",
                    studentID, getSubjectIDByName(subject)));
            int i = 0;
            tableData = new String[count][3];
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

    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private int refreshData() throws SQLException {
        int studentID = new LoginDB().getIDByStudentData(student);
        return studentID;
    }
    public int getSubjectIDByName(String subject) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM subjects WHERE name = '%s';", subject));
        if(resultSet.next()) {
            int id = resultSet.getInt("id");
            return id;
        }
        return -1;
    }
    public String getSubjectByID(int id) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT name FROM subjects WHERE id ="+id);
        if(resultSet.next()) {
            return resultSet.getString("name");
        }
        return null;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getColumns() {
        return columns;
    }
}
