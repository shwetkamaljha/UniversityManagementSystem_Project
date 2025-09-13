package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener {
    Project()
    {
        setSize(1975,1030);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ship.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1825, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        //New Iformation
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem faculityInfo = new JMenuItem("New Faculity Information");
        faculityInfo.setBackground(Color.WHITE);
        faculityInfo.addActionListener(this);
        newInformation.add(faculityInfo);

        JMenuItem studentifo = new JMenuItem("New Student Information");
        studentifo.setBackground(Color.WHITE);
        studentifo.addActionListener(this);
        newInformation.add(studentifo);

        // Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem faculityDetail = new JMenuItem("View Faculity Details");
        faculityDetail.setBackground(Color.WHITE);
        faculityDetail.addActionListener(this);
        details.add(faculityDetail);

        JMenuItem studentdetail = new JMenuItem("View Student Details");
        studentdetail.setBackground(Color.WHITE);
        studentdetail.addActionListener(this);
        details.add(studentdetail);

        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem faculityleave = new JMenuItem("Faculity Leave");
        faculityleave.setBackground(Color.WHITE);
        faculityleave.addActionListener(this);
        leave.add(faculityleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);

        //Leave Details
        JMenu leavedetail = new JMenu("Leave Details");
        leavedetail.setForeground(Color.RED);
        mb.add(leavedetail);

        JMenuItem faculityLeaveDetail = new JMenuItem("Faculity Leave Details");
        faculityLeaveDetail.setBackground(Color.WHITE);
        faculityLeaveDetail.addActionListener(this);
        leavedetail.add(faculityLeaveDetail);

        JMenuItem studentLeaveDetail = new JMenuItem("Student Leave Details");
        studentLeaveDetail.setBackground(Color.WHITE);
        studentLeaveDetail.addActionListener(this);
        leavedetail.add(studentLeaveDetail);

        //Exam
        JMenu exm = new JMenu("Examination");
        exm.setForeground(Color.BLUE);
        mb.add(exm);

        JMenuItem examinationDetail = new JMenuItem("Examination Results");
        examinationDetail.setBackground(Color.WHITE);
        examinationDetail.addActionListener(this);
        exm.add(examinationDetail);

        JMenuItem studentMarks = new JMenuItem("Enter Marks");
        studentMarks.setBackground(Color.WHITE);
        studentMarks.addActionListener(this);
        exm.add(studentMarks);

        //Update Info
        JMenu UpdateInfo = new JMenu("Update Details");
        UpdateInfo.setForeground(Color.RED);
        mb.add(UpdateInfo);

        JMenuItem UpdateFaculityInfo = new JMenuItem("Update Faculity Details");
        UpdateFaculityInfo.setBackground(Color.WHITE);
        UpdateFaculityInfo.addActionListener(this);
        UpdateInfo.add(UpdateFaculityInfo);

        JMenuItem updateStudentMarks = new JMenuItem("Update Student Details");
        updateStudentMarks.setBackground(Color.WHITE);
        updateStudentMarks.addActionListener(this);
        UpdateInfo.add(updateStudentMarks);

        //Update fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem FeeForm = new JMenuItem("Fee Form");
        FeeForm.setBackground(Color.WHITE);
        FeeForm.addActionListener(this);
        fee.add(FeeForm);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.WHITE);
        Exit.addActionListener(this);
        exit.add(Exit);


        setJMenuBar(mb);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        }
        else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
        }
        else if(msg.equals("New Faculity Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("View Faculity Details")){
            new TeacherDetails();
        }else if(msg.equals("View Student Details")){
            new StudentDetails();
        }else if(msg.equals("Faculity Leave")){
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculity Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Update Faculity Details")){
            new UpdateTeacher();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if(msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if(msg.equals("About")) {
            new About();
        }else if(msg.equals("Fee Form")) {
            new StudentFeeForm();
        }
    }


    public static void main(String[] args) {
        new Project();

    }
}
