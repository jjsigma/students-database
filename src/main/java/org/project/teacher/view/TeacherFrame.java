package org.project.teacher.view;

import org.project.teacher.sql.CRUDMarksDB;
import org.project.teacher.sql.TeacherLoginDB;
import org.project.teacher.Teacher;
import org.project.teacher.sql.TeacherMarksTableDB;
import org.project.util.MarksPrinter;
import org.project.util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterJob;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.awt.print.PrinterException;

import static java.awt.Font.PLAIN;


/**
 *
 * @author tylerpants
 */
public class TeacherFrame extends javax.swing.JFrame {
    private final TeacherMarksTableDB teacherMarksTableDB = new TeacherMarksTableDB();
    private final TeacherLoginDB teacherLoginDB = new TeacherLoginDB();
    private final CRUDMarksDB crudMarksDB = new CRUDMarksDB();
    private final PrinterJob printerJob = PrinterJob.getPrinterJob();

    public TeacherFrame() {
        setTitle("Teacher");
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addButton = new JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox7 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("img/teacher-icon.jpg").getImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 8));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 8));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Info");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 140, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Surname:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 110, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Subject:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 110, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Phone:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 50));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 45)); // NOI18N
        jButton1.setText("Login");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(e -> {
            if(jButton1.getText().equals("Login") && teacherLoginDB.isLoggedIn()) {
                JOptionPane.showMessageDialog(null, "Already in account!");
            }
            if(jButton1.getText().equals("Login")) {
                new TeacherLoginGUI(this).setVisible(true);
            } else {
                //logout action
                int confirm = JOptionPane.showConfirmDialog(null, "Do you want to log out?");
                if (confirm == JOptionPane.YES_OPTION) {
                    setLogoutData();
                    try {
                        //deleting user IP from system
                        String ip = Util.getIPAddress();
                        int userID = teacherLoginDB.getLoggedInTeacherID(ip);
                        teacherLoginDB.deleteTeacherByID(userID);
                    } catch (SQLException | UnknownHostException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "You logged out!");
                }
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 190, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("*login to see*");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 170, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("*login to see*");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 170, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("*login to see*");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 170, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setText("*login to see*");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 170, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 340, 450));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 8));

        jTable1.setFont(new java.awt.Font("Segoe UI", PLAIN, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                teacherMarksTableDB.getNullData(),
                teacherMarksTableDB.getColumns()
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint()); // var1

                String date = (String) jTable1.getValueAt(row, 0);
                try {
                    jDateChooser1.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                jComboBox3.setSelectedIndex(Integer.parseInt((String) jTable1.getValueAt(row, 1))-1);

                jTextField2.setText((String) jTable1.getValueAt(row, 2));

                String oldDate = date;
                int oldMark = Integer.parseInt((String) Objects.requireNonNull(jComboBox3.getSelectedItem()));
                String oldComment = jTextField2.getText();
                crudMarksDB.setOldData(oldDate, oldMark, oldComment);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Subject: ");

        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] {"Select grade"}));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Students" }));
        jComboBox4.addActionListener(e -> {
            try {
                jComboBox5.setModel(new DefaultComboBoxModel<>(teacherMarksTableDB.getClassLettersByGrade(Integer.parseInt(
                        (String) Objects.requireNonNull(jComboBox4.getSelectedItem())))));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            jComboBox1.setSelectedIndex(jComboBox4.getSelectedIndex());
        });
        jComboBox5.addActionListener(e -> {
            try {
                jComboBox6.setModel(new DefaultComboBoxModel<>(teacherMarksTableDB.getStudentsByClassData(jComboBox4.getSelectedItem() +
                        (String) jComboBox5.getSelectedItem())));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            jComboBox7.setSelectedIndex(jComboBox5.getSelectedIndex());
        });
        jComboBox6.addActionListener(e -> {
            String[] studentData = new String[3];
            String studentNameSurname = (String) jComboBox6.getSelectedItem();
            studentData[0] = studentNameSurname.split("\\s")[0];
            studentData[1] = studentNameSurname.split("\\s")[1];
            studentData[2] = jComboBox4.getSelectedItem() + (String) jComboBox5.getSelectedItem();
            jTable1.setModel(new DefaultTableModel(
                    teacherMarksTableDB.getTableData(studentData[0], studentData[1], studentData[2]),
                    teacherMarksTableDB.getColumns()));
            jComboBox2.setSelectedIndex(jComboBox6.getSelectedIndex());
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jScrollPane2))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jComboBox5)
                                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 480, 380));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 480, 380));

        jButton3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton3.setText("Print");

        MarksPrinter printer = new MarksPrinter();
        printerJob.setPrintable(printer);

        jButton3.addActionListener(e -> {
            if(!teacherLoginDB.isLoggedIn()) {
            JOptionPane.showMessageDialog(null, "Log in account to use it!");
            } else {
                String name = ((String) jComboBox6.getSelectedItem()).split("\\s")[0];
                String surname = ((String) jComboBox6.getSelectedItem()).split("\\s")[1];
                String classData = (String) jComboBox1.getSelectedItem() +jComboBox7.getSelectedItem();

                printer.setData(name, surname, jLabel9.getText(), classData);
                printer.setTableData(teacherMarksTableDB.getTableData(name, surname, classData));
                try {
                    printerJob.print();
                } catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 140, 60));

        jButton5.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton5.setText("Edit");
        jButton5.addActionListener(e -> {
            String nameAndSurname = (String) Objects.requireNonNull(jComboBox2.getSelectedItem());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            int mark = Integer.parseInt((String) Objects.requireNonNull(jComboBox3.getSelectedItem()));
            String classData = (String) jComboBox1.getSelectedItem() + jComboBox7.getSelectedItem();
            try {
                crudMarksDB.updateMark(nameAndSurname, date, mark, jTextField2.getText(), jLabel9.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            jTable1.setModel(new DefaultTableModel(teacherMarksTableDB.getTableData(nameAndSurname.split("\\s")[0],
                    nameAndSurname.split("\\s")[1], classData),
                    teacherMarksTableDB.getColumns()));
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 140, 60));

        jButton6.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton6.setText("Delete");
        jButton6.addActionListener(e -> {
            String nameAndSurname = (String) Objects.requireNonNull(jComboBox2.getSelectedItem());
            String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
            int mark = Integer.parseInt((String) Objects.requireNonNull(jComboBox3.getSelectedItem()));
            String comment = jTextField2.getText();
            String classData = (String) jComboBox1.getSelectedItem() + jComboBox7.getSelectedItem();

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete this mark?");
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    crudMarksDB.deleteMark(nameAndSurname, date, mark, comment, jLabel9.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(null, "Mark deleted!");
                jTable1.setModel(new DefaultTableModel(teacherMarksTableDB.getTableData(nameAndSurname.split("\\s")[0],
                        nameAndSurname.split("\\s")[1], classData),
                        teacherMarksTableDB.getColumns()));
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 140, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 8));

        addButton.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(e -> {
            if(!teacherLoginDB.isLoggedIn()) {
                JOptionPane.showMessageDialog(null, "You must log in!");

            } else {
                String grade = (String) jComboBox1.getSelectedItem();
                String letter = (String) jComboBox7.getSelectedItem();
                if(grade == null || grade.equals("") || letter == null || letter.equals("")) {
                    JOptionPane.showMessageDialog(null, "Class invalid!");
                    throw new IllegalArgumentException("Class invalid!");
                }

                String nameAndSurname = (String) jComboBox2.getSelectedItem();
                if(nameAndSurname == null || nameAndSurname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Student invalid!");
                    throw new IllegalArgumentException("Student invalid!");
                }

                String date = new SimpleDateFormat("yyyy-MM-dd").format(jDateChooser1.getDate());
                if(date.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date invalid!");
                    throw new IllegalArgumentException("Date invalid!");
                }

                int mark = Integer.parseInt((String) Objects.requireNonNull(jComboBox3.getSelectedItem()));
                if(jComboBox3.getSelectedItem().equals("Select a mark")) {
                    JOptionPane.showMessageDialog(null, "Mark invalid!");
                    throw new IllegalArgumentException("Mark invalid!");
                }
                String comment = jTextField2.getText();
                try {
                   boolean isSucceed = crudMarksDB.addMark(Objects.requireNonNull(nameAndSurname), date, mark, comment, jLabel9.getText());
                   if(!isSucceed) {
                       JOptionPane.showMessageDialog(null, "Mark already exists!");
                   } else {
                       jTable1.setModel(new DefaultTableModel(teacherMarksTableDB.getTableData(nameAndSurname.split("\\s")[0],
                               nameAndSurname.split("\\s")[1], grade+letter),
                               teacherMarksTableDB.getColumns()));
                       jDateChooser1.setDate(null);
                       jComboBox3.setSelectedIndex(0);
                       jTextField2.setText("");
                   }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 140, 60));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "student" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Add Mark");

        jComboBox7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] {""}));

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 26)); // NOI18N
        jLabel11.setText("Date:");

        jComboBox3.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a mark", "2", "3", "4", "5" }));

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 26)); // NOI18N
        jLabel12.setText("Mark:");

        jTextField2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jTextField2.setText("");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N

        jComboBox1.addActionListener(e -> {
            try {
                jComboBox7.setModel(new DefaultComboBoxModel<>(teacherMarksTableDB.getClassLettersByGrade(Integer.parseInt(
                        (String) Objects.requireNonNull(jComboBox1.getSelectedItem())))));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            jComboBox4.setSelectedIndex(jComboBox1.getSelectedIndex());
        });
        jComboBox7.addActionListener(e -> {
            try {
                jComboBox2.setModel(new DefaultComboBoxModel<>(teacherMarksTableDB.getStudentsByClassData(jComboBox1.getSelectedItem() +
                        (String) jComboBox7.getSelectedItem())));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            jComboBox5.setSelectedIndex(jComboBox7.getSelectedIndex());
        });
        jComboBox2.addActionListener(e -> {
            String[] studentData = new String[3];
            String studentNameSurname = (String) jComboBox2.getSelectedItem();
            studentData[0] = Objects.requireNonNull(studentNameSurname).split("\\s")[0];
            studentData[1] = studentNameSurname.split("\\s")[1];
            studentData[2] = jComboBox1.getSelectedItem() + (String) jComboBox7.getSelectedItem();
            jTable1.setModel(new DefaultTableModel(
                    teacherMarksTableDB.getTableData(studentData[0], studentData[1], studentData[2]),
                    teacherMarksTableDB.getColumns()));
            jComboBox6.setSelectedIndex(jComboBox2.getSelectedIndex());
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(4, 4, 4)
                                                                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox2, 0, 144, Short.MAX_VALUE))
                                                                        .addComponent(jTextField2)
                                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                                .addComponent(jLabel12)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jComboBox3, 0, 174, Short.MAX_VALUE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                                .addGap(63, 63, 63)
                                                        ))
                                                .addGap(0, 17, Short.MAX_VALUE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGap(17, 17, 17))
        );

        jButton8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jButton8.setText("Exit");
        jButton8.addActionListener(e -> {
            System.exit(0);
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 410, 140, 60));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 310, 380));

        jTabbedPane1.addTab("General", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Teachers", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1250, 550));

        pack();
    }
    public void setData(Teacher data) {
        jLabel7.setText(data.getName());
        jLabel8.setText(data.getSurname());
        jLabel2.setText(data.getPhoneNumber());
        jLabel9.setText(data.getSubjectData());

        jLabel13.setText("Subject: "+ jLabel9.getText());
        teacherMarksTableDB.setSubject(jLabel9.getText());
        teacherLoginDB.setLoggedIn(true);
        jButton1.setText("Logout");

    }
    public void setLogoutData() {
        jLabel7.setText("*login to see*");
        jLabel8.setText("*login to see*");
        jLabel2.setText("*login to see*");
        jLabel9.setText("*login to see*");
        jLabel13.setText("Subject: ");
        teacherLoginDB.setLoggedIn(false);
        jButton1.setText("Login");
    }
    private void checkIfLoggedIn() throws UnknownHostException, SQLException {
        String ip = Util.getIPAddress();
        int userID = teacherLoginDB.getLoggedInTeacherID(ip);
        if(userID != -1) {
            Teacher user = teacherLoginDB.getTeacherByID(userID);
            user.setSubjectData(teacherLoginDB.getSubjectData(user));
            setData(user);
            JOptionPane.showMessageDialog(null, "Logged in!");
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private JButton jButton8;
    private JButton addButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
}
