package org.project.view;

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    public LoginGUI(){
        super("Login");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void start() {
        addGUIComponents();
        setVisible(true);
    }
    private void addGUIComponents(){
        SpringLayout springLayout = new SpringLayout();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(springLayout);

        // Logo
        JLabel logoLabel = new JLabel("Login");
        logoLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 155, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 5, SpringLayout.NORTH, loginPanel);

        loginPanel.add(logoLabel);

        // name
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField nameField = new JTextField(15);
        nameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 45, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, nameField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameField, 45, SpringLayout.NORTH, loginPanel);

        loginPanel.add(nameLabel);
        loginPanel.add(nameField);

        // surname
        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        //JPasswordField passwordField = new JPasswordField(15);
        JTextField surnameField = new JTextField(15);
        surnameField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, surnameLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, surnameLabel, 95, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, surnameField, 135, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, surnameField, 95, SpringLayout.NORTH, loginPanel);

        loginPanel.add(surnameLabel);
        loginPanel.add(surnameField);

        //phone number
        JLabel phoneLabel = new JLabel("Phone number: ");
        phoneLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField phoneField = new JTextField(13);
        phoneField.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, phoneLabel, 35, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, phoneLabel, 145, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, phoneField, 163, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, phoneField, 145, SpringLayout.NORTH, loginPanel);

        loginPanel.add(phoneLabel);
        loginPanel.add(phoneField);

        //classes
        JLabel classLabel = new JLabel("Class: ");
        classLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        Integer[] classGrades = {1,2,3,4,5,6,7,8,9,10,11};
        JComboBox<Integer> gradeBox = new JComboBox<>(classGrades);
        gradeBox.setFont(new Font("Dialog", Font.PLAIN, 18));

        Character[] classLetters = {'А', 'Б', 'В', 'Г'};
        JComboBox<Character> letterBox = new JComboBox<>(classLetters);
        letterBox.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, classLabel, 105, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, classLabel, 195, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, gradeBox, 163, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, gradeBox, 195, SpringLayout.NORTH, loginPanel);
        springLayout.putConstraint(SpringLayout.WEST, letterBox, 223, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, letterBox, 195, SpringLayout.NORTH, loginPanel);

        loginPanel.add(classLabel);
        loginPanel.add(gradeBox);
        loginPanel.add(letterBox);

        // login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));
        springLayout.putConstraint(SpringLayout.WEST, loginButton, 150, SpringLayout.WEST, loginPanel);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 300, SpringLayout.NORTH, loginPanel);
        loginButton.addActionListener(e -> {
            String username = nameField.getText();
            String password = surnameField.getText();

            if(username.equals("username") && password.equals("password")){
                JOptionPane.showMessageDialog(null, "Login successful!");
            }else{
                JOptionPane.showMessageDialog(null, "Login failed!");
            }
        });

        loginPanel.add(loginButton);

        this.getContentPane().add(loginPanel);
    }
}
