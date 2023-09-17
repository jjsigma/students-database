package org.project.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Students.net");
        setBounds(500,200, 650,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        createTabs();
    }
    private void createTabs() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.setFont(new Font("Dialog", Font.BOLD, 20));

        //general
        GeneralPanel general = new GeneralPanel();
        tabbedPane.addTab("General", general);
        general.addGeneralComponents();

        //user info
        InfoPanel userInfoPanel = new InfoPanel();
        tabbedPane.addTab("Info", userInfoPanel);
        userInfoPanel.addInfoComponents();


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
