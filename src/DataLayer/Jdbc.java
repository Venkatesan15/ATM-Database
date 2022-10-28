
package DataLayer;
import java.sql.*;
public class Jdbc {
    public static Connection con;
    public Jdbc(){
        try
        {
            String url = "jdbc:mysql://localhost:3306/ATM";
            String un = "root";
            String pass = "Jayaramang@1";
            con = DriverManager.getConnection(url, un, pass);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public Connection getConnection()
    {
        return con;
    }

}
