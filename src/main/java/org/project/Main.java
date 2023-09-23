package org.project;

import org.project.student.view.ReallyTestFrame;
import org.project.teacher.TeacherFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Yes: student\nNo: teacher");
        if(choice == JOptionPane.YES_OPTION) {
            SwingUtilities.invokeLater(ReallyTestFrame::new);
        } else if(choice == JOptionPane.NO_OPTION) {
            SwingUtilities.invokeLater(TeacherFrame::new);
        }
    }
}
