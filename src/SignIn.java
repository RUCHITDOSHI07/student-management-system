//package MiniProject;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.gray;

public class SignIn extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField name, username, email;
    JPasswordField  p1, p2;
    JButton signin;

    Font F1=new Font("Alice",Font.PLAIN,20);

    SignIn()
    {
        setSize(1920,1040);
        Container c = getContentPane();
        c.setBackground(gray);

        l6 = new JLabel("Sign In");
        l6.setBounds(190,50,300,80);
        l6.setForeground(Color.white);
        l6.setFont(new Font("Times New Roman",Font.BOLD,60));
        add(l6);

        l1 = new JLabel("Name");
        l1.setBounds(100,150,100,30);
        l1.setForeground(Color.white);
        l1.setFont(F1);
        add(l1);

        l2 = new JLabel("Username");
        l2.setBounds(100,200,150,30);
        l2.setForeground(Color.white);
        l2.setFont(F1);
        add(l2);

        l5 = new JLabel("Email id");
        l5.setBounds(100,250,100,30);
        l5.setForeground(Color.white);
        l5.setFont(F1);
        add(l5);

        l3 = new JLabel("Password");
        l3.setBounds(100,300,100,30);
        l3.setForeground(Color.white);
        l3.setFont(F1);
        add(l3);

        l4 = new JLabel("Confirm Password");
        l4.setBounds(100,350,165,30);
        l4.setForeground(Color.white);
        l4.setFont(F1);
        add(l4);

        name = new JTextField();
        name.setBounds(280,150,120,30);
        add(name);

        username = new JTextField();
        username.setBounds(280,200,120,30);
        add(username);

        email = new JTextField();
        email.setBounds(280,250,120,30);
        add(email);

        p1 = new JPasswordField();
        p1.setBounds(280,300,120,30);
        add(p1);

        p2 = new JPasswordField();
        p2.setBounds(280,350,120,30);
        add(p2);

        signin = new JButton("Sign In");
        signin.setBounds(250,400,80,30);
        signin.setFont(new Font("Times New Roman",Font.PLAIN,15));
        signin.addActionListener(this);
        add(signin);

////        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/signin_bg.jpg"));
//        JLabel i3 =new JLabel(i1);
//        i3.setBounds(0,0,600,500);
//        add(i3);


        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {    new SignIn();   }

    @Override
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource() == signin)
        {

            String name = this.name.getText();
            String username = this.username.getText();
            String email = this.email.getText();
            String password = String.valueOf(this.p1.getPassword());
//            conn c = new conn();
//            String str1 = "insert into users(name,username,email_id,password) values('" + name + "','" + username + "','" + email + "','" + password + "');";
            if (this.username.getText().length() <= 0 || this.p1.getPassword().toString().length() <= 0)
            {
                JOptionPane.showMessageDialog(null, "not allowed");
//                this.setVisible(false);
            }
            else {
                try {
//               c.s.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "Account Created Sucessfully ^_^");
                    this.name.setText(null);
                    this.username.setText(null);
                    this.email.setText(null);
                    this.p1.setText(null);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }


//            new Home_logedin();

//            this.setVisible(false);
        }
    }
}