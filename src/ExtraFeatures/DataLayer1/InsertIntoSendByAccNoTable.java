package ExtraFeatures.DataLayer1;

import DataLayer.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertIntoSendByAccNoTable {
    public void insertIntoSendByAccNoTable(String fromAccountNumber,String toAccountNumber,String todayDate,long amountSent)
    {
        try
        {
            String query="INSERT INTO sendMoneyByAccNo(fromAccountNumber,toAccountNumber,todayDate,amountSent) VALUES(?,?,?,?)";
            Connection con= Jdbc.getConnection();
            PreparedStatement stm=con.prepareStatement(query);
            stm.setString(1,fromAccountNumber);
            stm.setString(2,toAccountNumber);
            stm.setString(3,todayDate);
            stm.setLong(4,amountSent);
            stm.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
