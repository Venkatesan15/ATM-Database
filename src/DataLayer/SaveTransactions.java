package DataLayer;

import java.sql.*;

public class SaveTransactions {
    public static void saveTransactions(int userId,String todayDate,String debitOrCredit,long amount)
    {

        Connection con=Jdbc.getConnection();
        try {
            String query1="SELECT userAccountBalance FROM userDetails WHERE userId='"+userId+"'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query1);
            rs.next();
            long accBalance=rs.getLong("userAccountBalance");

            String query = "INSERT INTO transactionHistory(userId,transactionDate,debitOrCredit,amount,accountBalance) VALUES(?,?,?,?,?)";
            PreparedStatement st =con.prepareStatement(query);
            st.setInt(1,userId);
            st.setString(2,todayDate);
            st.setString(3,debitOrCredit);
            st.setLong(4,amount);
            st.setLong(5,accBalance);
            st.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
