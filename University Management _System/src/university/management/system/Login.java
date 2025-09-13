package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField tfusername;
     JPasswordField tfpassword ;
    Login(){
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(50,30,100,30);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,30,150,30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(50,70,100,30);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(50,120,120,30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font ("",Font.ITALIC,16) );
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(185,120,120,30);
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font ("",Font.ITALIC,16) );
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/user.png"));
        Image i2 = i1.getImage().getScaledInstance(204, 204, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,5,500,185);
        add(image);

        setSize(1000,500);
        setLocation(500,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
     if (ae.getSource()==login){
         String username = tfusername.getText();
         String password = tfpassword.getText();

         String query ="select * from login where username= '"+username+"'and password= '"+password+"'";
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery(query);

             if(rs.next()){
                 setVisible(false);
                 new Project();
             }else{
                 JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                 setVisible(false );
             }
         }catch(Exception e) {
             e.printStackTrace();
         }
     }
      else if (ae.getSource()==cancel){
         setVisible(false);
     }
    }

    public static void main(String[] args) {
        new Login();
    }
}
