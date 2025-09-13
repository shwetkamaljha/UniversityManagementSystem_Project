package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;

    About() {
        setSize(1100, 800);
        setLocation(450, 125);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/frlpy.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 150, 500, 500);
        add(image);

        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Developed By: Shwet Kamal Jha.");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        JLabel rollno = new JLabel("Roll number: 902136039");
        rollno.setBounds(70, 300, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno);

        JLabel regno = new JLabel("Registration Number: 219036042/2021 ");
        regno.setBounds(70, 380, 550, 40);
        regno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(regno);

        JLabel defination = new JLabel("<html>Student of:<br/> MARWARI COLLEGE BHAGALPUR.<br/>TILKA MANJHI BHAGALPUR UNIVERSITY.</html>");
        defination.setBounds(70, 480, 550, 80);
        defination.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(defination);

        setLayout(null);

        setVisible(true);

        back = new JButton("Back");
        back.setBounds(800, 620, 125, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(back);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            try {
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new About();
    }
}