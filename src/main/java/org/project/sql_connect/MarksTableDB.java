package org.project.sql_connect;

import javax.swing.*;
import java.sql.*;

public class MarksTableDB {
    private Connection connection;
    private Statement statement;
    private String[][] tableData;
    private String[] columns = {"Date", "Mark", "Comment"};
    private String subject;
    private JComboBox<String> subjectBox;                  // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

    public String[][] getTableData(int studentID) {
        try {
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
                i++;
            }
        } catch(SQLException w) {
            w.printStackTrace();
        }
        return tableData;
    }
    public void refresh() {
        setSubject((String) subjectBox.getSelectedItem());                    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
    public int getSubjectIDByName(String subject) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT id FROM subjects WHERE name = '%s';", subject));
        if(resultSet.next()) {
            return resultSet.getInt("id");
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
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public JComboBox<String> getSubjectBox() {
        return subjectBox;
    }

    public void setSubjectBox(JComboBox<String> subjectBox) {
        this.subjectBox = subjectBox;
    }

    public String[] getColumns() {
        return columns;
    }
}
