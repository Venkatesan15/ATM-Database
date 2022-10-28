package DataLayer;
import java.sql.*;
public class SetRegisterDetails implements InterSetRegisterDetail{
    Jdbc jdbcObj=new Jdbc();
    Connection con=jdbcObj.getConnection();
    public void setRegisterDetails(String name,int age,String gender,String phoneNumber,String password,long accountBalance){
        try
        {
            String query ="INSERT INTO ATMDATABASE(userName,age,gender,phoneNumber,userPassword,accountBalance) VALUES(?,?,?,?,?,?)";
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1,name);
            stm.setInt(2,age);
            stm.setString(3,gender);
            stm.setString(4,phoneNumber);
            stm.setString(5,password);
            stm.setLong(6,accountBalance);
            stm.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public boolean isPhNoAlreadyRegistered(String phNo)
    {
        String query="SELECT EXISTS(SELECT * FROM ATMDATABASE WHERE phoneNumber='"+phNo+"') AS RESULT";
        int result=1;
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            if(rs==null)
                return false;
            rs.next();
            result=rs.getInt("RESULT");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(result==1) {
            return true;
        }
        return false;
    }
}
