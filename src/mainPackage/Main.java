package mainPackage;
//import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{


    

    class Administrator{
        String role;
        String name;
        String email;
        int adminid;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException{

       Class.forName("com.mysql.cj.jdbc.Driver");
       
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Echo215555$");
       System.out.println("Connection created");
    }
}
