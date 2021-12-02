import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/e2datat", "root", "");
        PreparedStatement p=con.prepareStatement("Insert into info values(?,?)");
       try {
           Scanner sc = new Scanner(System.in);
           String str=sc.nextLine();
           Pattern s =Pattern.compile("[0|91]?[96][0-9]{9}");
           Pattern s1=Pattern.compile("[a-zA-Z0-9._]+@gmail.com");
           Matcher m=s.matcher(str);
           Matcher m1=s1.matcher(str);
           String str1=null;
           String str2=null;
           int c=0;
           if (m.find()){
               str1=m.group();
               c++;
           }
           if (m1.find()){
               str2 =m1.group();
               c++;
           }
           if(str1==null || str2==null||c<2){
                    throw new Exception("Invalid data exception");
           }
           else{
               p.setString(1,str1);
               p.setString(2,str2);
               p.executeUpdate();
           }}
           catch(Exception e){
               System.out.println(e);
           }
       con.close();

       }
    }






