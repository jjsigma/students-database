package org.project;

import org.project.student.view.StudentFrame;
import org.project.teacher.view.TeacherFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Yes: student\nNo: teacher");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}
        if(choice == JOptionPane.YES_OPTION) {
            SwingUtilities.invokeLater(StudentFrame::new);
        } else if(choice == JOptionPane.NO_OPTION) {
            SwingUtilities.invokeLater(TeacherFrame::new);
        }
    }
}
