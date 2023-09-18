package org.project.view;

import org.project.Student;
import org.project.sql_connect.LoginDB;
import org.project.util.Util;
import org.project.view.panels.GeneralPanel;
import org.project.view.panels.HomeworkPanel;
import org.project.view.panels.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private LoginDB loginDB = new LoginDB();
    private InfoPanel userInfoPanel = new InfoPanel();;
    private GeneralPanel general = new GeneralPanel();
    private HomeworkPanel homeworkPanel = new HomeworkPanel();
    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);

    public MainFrame() {
        super("Students.net");
        setBounds(500,200, 650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        boolean isLoggedIn;
        try {
            isLoggedIn = checkIfLoggedIn();
            userInfoPanel.setLoggedIn(isLoggedIn);
        } catch (UnknownHostException | SQLException e) {
            throw new RuntimeException(e);
        }
        createTabs();
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
