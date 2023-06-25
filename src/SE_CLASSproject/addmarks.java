package SE_CLASSproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addmarks extends JFrame implements ActionListener
{
    JLabel l1,l2,name,gr;
    JLabel English,Maths,Science,Total;
    JLabel History,Geography,Economics,Total1;
    JTextField English1,Maths1,Science1,Total0;
    JTextField History0,Geography0,Economics0,Total10;
    JButton submit,calculate,update,display1,display2,cal1,cal2,sync,back;
    JTextField Gr;
    JScrollPane sp1;
    JTable sem1, sem2;
    JScrollPane sp2;
    JTabbedPane tabs;
    addmarks()
    {
        setSize(1000,800);

        l2=new JLabel("GR:");
        l2.setBounds(60,50,80,50);
        add(l2);

        Gr=new JTextField();
        Gr.setBounds(150,50,100,50);
        add(Gr);

        sem1 = new JTable();
        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);

        sem2 = new JTable();
        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);


        tabs = new JTabbedPane();
        tabs.setBounds(450, 120, 450, 350);
        add(tabs);

        //adding tabs
        tabs.add("sem1", sp1);
        tabs.add("sem2", sp2);
        add(tabs);


        display1 = new JButton("Display sem1:");
        display1.setBounds(400,50,150,50);
        display1.addActionListener(this);
        add(display1);

        cal1=new JButton("calculate");
        cal1.setBounds(300,290,110,50);
        cal1.addActionListener(this);
        add(cal1);

        cal2=new JButton("calculate");
        cal2.setBounds(300,530,110,50);
        cal2.addActionListener(this);
        add(cal2);


        display2 = new JButton("Display sem2:");
        display2.setBounds(600,50,150,50);
        display2.addActionListener(this);
        add(display2);

        //adding subject labels
        English=new JLabel("English");
        English.setBounds(60,110,80,50);
        add(English);

        Maths=new JLabel("Maths");
        Maths.setBounds(60,170,80,50);
        add(Maths);

        Science=new JLabel("Science");
        Science.setBounds(60,230,80,50);
        add(Science);

        Total=new JLabel("Total");
        Total.setBounds(60,290,80,50);
        add(Total);

        History=new JLabel("History");
        History.setBounds(60,350,80,50);
        add(History);

        Geography=new JLabel("Geography");
        Geography.setBounds(60,410,80,50);
        add(Geography);

        Economics=new JLabel("Economics");
        Economics.setBounds(60,470,80,50);
        add(Economics);

        Total1=new JLabel("TOTAl1");
        Total1.setBounds(60,530,80,50);
        add(Total1);

        //adding textfields
        English1=new JTextField();
        English1.setBounds(150,110,120,50);
        add(English1);

        Maths1=new JTextField();
        Maths1.setBounds(150,170,120,50);
        add(Maths1);

        Science1=new JTextField();
        Science1.setBounds(150,230,120,50);
        add(Science1);

        Total0=new JTextField();
        Total0.setBounds(150,290,120,50);
        add(Total0);

        History0=new JTextField();
        History0.setBounds(150,350,120,50);
        add(History0);

        Geography0=new JTextField();
        Geography0.setBounds(150,410,120,50);
        add(Geography0);

        Economics0=new JTextField();
        Economics0.setBounds(150,470,120,50);
        add(Economics0);

        Total10=new JTextField();
        Total10.setBounds(150,530,120,50);
        add(Total10);

        back=new JButton("<-");
        back.setBounds(20,20,50,30);
        back.addActionListener(this);
        add(back);

        sync=new JButton("Sync");
        sync.setBounds(900,550,40,40);
        sync.addActionListener(this);
        add(sync);

        submit = new JButton("Submit");
        submit.setBounds(150,600,120,50);
        submit.addActionListener(this);
        add(submit);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == display1)
        {
            {
                String gr = this.Gr.getText();
                conn c = new conn();
                try {
                    String str = "select name,gr,English,Maths,Science,Total from studdata where gr = '" + gr + "' ;";
                    ResultSet rs = c.s.executeQuery(str);
                    sem1.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        if (ae.getSource()==cal1)
        {
            int s=Integer.parseInt(English1.getText().toString()) + Integer.parseInt( Maths1.getText().toString()) + Integer.parseInt(Science1.getText().toString());
            Total0.setText(" "+s);
        }
        if (ae.getSource()==cal2)
        {
            int s=Integer.parseInt(History0.getText().toString()) + Integer.parseInt( Geography0.getText().toString()) + Integer.parseInt(Economics0.getText().toString());
            Total10.setText(" "+s);
        }
        if (ae.getSource()==back)
        {
            new marks();
            this.setVisible(false);
        }
        if (ae.getSource()==sync)
        {
            new addmarks();
            this.setVisible(false);
        }
        if (ae.getSource()==submit)
        {
            String English=this.English1.getText();
            String Maths=this.Maths1.getText();
            String Science=this.Science1.getText();
            String Total0=this.Total0.getText();
            String History=this.History0.getText();
            String Geography=this.Geography0.getText();
            String Economics=this.Economics0.getText();
            String Total1=this.Total10.getText();

            conn c=new conn();
               String str = "insert into studdata (English,Maths,Science,Total,History,Geography,Economics,Total1) values('"+English+"','"+Maths+"','"+Science+"','"+Total0+"','"+History+"','"+Geography+"','"+Economics+"','"+Total1+"'); ";
            try
            {
                c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"Data added successfully!!");
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
        }


        if (ae.getSource() == display2) {
            {
                String gr = this.Gr.getText();
                conn c = new conn();
                try {
                    String str = "select name,gr,History,Geography,Economics,Total1 from studdata where gr = '" + gr + "' ;";
                    ResultSet rs = c.s.executeQuery(str);
                    sem2.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args)
        {
        new addmarks();
    }

}
