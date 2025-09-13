package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname, tffname , tfaddress , tfphone , tfemail ,tfcls10per , tfcls12per , tfadhr ;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbqualification , cbDepartment;

    JButton submit , cancel ;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+1000L);
    AddTeacher(){

        getContentPane().setBackground(Color.PINK);
        setSize(1125,900);
        setLocation(450,75);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details.");
        heading.setBounds(425,50,600,75);
        heading.setFont(new Font( "serif",Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name: ");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font( "serif",Font.BOLD,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(250,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name: ");
        lblfname.setBounds(500,150,200,30);
        lblfname.setFont(new Font( "serif",Font.BOLD,20));
        add(lblfname);

        tffname=new JTextField();
        tffname.setBounds(750,150,150,30);
        add(tffname);

        JLabel lbltchrid = new JLabel("Teacher Id: ");
        lbltchrid.setBounds(50,200,150,30);
        lbltchrid.setFont(new Font( "serif",Font.BOLD,20));
        add(lbltchrid);

        labelempid = new JLabel("101"+first4);
        labelempid.setBounds(250,200,150,30);
        labelempid.setFont(new Font( "serif",Font.BOLD,20));
        add(labelempid);

        JLabel lbldob = new JLabel("DOB(DateOfBirth): ");
        lbldob.setBounds(500,200,200,30);
        lbldob.setFont(new Font( "serif",Font.BOLD,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(750,200,150,30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address: ");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font( "serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress=new JTextField();
        tfaddress.setBounds(250,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone: ");
        lblphone.setBounds(500,250,200,30);
        lblphone.setFont(new Font( "serif",Font.BOLD,20));
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(750,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id:");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font( "serif",Font.BOLD,20));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(250,300,150,30);
        add(tfemail);

        JLabel lbl10 = new JLabel("Class 10th %");
        lbl10.setBounds(500,300,200,30);
        lbl10.setFont(new Font( "serif",Font.BOLD,20));
        add(lbl10);

        tfcls10per=new JTextField();
        tfcls10per.setBounds(750,300,50,30);
        add(tfcls10per);

        JLabel lbl12 = new JLabel("Class 12th %");
        lbl12.setBounds(50,350, 150,30);
        lbl12.setFont(new Font( "serif",Font.BOLD,20));
        add(lbl12);

        tfcls12per=new JTextField();
        tfcls12per.setBounds(250,350,50,30);
        add(tfcls12per);

        JLabel lblAdhr = new JLabel("Adhar Number:");
        lblAdhr.setBounds(500,350,200,30);
        lblAdhr.setFont(new Font( "serif",Font.BOLD,20));
        add(lblAdhr);

        tfadhr=new JTextField();
        tfadhr.setBounds(750,350,150,30);
        add(tfadhr);

        JLabel lblqualification = new JLabel("Qualification:");
        lblqualification.setBounds(50,450, 150,30);
        lblqualification.setFont(new Font( "serif",Font.BOLD,20));
        add(lblqualification);

        String qualification[]={"B.Tech","BIT","BCA","BBA","M.Tech","MBA","BSC","B.Com","BA","MSC","M.Com","MA","B.Pharma"};
        cbqualification=new JComboBox(qualification); //ComboBox or DropDown
        cbqualification.setBackground(Color.PINK);
        cbqualification.setBounds(250,450,150,30);
        add(cbqualification);

        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setBounds(500,450, 150,30);
        lblDepartment.setFont(new Font( "serif",Font.BOLD,20));
        add(lblDepartment);

        String Department[]={"Computer Science","Mechnical","Electronic","Information Technology","Civil"};
        cbDepartment=new JComboBox(Department);
        cbDepartment.setBackground(Color.PINK);
        cbDepartment.setBounds(750,450,150,30);
        add(cbDepartment);

        submit = new JButton("Submit");
        submit.setBounds(400,610,100,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font ("",Font.BOLD,20) );
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(525,610,100,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font ("",Font.BOLD,20) );
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String tchrId = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            if(phone.matches("^[0-9]*$") && phone.length()==10){
                tfphone.setBackground(Color.GREEN);
            }
            else {
                tfphone.setBackground(Color.RED);
            }
            String email = tfemail.getText();
            String class_x = tfcls10per.getText();
            String class_xii = tfcls12per.getText();
            String aadhar = tfadhr.getText();
            if(aadhar.matches("^[0-9]*$") && aadhar.length()==12){
                tfadhr.setBackground(Color.GREEN);
            }
            else {
                tfadhr.setBackground(Color.RED);
            }
            String qualification = (String) cbqualification.getSelectedItem();
            String Department = (String) cbDepartment.getSelectedItem();
            try {
                if(phone.matches("^[0-9]*$") && phone.length()==10 && aadhar.matches("^[0-9]*$") && aadhar.length()==12){
                String query="insert into teacher values('"+name+"','"+fname+"','"+tchrId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class_x+"','"+class_xii+"','"+aadhar+"','"+qualification+"','"+Department+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null,"In Teacher details Aadhar No or Phone No is Inncorrect");
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddTeacher();
    }
}
