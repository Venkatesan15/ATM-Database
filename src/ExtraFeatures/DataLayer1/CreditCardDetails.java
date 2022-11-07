package ExtraFeatures.DataLayer1;

import DataLayer.Jdbc;

import java.sql.*;

public class CreditCardDetails {
    public void creditCardDetails(int userId,String userPhoneNumber,String aadharNumber,long creditCardNumber,int cvv,String expiryDate){
        Jdbc jdbcObj=new Jdbc();
        Connection con= jdbcObj.getConnection();
        try {
            String query = "INSERT INTO creditCard(userId,userPhoneNumber,aadharNumber,cardNumber,cvv,expiryDate) VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, userId);
            st.setString(2, userPhoneNumber);
            st.setString(3, aadharNumber);
            st.setLong(4, creditCardNumber);
            st.setInt(5, cvv);
            st.setString(6, expiryDate);
            st.executeUpdate();
            System.out.println("Applied successfully");
        }
        catch (Exception e)
        {

        }

    }
    public int checkCreditCardAlreadyExits(int userId)
    {
        //Jdbc jdbcObj=new Jdbc();
        Connection con= Jdbc.getConnection();
        int a=0;
        try
        {
            String query="SELECT EXISTS(SELECT * FROM creditCard WHERE userId='"+userId+"') as res";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            rs.next();
            a=rs.getInt("res");
            return a;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return a;
    }
}
