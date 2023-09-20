package org.project.view.panels;


import javax.swing.*;
import java.awt.*;
import org.project.view.TableGUI;

public class GeneralPanel extends AbstractPanel {
    private final SpringLayout springLayout = new SpringLayout();
    @Override
    public void addComponents() {
        setLayout(springLayout);

        //Logo
        JLabel logoLabel = new JLabel("Criminal shyt");
        logoLabel.setFont(new Font("Dialog", Font.BOLD, 30));

        springLayout.putConstraint(SpringLayout.WEST, logoLabel, 220, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, logoLabel, 15, SpringLayout.NORTH, this);

        add(logoLabel);

        //students table button
        JButton mainTableButton = new JButton("Show all students");
        mainTableButton.setFont(new Font("Dialog", Font.PLAIN, 18));

        springLayout.putConstraint(SpringLayout.WEST, mainTableButton, 230, SpringLayout.WEST, this);
        springLayout.putConstraint(SpringLayout.NORTH, mainTableButton, 100, SpringLayout.NORTH, this);

        mainTableButton.addActionListener(e -> {
            new TableGUI().setVisible(true);
        });

        add(mainTableButton);
    }
}
