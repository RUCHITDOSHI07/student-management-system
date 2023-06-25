package SE_CLASSproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField username;
    JPasswordField password;
    JButton signin,cancel;
    login()
    {
        setSize(500,300);


        l1= new JLabel("username");
        l1.setBounds(40,50,100,50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        l2= new JLabel("Password");
        l2.setBounds(40,100,100,50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l2);

        username= new JTextField();
        username.setBounds(150,50,150,40);
        add(username);

        password= new JPasswordField();
        password.setBounds(150,100,150,40);
        add(password);

        signin=new JButton("SIGN IN..");
        signin.setBounds(80,180,100,50);
        signin.setFont(new Font("Tahoma",Font.PLAIN,15));
        signin.addActionListener(this);
        add(signin);

        cancel=new JButton("CANCEL..");
        cancel.setBounds(250,180,100,50);
        cancel.setFont(new Font("Tahoma",Font.PLAIN,15));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/b15.jpg"));
        JLabel i3 =new JLabel(i1);
        i3.setBounds(0,0,500,300);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==signin)
        {
            String username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            conn c = new conn();
            try
            {
                String str1="select * from login where username = '"+username+"'and password ='"+password+"' ;";
                ResultSet rs = c.s.executeQuery(str1);
                if (rs.next())
                {
                    JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL..!!");
                    //new homepage();this.set visible false
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"invalid credentials..");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);

            }
            new window();
            this.setVisible(false);
            if (ae.getSource()==cancel)
            {
                System.exit(0);
            }
        }

    }
}
