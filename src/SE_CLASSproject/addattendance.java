package SE_CLASSproject;

//import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class addattendance extends JFrame implements ActionListener
{
    JLabel l1,record;
    JTextField gr,add;
    JButton display,submit;
    JScrollPane sp1;
    JTable t1;
    addattendance()
    {
        setSize(550,600);

        l1 = new JLabel("GR no.");
        l1.setBounds(70,50,120,50);
        add(l1);

        gr= new JTextField();
        gr.setBounds(210,50,150,50);
        add(gr);

        display = new JButton("Display:");
        display.setBounds(400,50,100,50);
        display.addActionListener(this);
        add(display);

        sp1=new JScrollPane();
        sp1.setBounds(40,180,480,50);
        add(sp1);

        t1=new JTable();
        sp1.setViewportView(t1);


        record=new JLabel("Add Record");
        record.setBounds(60,350,130,50);
        add(record);

        add = new JTextField();
        add.setBounds(200,350,180,50);
        add(add);

        submit = new JButton("Submit");
        submit.setBounds(300,450,100,50);
        submit.addActionListener(this);
        add(submit);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==display)
        {
            String gr=this.gr.getText();
            conn c=new conn();
            try
            {
                String str="select name,gr,attendance from studdata where gr = '"+gr+"' ;";
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));


            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if (ae.getSource()==submit)
        {
            String gr= this.gr.getText();
            String attend=this.add.getText();
            conn c=new conn();
            try
            {
                String str= "update studdata set attendance = '"+attend+"' where gr = '"+gr+"' ;";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"attendance record updated successfully.!!");
//                setVisible(false);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }




    public static void main(String[] args) {
        new addattendance();
    }
}
