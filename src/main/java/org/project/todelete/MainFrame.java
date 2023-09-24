package org.project.todelete;

import org.project.student.Student;
import org.project.student.sql.LoginDB;
import org.project.todelete.panels.HomeworkPanel;
import org.project.todelete.panels.InfoPanel;
import org.project.util.Util;
import org.project.todelete.panels.GeneralPanel;

import javax.swing.*;
import java.awt.*;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private final LoginDB loginDB = new LoginDB();
    private final InfoPanel userInfoPanel = new InfoPanel();
    private final GeneralPanel general = new GeneralPanel();
    private final HomeworkPanel homeworkPanel = new HomeworkPanel();
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

    public MainFrame() {
        super("Students.net");
        setBounds(500,200, 650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        boolean isLoggedIn;
        try {
            isLoggedIn = checkIfLoggedIn();
            userInfoPanel.setLoggedIn(isLoggedIn);
        } catch (UnknownHostException | SQLException e) {
            throw new RuntimeException(e);
        }
        createTabs();
        setVisible(true);
        if(isLoggedIn) {
            JOptionPane.showMessageDialog(null, "Logged in account!\nPress 'refresh' button.");
        }
    }
    private void createTabs() {
        tabbedPane.setFont(new Font("Dialog", Font.BOLD, 20));

        //general
        tabbedPane.addTab("General", general);
        general.addComponents();

        //homework
        tabbedPane.addTab("Homework", homeworkPanel);
        homeworkPanel.addComponents();

        //user info
        tabbedPane.addTab("Info", userInfoPanel);
        userInfoPanel.addComponents();

        this.getContentPane().add(tabbedPane);
    }
    private boolean checkIfLoggedIn() throws UnknownHostException, SQLException {
        String ip = Util.getIPAddress();
        int userID = loginDB.getLoggedInUserID(ip);
        if(userID != -1) {
            Student user = loginDB.getStudentByID(userID);
            user.setClassData(loginDB.getClassData(user));
            userInfoPanel.setLoggedInData(user);
            return true;
        }
        return false;
    }
}
