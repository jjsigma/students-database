package org.project.view;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private final SpringLayout springLayout = new SpringLayout();
    private LoginGUI loginGUI = new LoginGUI();
    private boolean isLoggedIn = false;
    public void addInfoComponents() {
        setLayout(springLayout);

        //logo
        JLabel logoLabel = new JLabel("Student Info");
        logoLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 230, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 15, SpringLayout.NORTH, this);

        add(logoLabel);

        //login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        loginButton.addActionListener(e -> loginAction());

        springLayout.putConstraint(SpringLayout.WEST, loginButton, 540, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 15, SpringLayout.NORTH, this);

        add(loginButton);
    }
    private void loginAction() {
        loginGUI.start();
    }
}
