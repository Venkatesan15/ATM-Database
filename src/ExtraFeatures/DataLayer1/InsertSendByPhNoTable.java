package ExtraFeatures.DataLayer1;

import DataLayer.Jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertSendByPhNoTable {
    public void insertSendByPhNoTable(String fromPhoneNumber,String toPhoneNumber,String todayDate,long amountSent)
    {
         try
         {
             String query="INSERT INTO sendMoneyByPhNo(fromPhoneNumber,toPhoneNumber,todayDate,amountSent) VALUES(?,?,?,?)";
             Connection con= Jdbc.getConnection();
             PreparedStatement stm=con.prepareStatement(query);
             stm.setString(1,fromPhoneNumber);
             stm.setString(2,toPhoneNumber);
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
