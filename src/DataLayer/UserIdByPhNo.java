package DataLayer;

import java.sql.*;


public class UserIdByPhNo {
    public int getId(String phNo,String pass)
    {
        Jdbc jdbcObj=new Jdbc();
        Connection con=jdbcObj.getConnection();
        int id=0;
        String query="SELECT userId FROM userDetails WHERE userPhoneNumber='"+phNo+"' AND userPassword='"+pass+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            id=rs.getInt("userId");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return id;
    }
}
