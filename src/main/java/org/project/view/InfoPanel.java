package org.project.view;

import org.project.Student;
import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private Student loggedInData;
    private boolean isLoggedIn = false;
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    public void addInfoComponents() {
        setLayout(springLayout);

        //logo
        JLabel logoLabel = new JLabel("Student Info");
        logoLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 230, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 15, SpringLayout.NORTH, this);

        add(logoLabel);

        //login button
        JButton loginButton = new JButton("login");
        loginButton.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, loginButton, 540, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 15, SpringLayout.NORTH, this);

        add(loginButton);

        //name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        JLabel nameResult = new JLabel("*login to see*");
        nameResult.setFont(new Font("Dialog", Font.PLAIN, 20));

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 70, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, nameResult, 140, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, nameResult, 70, SpringLayout.NORTH, this);

        add(nameLabel);
        add(nameResult);

        //surname
        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        JLabel surnameResult = new JLabel("*login to see*");
        surnameResult.setFont(new Font("Dialog", Font.PLAIN, 20));

        springLayout.putConstraint(SpringLayout.WEST, surnameLabel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, surnameLabel, 120, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, surnameResult, 140, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, surnameResult, 120, SpringLayout.NORTH, this);

        add(surnameLabel);
        add(surnameResult);

        //phone number
        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        JLabel phoneResult = new JLabel("*login to see*");
        phoneResult.setFont(new Font("Dialog", Font.PLAIN, 20));

        springLayout.putConstraint(SpringLayout.WEST, phoneLabel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, phoneLabel, 170, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, phoneResult, 140, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, phoneResult, 170, SpringLayout.NORTH, this);

        add(phoneLabel);
        add(phoneResult);

        //class
        JLabel classLabel = new JLabel("Class: ");
        classLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        JLabel classResult = new JLabel("*login to see*");
        classResult.setFont(new Font("Dialog", Font.PLAIN, 20));

        springLayout.putConstraint(SpringLayout.WEST, classLabel, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, classLabel, 220, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, classResult, 140, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, classResult, 220, SpringLayout.NORTH, this);

        add(classLabel);
        add(classResult);

        //refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setFont(new Font("Dialog", Font.PLAIN, 20));

        springLayout.putConstraint(SpringLayout.WEST, refreshButton, 50, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, refreshButton, 280, SpringLayout.NORTH, this);

        //action listeners
        loginButton.addActionListener(e -> {
            if(loginButton.getText().equals("login") && isLoggedIn) {
                // if already logged in(checks ip)
                JOptionPane.showMessageDialog(null, "You've already entered account!");
            }else if(loginButton.getText().equals("login")) {
                //login action
                loginAction();
            }else {
                // logout action
                loggedInData = null;
                nameResult.setText("*login to see*");
                surnameResult.setText("*login to see*");
                phoneResult.setText("*login to see*");
                classResult.setText("*login to see*");
                loginButton.setText("login");
                JOptionPane.showMessageDialog(null, "You logged out!");
            }
        });
        refreshButton.addActionListener(e -> {
            //refresh action
            if(loggedInData == null) {
                JOptionPane.showMessageDialog(null, "You haven't logged in!");
                throw new IllegalArgumentException("Logged In Data is null!");
            }
            nameResult.setText(loggedInData.getName());
            surnameResult.setText(loggedInData.getSurname());
            phoneResult.setText(loggedInData.getPhoneNumber());
            classResult.setText(loggedInData.getClassData());
            loginButton.setText("logout");
        });
        add(refreshButton);
    }
    private void loginAction() {
        LoginGUI loginGUI = new LoginGUI(this);
        loginGUI.run();
    }

    public void setLoggedInData(Student loggedInData) {
        this.loggedInData = loggedInData;
    }

}
