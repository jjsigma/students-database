package org.project.view;

import javax.swing.*;
import java.awt.*;

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

        this.getContentPane().add(tabbedPane);
    }
}
