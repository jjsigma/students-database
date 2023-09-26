package org.project.util;

import org.project.teacher.sql.TeacherMarksTableDB;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class MarksPrinter implements Printable {
    private String name, surname, subject, classData;
    private String[][] data;
    private TeacherMarksTableDB teacherMarksTableDB= new TeacherMarksTableDB();

    public MarksPrinter() {

    }
    public void setData(String name, String surname, String subject, String classData) {
        this.name= name;
        this.surname = surname;
        this.subject = subject;
        this.classData = classData;
    }
    public void setTableData(String[][] data) {
        this.data = data;
    }
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        if(data == null) {
            throw new PrinterException("Data is null!");
        }

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        graphics.drawString(name+" "+surname, 40, 10);
        graphics.drawString(subject, 170,10);

        graphics.drawString("Date", 10, 50);
        graphics.drawString("Mark", 120, 50);
        graphics.drawString("Comment", 230, 50);

        for(int i = 10; i <= 300; i+=20) {
            graphics.drawString("__", i, 75);
        }

        for(int i = 0; i < data.length; i++) {
            graphics.drawString(data[i][0], 10, (i+2)*50);

            graphics.drawString(data[i][1], 120, (i+2)*50);

            if(data[i][2] == null || data[i][2].equals("")) {
                graphics.drawString("---", 230, (i+2) * 50);
            } else {
                graphics.drawString(data[i][2], 230, (i+2) * 50);
            }
        }
        for(int i = 50; i <= (data.length+1) * 50; i+=20) {
            graphics.drawString("|", 110, i);
            graphics.drawString("|", 220, i);
        }
        return Printable.PAGE_EXISTS;
    }
}
