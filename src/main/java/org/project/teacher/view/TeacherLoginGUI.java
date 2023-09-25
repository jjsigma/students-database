package org.project.teacher.view;

import org.project.teacher.sql.TeacherLoginDB;
import org.project.teacher.Teacher;
import org.project.util.Util;

import javax.swing.*;
import java.net.UnknownHostException;
import java.sql.SQLException;

/**
 *
 * @author tylerpants
 */
public class TeacherLoginGUI extends javax.swing.JFrame {
    private final TeacherLoginDB teacherLoginDB = new TeacherLoginDB();
    private TeacherFrame teacherFrame;

    public TeacherLoginGUI(TeacherFrame teacherFrame) {
        this.teacherFrame = teacherFrame;
        setTitle("Login as teacher");
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        setResizable(false);

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 10));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        jLabel4.setText("Surname:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 150, 50));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, 50));

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 160, 50));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 160, 50));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setText("Log in");
        jButton1.addActionListener(e -> {
            String name = jTextField2.getText();
            String surname = jTextField3.getText();
            String password = jPasswordField1.getText();
            try {
                if(!teacherLoginDB.checkIfExist(name, surname, password)) {
                    JOptionPane.showMessageDialog(null, "Account doesn't exist!");
                    throw new IllegalArgumentException("Account doesn't exist!");
                }
                int id = teacherLoginDB.getIDByTeacherData(new Teacher(name, surname, password));
                Teacher data = teacherLoginDB.getTeacherByID(id);
                teacherLoginDB.addIPToTeachersDB(Util.getIPAddress(), id);
                teacherLoginDB.setLoggedIn(true);
                data.setSubjectData(teacherLoginDB.getSubjectData(data));
                setData(data);
                JOptionPane.showMessageDialog(null, "Logged in successfully!");
            } catch (SQLException | UnknownHostException ex) {
                throw new RuntimeException(ex);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 180, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));
        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }
    private void setData(Teacher teacher) {
        teacherFrame.setData(teacher);
    }


    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
}
