package MiddleLayer;

import DataLayer.SaveTransactions;


public class TransactionHistory {
    public void transactionHistory(int userId,String debitOrCredit,long amount)
    {
        String todayDate=GetTodayDate.getTodayDate();

        SaveTransactions.saveTransactions(userId, todayDate,debitOrCredit,amount);
    }
}
