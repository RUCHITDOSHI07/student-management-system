package SE_CLASSproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;
public class main extends JFrame implements ActionListener
{
    JLabel l1;
    JButton b1;
       main()
   {
       setSize(800,500);

           JLabel l1 = new JLabel("STUDENT MONITORING SYSTEM");
           l1.setBounds(250,10,400,100);
           l1.setFont(new Font("Tahoma", BOLD,20));
           add(l1);

           b1=new JButton("login..");
           b1.setBounds(350,250,100,50);
           b1.addActionListener(this);
           add(b1);

           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/first.jpg"));
           JLabel i3 =new JLabel(i1);
           i3.setBounds(0,-50,800,550);
           add(i3);

           setLayout(null);
           setLocationRelativeTo(null);
           setVisible(true);
       }
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b1)
    {
        new login();
        this.setVisible(false);
    }
}
    public static void main(String[] args)
    {
        new main();
    }
}
