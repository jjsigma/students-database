package org.project.view;

import org.project.sql_connect.StudentsTableDB;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class StudentsTableGUI extends JFrame {
    private JTable table;
    private StudentsTableDB studentsTableDB;

    public StudentsTableGUI() {
        super("All students");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void run() {
        studentsTableDB = new StudentsTableDB();
        setVisible(true);
        try {
            addGUIComponents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void addGUIComponents() throws SQLException {
        SpringLayout springLayout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(springLayout);

        //table
        table = new JTable(studentsTableDB.getTableData(), studentsTableDB.getColumns()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setFont(new Font("Dialog", Font.PLAIN, 15));
        table.setSize(600, 500);

        springLayout.putConstraint(SpringLayout.WEST, table, 0, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, table, 0, SpringLayout.NORTH, panel);

        panel.add(table);


        //scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 30, SpringLayout.NORTH, panel);
        panel.add(scrollPane);

        this.getContentPane().add(panel);
    }
}
