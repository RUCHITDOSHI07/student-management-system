package SE_CLASSproject;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField name,age,aadhar,gr,address,contact;
    JButton submit,back;
    JRadioButton male,female;
    ButtonGroup gen;
    JDateChooser DOB;
    int labx=100;
    int labw=100;
    int labh=50;
    int txtx1=300;
    int txtw=200;
    int txth=40;
    addDetails()
    {
        setSize(600,900);

        l1=new JLabel("NAME");
        l1.setFont(new Font("Tahona",Font.PLAIN,15));
        l1.setBounds(labx,60,labw,labh);
        add(l1);

        l2=new JLabel("DOB");
        l2.setFont(new Font("Tahona",Font.PLAIN,15));
        l2.setBounds(labx,120,labw,labh);
        add(l2);

        l3=new JLabel("AGE");
        l3.setFont(new Font("Tahona",Font.PLAIN,15));
        l3.setBounds(labx,180,labw,labh);
        add(l3);

        l4=new JLabel("GENDER");
        l4.setFont(new Font("Tahona",Font.PLAIN,15));
        l4.setBounds(labx,240,labw,labh);
        add(l4);

        l5=new JLabel("AADHAR");
        l5.setFont(new Font("Tahona",Font.PLAIN,15));
        l5.setBounds(labx,300,labw,labh);
        add(l5);

        l6=new JLabel("GR");
        l6.setFont(new Font("Tahona",Font.PLAIN,15));
        l6.setBounds(labx,360,labw,labh);
        add(l6);

        l7=new JLabel("ADDRESS");
        l7.setFont(new Font("Tahona",Font.PLAIN,15));
        l7.setBounds(labx,420,labw,labh);
        add(l7);

        l8=new JLabel("CONTACT");
        l8.setFont(new Font("Tahona",Font.PLAIN,15));
        l8.setBounds(labx,480,labw,labh);
        add(l8);

        name=new JTextField();
        name.setBounds(txtx1,60,txtw,txth);
        add(name);

         DOB =new JDateChooser();
         DOB.setBounds(txtx1,120,txtw,txth);
         add(DOB);

        age=new JTextField();
        age.setBounds(txtx1,180,txtw,txth);
        add(age);

        gen=new ButtonGroup();

        male= new JRadioButton();
        male.setBounds(300,240,20,30);
        gen.add(male);
        add(male);

        female = new JRadioButton();
        female.setBounds(400,240,20,30);
        gen.add(female);
        add(female);

        l9=new JLabel("MALE");
        l9.setFont(new Font("Tahona",Font.PLAIN,12));
        l9.setBounds(330,240,50,30);
        add(l9);

        l10=new JLabel("FEMALE");
        l10.setFont(new Font("Tahona",Font.PLAIN,12));
        l10.setBounds(430,240,50,30);
        add(l10);

        aadhar=new JTextField();
        aadhar.setBounds(txtx1,300,txtw,txth);
        add(aadhar);

        gr=new JTextField();
        gr.setBounds(txtx1,360,txtw,txth);
        add(gr);

        address=new JTextField();
        address.setBounds(txtx1,420,txtw,txth);
        add(address);

        contact=new JTextField();
        contact.setBounds(txtx1,480,txtw,txth);
        add(contact);

        submit=new JButton("SUBMIT..");
        submit.setBounds(250,580,100,50);
        submit.setFont(new Font("Tahona",Font.PLAIN,10));
        submit.addActionListener(this);
        add(submit);

        back=new JButton("<-");
        back.setBounds(20,20,50,30);
        back.addActionListener(this);
        add(back);



        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String name = this.name.getText();
            String age = this.age.getText();
            String address= this.address.getText();
            String contact = this.contact.getText();
            String gr = this.gr.getText();
            String aadhar = this.aadhar.getText();
            String gender = null;
            if(male.isSelected())
            {
                gender= "male";
            }
            else if (female.isSelected())
            {
                gender="female";
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
            String DOB = dateFormat.format(this.DOB.getDate());

            conn c = new conn();
            String str = "insert into studdata(name,dob,age,gender,address,aadhar,contact,gr) values('"+name+"','"+DOB+"','"+age+"','"+gender+"','"+address+"','"+aadhar+"','"+contact+"','"+gr+"'); ";
            try
            {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Data added successfully!!");
                this.name.setText(null);
                this.age.setText(null);
                this.address.setText(null);
                this.aadhar.setText(null);
                this.contact.setText(null);
                this.gr.setText(null);
                this.male.setSelected(false);
                this.female.setSelected(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if (ae.getSource()==back)
        {
            new showDetails();
            this.setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new addDetails();
    }
}
