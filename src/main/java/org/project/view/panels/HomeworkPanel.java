package org.project.view.panels;

import javax.swing.*;
import java.awt.*;

public class HomeworkPanel extends AbstractPanel {
    private final SpringLayout springLayout = new SpringLayout();
    @Override
    public void addComponents() {
        setLayout(springLayout);

        //logo
        JLabel logo = new JLabel("Homework Help");
        logo.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logo, 200, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, logo, 15, SpringLayout.NORTH, this);

        add(logo);
    }
}
