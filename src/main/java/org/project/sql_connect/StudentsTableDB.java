package org.project.sql_connect;

import java.sql.*;

public class StudentsTableDB {

    private Connection connection;
    private Statement statement;
    private String[][] tableData;
    private String[] columns = {"id", "surname", "name", "phone", "classID"};

    public StudentsTableDB() {
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
            ResultSet countSet = statement.executeQuery("SELECT COUNT(*) FROM students;");
            int count = 0;
            if (countSet.next()) {
                count = countSet.getInt(1);
            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students;");
            int i = 0;
            tableData = new String[count][5];
            while (resultSet.next()) {
                tableData[i][0] = String.valueOf(resultSet.getInt("id"));
                tableData[i][1] = resultSet.getString("surname");
                tableData[i][2] = resultSet.getString("name");
                tableData[i][3] = resultSet.getString("phone_number");
                tableData[i][4] = String.valueOf(resultSet.getInt("class_id"));
                i++;
            }
        } catch(SQLException w) {
            w.printStackTrace();
        }
        return tableData;
    }

    public String[] getColumns() {
        return columns;
    }
}
