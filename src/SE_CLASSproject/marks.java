package SE_CLASSproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class marks extends JFrame implements ActionListener {
    JButton add, pass, sync,back;
    JTable sem1, sem2;
    JScrollPane sp1, sp2;
    JTabbedPane tabs;
   public static String name;
    public String History;
    public String Geography;
    public String Economics;
    public String Total1;
    public static String gr;
    public String English;
    public String Maths;
    public String Science;
    public String Total;

    marks() {
        setSize(900, 600);
        //defining tables

        sem1 = new JTable();
        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);

        sem2 = new JTable();
        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);


        tabs = new JTabbedPane();
        tabs.setBounds(400, 80, 450, 350);
        add(tabs);

        //adding tabs
        tabs.add("sem1", sp1);
        tabs.add("sem2", sp2);
        add(tabs);

        //buttons
        add = new JButton("Add/Update");
        add.setBounds(85, 80, 130, 50);
        add.addActionListener(this);
        add(add);

        pass=new JButton("pass/fail");
        pass.setBounds(85,360,130,50);
        pass.addActionListener(this);
        add(pass);

        back=new JButton("<-");
        back.setBounds(20,20,50,30);
        back.addActionListener(this);
        add(back);

        sync=new JButton("Sync");
        sync.setBounds(800,470,40,40);
        sync.addActionListener(this);
        add(sync);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void  sem1Select() {
        sem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = sem1.getSelectedRow();

                name = sem1.getModel().getValueAt(row, 0).toString();
                gr = sem1.getModel().getValueAt(row, 1).toString();
                English = sem1.getModel().getValueAt(row, 2).toString();
                Maths = sem1.getModel().getValueAt(row, 3).toString();
                Science = sem1.getModel().getValueAt(row, 4).toString();
                Total = sem1.getModel().getValueAt(row, 5).toString();
            }

        });
    }

    void sem2Select() {
        sem2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row= sem2.getSelectedRow();
                name = sem2.getModel().getValueAt(row, 0).toString();
                gr = sem2.getModel().getValueAt(row, 1).toString();
                 History = sem2.getModel().getValueAt(row, 2).toString();
                 Geography = sem2.getModel().getValueAt(row, 3).toString();
                 Economics = sem2.getModel().getValueAt(row, 4).toString();
                 Total1 = sem2.getModel().getValueAt(row, 5).toString();

            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            sem1Select();
            System.out.println(name);
            System.out.println(gr);
            System.out.println(English);
            System.out.println(Maths);
            System.out.println(Science);
            System.out.println(Total);

            sem2Select();
            System.out.println(name);
            System.out.println(gr);
            System.out.println(History);
            System.out.println(Geography);
            System.out.println(Economics);
            System.out.println(Total1);

        }
        if (ae.getSource() == back) {
            new window();
            this.setVisible(false);
        }
        if (ae.getSource()==sync)
        {
            displayOriginal();
        }
        if (ae.getSource()==add)
        {
            new addmarks();
            this.setVisible(false);
        }
        if (ae.getSource()==pass)
        {

        }

    }
        void displayOriginal()
        {
            //fetching sem1 data from sql
            conn c = new conn();
            try {
                String str1 = "Select name,gr,English,Maths,Science,Total from studdata ;";
                ResultSet rs = c.s.executeQuery(str1);

                sem1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                System.out.println(e);
            }

            //sem2 data
            try {
                String str2 = "Select name,gr,History,Geography,Economics,Total1 from studdata;";
                ResultSet rs2 = c.s.executeQuery(str2);
                sem2.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    public static void main(String[] args) {
        new marks();
    }
}
