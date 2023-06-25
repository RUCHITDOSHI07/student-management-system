package SE_CLASSproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    window()
    {
        setSize(1000,800);

        b1=new JButton("Details");
        b1.setBounds(55,300,250,250);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Marks");
        b2.setBounds(365,300,250,250);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("Attendance");
        b3.setBounds(675,300,250,250);
        b3.addActionListener(this);
        add(b3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new showDetails();
            this.setVisible(false);
        }
        if(ae.getSource()==b2)
        {
            new marks();
            this.setVisible(false);
        }
        if(ae.getSource()==b3)
        {
            new attendance();
            this.setVisible(false);
        }

    }

    public static void main(String[] args)
    {
        new window();
    }
}
