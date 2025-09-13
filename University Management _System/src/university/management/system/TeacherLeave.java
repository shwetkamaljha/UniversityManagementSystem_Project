package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cTeacherId ;
    JComboBox cbtime;
    JDateChooser dcdate;
    JButton submit , cancel ;

    TeacherLeave(){
        setSize(800, 800);
        setLocation(550, 150);
        setLayout(null);

        getContentPane().setBackground(Color.YELLOW);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(20, 50, 400, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JLabel lbltchrid = new JLabel("Search by Teacher ID:");
        lbltchrid.setBounds(20, 100, 200, 30);
        lbltchrid.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltchrid);

        cTeacherId = new Choice();
        cTeacherId.setBounds(240, 100, 200, 30);
        add(cTeacherId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()) {
                cTeacherId.add(rs.getString("tchrid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date:");
        lbldate.setBounds(20, 150, 200, 30);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(240,150,200,30);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration:");
        lbltime.setBounds(20, 200, 200, 30);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);

        String leave[] = {"HalfDay","1-Day", "2-Days", "3-Days" , "4-Days","5-Days" , "30-DaysMedicalLeave" ," ImergencyLeave"};
        cbtime = new JComboBox(leave);
        cbtime.setBounds(240, 200, 200, 30);
        add(cbtime);

        submit = new JButton("Submit");
        submit.setBounds(40,350,150,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font ("",Font.BOLD,20) );
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,150,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font ("",Font.BOLD,20) );
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== submit){
            String tchrid = cTeacherId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = (String) cbtime.getSelectedItem();

            String query = "insert into teacherLeave values ('"+tchrid+"','"+date+"','"+duration+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Your leave Applied");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}

