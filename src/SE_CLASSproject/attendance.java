package SE_CLASSproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener
{
    JButton add,defaulters, refresh;
    JTable j1;
    JScrollPane sp1;

    attendance()
    {
        setSize(1000,500);

        //scroll pane
        sp1=new JScrollPane();
        sp1.setBounds(450,80,500,300);
        add(sp1);

        //table
        j1=new JTable();
        sp1.setViewportView(j1);
        displayOriginal();


        //button
        add=new JButton("add:");
        add.setBounds(100,100,120,50);
        add.addActionListener(this);
        add(add);

        defaulters = new JButton("defaulter");
        defaulters.setBounds(100,250,120,50);
        defaulters.addActionListener(this);
        add(defaulters);

//        ImageIcon i1=new ImageIcon();
        refresh =new JButton("()");
        refresh.setBounds(900,410,40,40);
        refresh.addActionListener(this);
        add(refresh);


        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    void displayOriginal()
    {
        try
        {
            conn c = new conn();
            String str="Select gr,name,attendance from studdata ";
            ResultSet rs=c.s.executeQuery(str);
            j1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==defaulters)
        {
            conn c = new conn();
            try
            {
                String str = "select gr,name,attendance from studdata where attendance < 50;";
                ResultSet rs =c.s.executeQuery(str);
                j1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if (ae.getSource()==refresh)
        {
            displayOriginal();
        }
        if (ae.getSource()==add)
        {
            new addattendance();
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new attendance();
    }
}




