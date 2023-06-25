package SE_CLASSproject;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class showDetails extends JFrame implements ActionListener
{

    JTable t1;
    JScrollPane sp1;

    JButton add,back;
    showDetails()
    {


        setSize(1000,800);

        sp1=new JScrollPane();
        sp1.setBounds(300,80,600,500);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);
        try
        {
            conn c = new conn();
            String str="Select gr,name,dob,age,gender,address,aadhar,contact from studdata ";
            ResultSet rs=c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        add=new JButton("add");
        add.setBounds(40,100,150,50);
        add.addActionListener(this);
        add(add);

        back=new JButton("<-");
        back.setBounds(20,20,50,30);
        back.addActionListener(this);
        add(back);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new showDetails();
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==add)
        {
            new addDetails();
            this.setVisible(false);
        }
        if (ae.getSource()==back)
        {
            new window();
            this.setVisible(false);
        }
    }

}
