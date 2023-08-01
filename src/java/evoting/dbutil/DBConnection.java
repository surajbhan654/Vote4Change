package evoting.dbutil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn;
    static{
        try{
           Class.forName("oracle.jdbc.OracleDriver"); //load driver
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-NQL64O9:1521/XE","advjavabatch","mystudents");
            System.out.println("Connection opend successfully");
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Cannot load the driver","ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problem in Db","ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            if(conn!=null)
                conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cannot Close the connection","ERROR",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}