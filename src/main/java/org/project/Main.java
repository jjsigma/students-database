package org.project;

import org.project.view.ReallyTestFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReallyTestFrame::new);
    }
}
