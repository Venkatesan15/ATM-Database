package ExtraFeatures.MiddleLayer1;

import ExtraFeatures.DataLayer1.SaveTransactions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TransactionHistory {
    public void transactionHistory(int userId,String debitOrCredit,long amount)
    {
        Date date=new Date();
        SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
        String date1=d.format(date);
        LocalDate todayDate=LocalDate.parse(date1);

        SaveTransactions.saveTransactions(userId, String.valueOf(todayDate),debitOrCredit,amount);
    }
}
