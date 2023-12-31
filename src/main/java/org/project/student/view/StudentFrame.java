package org.project.student.view;

import org.project.student.Student;
import org.project.student.sql.LoginDB;
import org.project.student.sql.MarksTableDB;
import org.project.util.MarksPrinter;
import org.project.util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;

import static java.awt.Font.PLAIN;

/**
 *
 * @author tylerpants
 */
public class StudentFrame extends javax.swing.JFrame {
    private final MarksTableDB marksTableDB = new MarksTableDB();
    private final LoginDB loginDB = new LoginDB();
    private AvgMarkCounter avgMarkCounter;
    private final PrinterJob printerJob = PrinterJob.getPrinterJob();

    public StudentFrame() {
        setResizable(false);
        initComponents();
        setVisible(true);
        try {
            checkIfLoggedIn();
        } catch (UnknownHostException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initComponents() {

        JTabbedPane jTabbedPane1 = new JTabbedPane();
        JPanel jPanel1 = new JPanel();
        JPanel jPanel5 = new JPanel();
        JButton jButton3 = new JButton();
        JButton jButton7 = new JButton();
        jLabel5 = new JLabel();
        JPanel jPanel9 = new JPanel();
        JPanel jPanel10 = new JPanel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        JLabel jLabel18 = new JLabel();
        JLabel jLabel20 = new JLabel();
        jLabel43 = new JLabel();
        jLabel44 = new JLabel();
        jLabel45 = new JLabel();
        jLabel46 = new JLabel();
        jLabel47 = new JLabel();
        jButton8 = new JButton();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel8 = new JPanel();
        JLabel jLabel27 = new JLabel();
        jComboBox2 = new JComboBox<>();
        JScrollPane jScrollPane2 = new JScrollPane();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        JPanel jPanel11 = new JPanel();
        JPanel jPanel12 = new JPanel();
        JLabel jLabel28 = new JLabel();
        JLabel jLabel29 = new JLabel();
        JLabel jLabel30 = new JLabel();
        jLabel31 = new JLabel();
        JLabel jLabel32 = new JLabel();
        JLabel jLabel33 = new JLabel();
        JLabel jLabel34 = new JLabel();
        JLabel jLabel35 = new JLabel();
        JLabel jLabel36 = new JLabel();
        jLabel37 = new JLabel();
        jLabel38 = new JLabel();
        jLabel39 = new JLabel();
        jLabel40 = new JLabel();
        jLabel41 = new JLabel();
        jLabel42 = new JLabel();
        JPanel jPanel2 = new JPanel();

         avgMarkCounter = new AvgMarkCounter();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student");
        setIconImage(new ImageIcon("img/student-icon.jpg").getImage());

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(200, 200, 1000, 800));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Dungeon", PLAIN, 18)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 8));
        jTabbedPane1.setFont(new java.awt.Font("Courier New", PLAIN, 18)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Exit");
        jButton3.setFont(new java.awt.Font("Segoe UI", PLAIN, 26));
        jButton3.addActionListener(e -> System.exit(0));
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 170, 60));

        jButton7.setText("Print");
        jButton7.setFont(new java.awt.Font("Segoe UI", PLAIN, 26));
        MarksPrinter printer = new MarksPrinter();
        printerJob.setPrintable(printer);
        jButton7.addActionListener(e -> {
            if(!loginDB.isLoggedIn()) {
                JOptionPane.showMessageDialog(null, "Log in account to use it!");
            } else {
                printer.setData(jLabel43.getText(), jLabel44.getText(), (String) jComboBox2.getSelectedItem(), jLabel47.getText());
                printer.setTableData(marksTableDB.getTableData());
                try {
                    printerJob.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 60));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 410, 130));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", PLAIN, 14)); // NOI18N
        try {
            jLabel5.setText("Online: "+loginDB.getAmountOfOnlineUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 130, 30));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 390, 490));

        jLabel12.setFont(new java.awt.Font("Tahoma", PLAIN, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Info");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 200, 40));

        jLabel14.setBackground(java.awt.Color.lightGray);
        jLabel14.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel14.setText("Name:");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 40));

        jLabel16.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel16.setText("Phone:");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 170, 40));

        jLabel17.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel17.setText("Gender:");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 120, 40));

        jLabel18.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel18.setText("Class:");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, 40));

        jLabel20.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel20.setText("Surname:");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 40));

        jLabel43.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel43.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel43.setText("*login to see*");
        jPanel9.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 160, 40));

        jLabel44.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel44.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel44.setText("*login to see*");
        jPanel9.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 160, 40));

        jLabel45.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel45.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel45.setText("*login to see*");
        jPanel9.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 160, 40));

        jLabel46.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel46.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel46.setText("*login to see*");
        jPanel9.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 160, 40));

        jLabel47.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel47.setHorizontalAlignment(SwingConstants.LEADING);
        jLabel47.setText("*login to see*");
        jPanel9.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 160, 40));

        jButton8.setFont(new java.awt.Font("Segoe UI", PLAIN, 30)); // NOI18N
        jButton8.setText("Login");
        jButton8.addActionListener(e -> {
            if(jButton8.getText().equals("Login") && loginDB.isLoggedIn()) {
                JOptionPane.showMessageDialog(null, "Already in account!");
            } else if(jButton8.getText().equals("Login")) {
                new StudentLoginGUI(this).setVisible(true);
            } else {
                //logout action
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to log out?");
                if (confirm == JOptionPane.YES_OPTION) {
                    setLogoutData();
                    try {
                        //deleting user IP from system
                        String ip = Util.getIPAddress();
                        int userID = loginDB.getLoggedInUserID(ip);
                        loginDB.deleteUserByID(userID);
                    } catch (SQLException | UnknownHostException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "You logged out!");
                }
            }
        });
        jPanel9.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 170, 50));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 390, 490));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 390, 490));

        jLabel27.setFont(new java.awt.Font("Tahoma", PLAIN, 24)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Marks");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 200, 40));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", PLAIN, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maths", "Russian", "English", "Chemistry", "History", "Law", "ITC" }));
        jComboBox2.addActionListener(e -> {
            if(loginDB.isLoggedIn()) {
                try {
                    marksTableDB.setStudent(new Student(jLabel44.getText(),
                    jLabel43.getText(),
                    jLabel45.getText(),
                    loginDB.getClassID(jLabel47.getText().charAt(0) + "", jLabel47.getText().charAt(1)+"")));
                    marksTableDB.setSubject((String) jComboBox2.getSelectedItem());
                    jTable1.setModel(new DefaultTableModel(marksTableDB.getTableData(), marksTableDB.getColumns()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel6.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 30));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setFont(new java.awt.Font("Segoe UI", PLAIN, 18));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(390, 402));

        jTable1.setFont(new java.awt.Font("Segoe UI", PLAIN, 18));
        jTable1.setModel(new DefaultTableModel(marksTableDB.getNullData(), marksTableDB.getColumns()));
        jTable1.setPreferredSize(new java.awt.Dimension(390, 420));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 420));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 410, 490));

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 8));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 390, 490));

        jLabel28.setFont(new java.awt.Font("Tahoma", PLAIN, 24)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Average marks");
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 40));

        jLabel29.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel29.setText("ITC");
        jPanel11.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 120, 40));

        jLabel30.setBackground(java.awt.Color.lightGray);
        jLabel30.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel30.setText("Maths");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 40));

        jLabel31.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("0.00");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 120, 40));

        jLabel32.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel32.setText("English");
        jPanel11.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 120, 40));

        jLabel33.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel33.setText("Chemistry");
        jPanel11.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 120, 40));

        jLabel34.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel34.setText("History");
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 120, 40));

        jLabel35.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel35.setText("Law");
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 120, 40));

        jLabel36.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel36.setText("Russian");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 40));

        jLabel37.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("0.00");
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 120, 40));

        jLabel38.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("0.00");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 120, 40));

        jLabel39.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("0.00");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 120, 40));

        jLabel40.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("0.00");
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 120, 40));

        jLabel41.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("0.00");
        jPanel11.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 120, 40));

        jLabel42.setFont(new java.awt.Font("sansserif", PLAIN, 24)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("0.00");
        jPanel11.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 120, 40));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 390, 490));

        jTabbedPane1.addTab("Personal Data", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Students", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1340, 740));

        pack();
    }

    public class AvgMarkCounter {
        private final HashMap<String, JLabel> subjects = new HashMap<>() {{
            put("Maths", jLabel37);
            put("Russian", jLabel42);
            put("English", jLabel38);
            put("Chemistry", jLabel39);
            put("History", jLabel40);
            put("Law", jLabel41);
            put("ITC", jLabel31);
        }};
        public void setZero() {
            for(JLabel jLabel : subjects.values()) {
                jLabel.setText("0.00");
            }
        }
        public void count(int studentID) {
            try {
                for(String s : subjects.keySet()) {
                    int sum = marksTableDB.getSumMarksBySubject(s, studentID);
                    int amount = marksTableDB.getNumberOfMarksBySubject(s, studentID);
                    if (sum == 0 || amount == 0) {
                        subjects.get(s).setText("0.00");
                    } else {
                        double avg = (sum * 1.00) / (amount * 1.00);
                        subjects.get(s).setText(String.format("%.2f", avg));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public AvgMarkCounter getAvgMarkCounter() {
        return avgMarkCounter;
    }

    public void setData(Student data) {
        jLabel43.setText(data.getName());
        jLabel44.setText(data.getSurname());
        jLabel45.setText(data.getPhoneNumber());
        jLabel46.setText(data.getGender());
        jLabel47.setText(data.getClassData());
        jButton8.setText("Logout");
        try {
            avgMarkCounter.count(loginDB.getIDByStudentData(data));
            jLabel5.setText("Online: " + loginDB.getAmountOfOnlineUsers());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        loginDB.setLoggedIn(true);
    }
    public void setLogoutData() {
        jLabel43.setText("*login to see*");
        jLabel44.setText("*login to see*");
        jLabel45.setText("*login to see*");
        jLabel46.setText("*login to see*");
        jLabel47.setText("*login to see*");
        jButton8.setText("Login");
        avgMarkCounter.setZero();
        try {
            jLabel5.setText("Online: " + (+loginDB.getAmountOfOnlineUsers() - 1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        loginDB.setLoggedIn(false);
    }
    private void checkIfLoggedIn() throws UnknownHostException, SQLException {
        String ip = Util.getIPAddress();
        int userID = loginDB.getLoggedInUserID(ip);
        if(userID != -1) {
            Student user = loginDB.getStudentByID(userID);
            user.setClassData(loginDB.getClassData(user));
            setData(user);
        }
    }

    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jTable1;
}
