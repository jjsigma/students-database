package org.project.view;

import javax.swing.*;
import java.awt.*;

public class GeneralPanel extends Panel {
    private final SpringLayout springLayout = new SpringLayout();
    public void addGeneralComponents() {
        setLayout(springLayout);

        //Logo
        JLabel logoLabel = new JLabel("Students.net");
        logoLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 230, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 15, SpringLayout.NORTH, this);

        add(logoLabel);
    }
}
