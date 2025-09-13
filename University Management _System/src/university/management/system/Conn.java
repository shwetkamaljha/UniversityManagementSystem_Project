package university.management.system;
import java.sql.*;
public class Conn {
    Connection c; //Here Connection is a interface comes under the sql package.
    Statement s; //Statement is Interface
    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //It is the address of mysql database driver.
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","@Shekhu1");
            s = c.createStatement(); // With the help of statement we can execute mysql querries.
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
