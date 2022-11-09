package UiLayer;

import DataLayer.SeeTransactions;

import java.sql.*;

public class GetTransactionDetails {
    public static void getTransactionDetails(int userId)
    {
        SeeTransactions seeTransactionsObj=new SeeTransactions();
        ResultSet rs=seeTransactionsObj.seeTransactions(userId);
        int count=1;
        try {
            while (rs.next()) {
                System.out.println("***************************************");
                System.out.println("S.NO   : " + count);
                System.out.println("Date   : " + rs.getString("transactionDate"));
                System.out.println("Status : " + rs.getString("debitOrCredit"));
                System.out.println("Amount : " + rs.getString("amount"));
                System.out.println("Account Balance : " + rs.getLong("accountBalance"));
                System.out.println("****************************************");
                count++;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
