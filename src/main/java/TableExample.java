import javax.swing.*;
public class TableExample {
    JFrame f;
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel();
    TableExample(){
        f=new JFrame();
        f.add(panel);
        panel.setLayout(springLayout);
        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};

        String column[]={"ID","NAME","SALARY"};

        JTable jt = new JTable(data, column);
        jt.setBounds(30,40,550,450);
        JScrollPane sp=new JScrollPane(jt);
        panel.add(sp);
//        .setSize(600,500);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new TableExample();
    }
}  