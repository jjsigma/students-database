package org.project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private final SpringLayout springLayout = new SpringLayout();
    private LoginGUI loginGUI = new LoginGUI();
    public MainFrame() {
        super("Students.net");
        setBounds(500,200, 650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        createTabs();
    }
    private void addGeneralComponents(JPanel panel) {
        panel.setLayout(springLayout);

        //Logo
        JLabel logoLabel = new JLabel("Students.net");
        logoLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 230, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 15, SpringLayout.NORTH, panel);

        panel.add(logoLabel);

        //login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        loginButton.addActionListener(e -> loginAction());

        springLayout.putConstraint(SpringLayout.WEST, loginButton, 540, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 15, SpringLayout.NORTH, panel);

        panel.add(loginButton);
    }
    private void addInfoComponents(JPanel panel) {

    }
    private void loginAction() {
        loginGUI.start();
    }
    private void createTabs() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.setFont(new Font("Dialog", Font.BOLD, 20));

        //general
        JPanel general = new JPanel();
        tabbedPane.addTab("General", general);
        addGeneralComponents(general);

        //user info
        JPanel userInfoPanel = new JPanel();
        tabbedPane.addTab("Info", userInfoPanel);
        addInfoComponents(userInfoPanel);


//        tabbedPane.addChangeListener(e -> {
//            // Получение выделенной вкладки
//            JPanel panel = (JPanel)((JTabbedPane)e.getSource()).getSelectedComponent();
//        });

//        tabbedPane.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                // Определяем индекс выделенной мышкой вкладки
//                int idx = ((JTabbedPane)e.getSource()).indexAtLocation(e.getX(), e.getY());
//                System.out.println("Выбрана вкладка " + idx);
//            }
//        });
        this.getContentPane().add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
