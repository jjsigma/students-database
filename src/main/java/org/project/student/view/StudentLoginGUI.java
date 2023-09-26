package org.project.student.view;

import org.project.student.Student;
import org.project.student.sql.LoginDB;
import org.project.util.Util;

import javax.swing.*;
import java.net.UnknownHostException;
import java.sql.SQLException;

import static java.awt.Font.PLAIN;

/**
 *
 * @author tylerpants
 */
public class StudentLoginGUI extends javax.swing.JFrame {
    private final LoginDB loginDB = new LoginDB();
    private final StudentFrame studentFrame;

    public StudentLoginGUI(StudentFrame studentFrame) {
        this.studentFrame = studentFrame;
        initComponents();
    }

    private void initComponents() {
        setResizable(false);

        jPanel4 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jButton1 = new JButton();
        jLabel6 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jTabbedPane2 = new JTabbedPane();
        jLabel7 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jLabel8 = new JLabel();
        jPasswordField2 = new JPasswordField();
        jComboBox3 = new JComboBox<>();
        jComboBox4 = new JComboBox<>();
        jPanel5 = new JPanel();
        jLabel5 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jButton2 = new JButton();
        jLabel12 = new JLabel();
        jComboBox2 = new JComboBox<>();
        jTabbedPane3 = new JTabbedPane();
        jLabel13 = new JLabel();
        jPasswordField3 = new JPasswordField();
        jLabel14 = new JLabel();
        jPasswordField4 = new JPasswordField();
        jComboBox5 = new JComboBox<>();
        jComboBox6 = new JComboBox<>();
        jPanel6 = new JPanel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();
        jTextField8 = new JTextField();
        jTextField9 = new JTextField();
        jTextField10 = new JTextField();
        jButton3 = new JButton();
        jLabel19 = new JLabel();
        jComboBox7 = new JComboBox<>();
        jTabbedPane4 = new JTabbedPane();
        jLabel20 = new JLabel();
        jPasswordField5 = new JPasswordField();
        jLabel21 = new JLabel();
        jPasswordField6 = new JPasswordField();
        jComboBox8 = new JComboBox<>();
        jComboBox9 = new JComboBox<>();
        jTabbedPane1 = new JTabbedPane();
        jPanel7 = new JPanel();
        jLabel22 = new JLabel();
        jLabel23 = new JLabel();
        jLabel24 = new JLabel();
        jLabel25 = new JLabel();
        jTextField11 = new JTextField();
        jTextField12 = new JTextField();
        jTextField13 = new JTextField();
        jButton4 = new JButton();
        jLabel26 = new JLabel();
        jComboBox10 = new JComboBox<>();
        jTabbedPane5 = new JTabbedPane();
        jLabel27 = new JLabel();
        jPasswordField7 = new JPasswordField();
        jLabel28 = new JLabel();
        jPasswordField8 = new javax.swing.JPasswordField();
        jComboBox11 = new JComboBox<>();
        jComboBox12 = new JComboBox<>();
        jPanel3 = new JPanel();
        jPanel8 = new JPanel();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jTextField14 = new JTextField();
        jTextField15 = new JTextField();
        jLabel31 = new JLabel();
        jPasswordField9 = new JPasswordField();
        jButton5 = new JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel1.setText("Confirm:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 40));

        jLabel2.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel2.setText("Name:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, 40));

        jLabel3.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel3.setText("Surname:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 40));

        jLabel4.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel4.setText("Phone:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 40));

        jTextField2.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 190, 40));

        jTextField3.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, 40));

        jTextField4.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 190, 40));

        jButton1.setFont(new java.awt.Font("SansSerif", PLAIN, 24)); // NOI18N
        jButton1.setText("Sign Up");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 30));

        jLabel6.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel6.setText("Gender:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, 40));

        jComboBox1.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 190, 40));
        jPanel4.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel7.setText("Class:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 40));

        jPasswordField1.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel4.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, 40));

        jLabel8.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel8.setText("Password:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 40));

        jPasswordField2.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel4.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, 40));

        jComboBox3.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "А", "Б", "В", "Г", "Д" }));
        jPanel4.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 90, 40));

        jComboBox4.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel4.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 232, 90, 40));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel5.setText("Confirm:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 40));

        jLabel9.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel9.setText("Name:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, 40));

        jLabel10.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel10.setText("Surname:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 40));

        jLabel11.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel11.setText("Phone:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 40));

        jTextField5.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 190, 40));

        jTextField6.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, 40));

        jTextField7.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel5.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 190, 40));

        jButton2.setFont(new java.awt.Font("SansSerif", PLAIN, 24)); // NOI18N
        jButton2.setText("Sign Up");
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 30));

        jLabel12.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel12.setText("Gender:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, 40));

        jComboBox2.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 190, 40));
        jPanel5.add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel13.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel13.setText("Class:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 40));

        jPasswordField3.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel5.add(jPasswordField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, 40));

        jLabel14.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel14.setText("Password:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 40));

        jPasswordField4.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel5.add(jPasswordField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, 40));

        jComboBox5.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "А", "Б", "В", "Г", "Д" }));
        jPanel5.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 90, 40));

        jComboBox6.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel5.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 232, 90, 40));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel15.setText("Confirm:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 40));

        jLabel16.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel16.setText("Name:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, 40));

        jLabel17.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel17.setText("Surname:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 40));

        jLabel18.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel18.setText("Phone:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 40));

        jTextField8.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel6.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 190, 40));

        jTextField9.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel6.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, 40));

        jTextField10.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel6.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 190, 40));

        jButton3.setFont(new java.awt.Font("SansSerif", PLAIN, 24)); // NOI18N
        jButton3.setText("Sign Up");
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 30));

        jLabel19.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel19.setText("Gender:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, 40));

        jComboBox7.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel6.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 190, 40));
        jPanel6.add(jTabbedPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel20.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel20.setText("Class:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 40));

        jPasswordField5.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel6.add(jPasswordField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 190, 40));

        jLabel21.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel21.setText("Password:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 120, 40));

        jPasswordField6.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel6.add(jPasswordField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 190, 40));

        jComboBox8.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "А", "Б", "В", "Г", "Д" }));
        jPanel6.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 90, 40));

        jComboBox9.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel6.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 232, 90, 40));

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel22.setText("Confirm:");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 120, 40));

        jLabel23.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel23.setText("Name:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, 40));

        jLabel24.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel24.setText("Surname:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 40));

        jLabel25.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel25.setText("Phone:");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 90, 40));

        jTextField11.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel7.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 190, 40));

        jTextField12.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel7.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, 40));

        jTextField13.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel7.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 190, 40));

        jButton4.setFont(new java.awt.Font("SansSerif", PLAIN, 24)); // NOI18N
        jButton4.setText("Sign Up");

        // Register
        jButton4.addActionListener(e -> {
            Student student;
            String name = jTextField11.getText();
            String surname = jTextField12.getText();
            String phoneNum = jTextField13.getText();
            String gender = (String) jComboBox10.getSelectedItem();
            String grade = (String) jComboBox12.getSelectedItem();
            String letter = (String) jComboBox11.getSelectedItem();
            String password = jPasswordField8.getText();
            String passwordRepeat = jPasswordField7.getText();

            if(!password.equals(passwordRepeat)) {
                JOptionPane.showMessageDialog(null, "Passwords are not similar!");
                throw new IllegalArgumentException("passwords are not similar!");
            }
            try {
                int classId = loginDB.getClassID(grade, letter);
                if (classId == -1) {
                    JOptionPane.showMessageDialog(null, "Class doesn't exist!");
                } else {
                    if (!Util.isPhoneNumberValid(phoneNum)) {
                        JOptionPane.showMessageDialog(null, "Phone number is not valid!");
                    } else if (!Util.isNameValid(name)) {
                        JOptionPane.showMessageDialog(null, "Name is not valid!");
                    } else if (!Util.isSurnameValid(surname)) {
                        JOptionPane.showMessageDialog(null, "Surname is not valid!");
                    } else {
                        if (!loginDB.checkIfExist(name, surname, password)) {
                            assert gender != null;
                            student = new Student(surname, name, phoneNum, classId, gender, password);
                            student.setClassData(grade+letter);
                            loginDB.add(student);
                            setData(student);
                            JOptionPane.showMessageDialog(null, "Account created successfully!");
                            int id = loginDB.getIDByStudentData(student);

                            loginDB.addIPToUsersDB(Util.getIPAddress(), id);
                            loginDB.setLoggedIn(true);
                            studentFrame.getAvgMarkCounter().count(id);
                        } else {
                            JOptionPane.showMessageDialog(null, "Account already exists!");
                            throw new IllegalArgumentException("account already exists!");
                        }
                    }
                }
            } catch (SQLException | UnknownHostException ex) {
                throw new RuntimeException(ex);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 170, 30));

        jLabel26.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel26.setText("Gender:");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 90, 40));

        jComboBox10.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel7.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 190, 40));
        jPanel7.add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel27.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel27.setText("Class:");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, 40));

        jPasswordField7.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel7.add(jPasswordField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 190, 40));

        jLabel28.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel28.setText("Password:");
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 120, 40));

        jPasswordField8.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel7.add(jPasswordField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 190, 40));

        jComboBox11.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "А", "Б", "В", "Г", "Д" }));
        jPanel7.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 90, 40));

        jComboBox12.setFont(new java.awt.Font("Segoe UI", PLAIN, 24)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel7.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 90, 40));

        jTabbedPane1.addTab("Register", jPanel7);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 390, 490));

        jLabel29.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel29.setText("Name:");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 40));

        jLabel30.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel30.setText("Surname:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 40));

        jTextField14.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 190, 40));

        jTextField15.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 190, 40));

        jLabel31.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel31.setText("Password:");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, 40));

        jPasswordField9.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jPanel3.add(jPasswordField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 190, 40));

        jButton5.setFont(new java.awt.Font("SansSerif", PLAIN, 24)); // NOI18N
        jButton5.setText("Login");

        // Login
        jButton5.addActionListener(e -> {
            String name = jTextField15.getText();
            String surname = jTextField14.getText();
            String password = jPasswordField9.getText();
            try {
                if(!loginDB.checkIfExist(name, surname, password)) {
                    JOptionPane.showMessageDialog(null, "Account doesn't exist!");
                    throw new IllegalArgumentException("Account doesn't exist!");
                }
                int id = loginDB.getIDByStudentData(new Student(name, surname, password));

                loginDB.addIPToUsersDB(Util.getIPAddress(), id);
                loginDB.setLoggedIn(true);

                Student data = loginDB.getStudentByID(id);
                data.setClassData(loginDB.getClassData(data));
                setData(data);
                studentFrame.getAvgMarkCounter().count(id);
                JOptionPane.showMessageDialog(null, "Logged in successfully!");
            } catch (SQLException | UnknownHostException ex) {
                throw new RuntimeException(ex);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 30));

        jTabbedPane1.addTab("Login", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void setData(Student student) {
        studentFrame.setData(student);
    }


    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox10;
    private JComboBox<String> jComboBox11;
    private JComboBox<String> jComboBox12;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox4;
    private JComboBox<String> jComboBox5;
    private JComboBox<String> jComboBox6;
    private JComboBox<String> jComboBox7;
    private JComboBox<String> jComboBox8;
    private JComboBox<String> jComboBox9;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JPasswordField jPasswordField3;
    private JPasswordField jPasswordField4;
    private JPasswordField jPasswordField5;
    private JPasswordField jPasswordField6;
    private JPasswordField jPasswordField7;
    private JPasswordField jPasswordField8;
    private JPasswordField jPasswordField9;
    private JTabbedPane jTabbedPane1;
    private JTabbedPane jTabbedPane2;
    private JTabbedPane jTabbedPane3;
    private JTabbedPane jTabbedPane4;
    private JTabbedPane jTabbedPane5;
    private JTextField jTextField10;
    private JTextField jTextField11;
    private JTextField jTextField12;
    private JTextField jTextField13;
    private JTextField jTextField14;
    private JTextField jTextField15;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JTextField jTextField9;
}