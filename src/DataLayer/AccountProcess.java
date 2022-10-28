package DataLayer;
import java.sql.*;
public class AccountProcess implements InterAccountProcess{
    Jdbc jdbc=new Jdbc();
    Connection con=jdbc.getConnection();
    public int getId(String phNo,String pass)
    {
        int id=0;
        String query="SELECT ID FROM ATMDATABASE WHERE phoneNumber='"+phNo+"' AND userPassword='"+pass+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            id=rs.getInt("ID");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return id;
    }
    public void addMoney(int depositAmount,int id)
    {
        String query ="UPDATE ATMDATABASE SET accountBalance=accountBalance+'"+depositAmount+"' WHERE ID='"+id+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void getWithdraw(int withdrawAmount,int id)
    {
        String query ="UPDATE ATMDATABASE SET accountBalance=accountBalance-'"+withdrawAmount+"' WHERE ID='"+id+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public long getAccountBalanceInJdbc(int id)
    {
        String query="SELECT accountBalance FROM ATMDATABASE WHERE ID='"+id+"'";
        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            return rs.getLong("accountBalance");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }

    public void changePassword(String newPass,int id)
    {
        String query ="UPDATE ATMDATABASE SET userPassword='"+newPass+"' WHERE ID='"+id+"'";
        try {
            Statement st = con.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
