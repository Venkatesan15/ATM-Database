package MiddleLayer;

import DataLayer.*;
import UiLayer.LoginController;
import Validator.OnlyInt;

public class SendMoneyByPhAndAccNo {
    public void sendMoneyByPhNo(int userId)
    {
        int res=0;
        int amount = 0;
        System.out.println("please enter phone number to send ");
        String toPhoneNumber;
        //Get Ten digit Phone Number from login Controller;
        LoginController loginControllerObj=new LoginController();
        toPhoneNumber =loginControllerObj.enterPhoneNumber();



        if(IsPhNoRegistered.isPhNoRegistered(toPhoneNumber)) {
            GetAccountHolderName getAccountHolderNameObj=new GetAccountHolderName();
            System.out.println();
            System.out.println("ACCOUNT HOLDER NAME : "+getAccountHolderNameObj.getAccHolderNameByPhNo(toPhoneNumber));
            System.out.println();
            System.out.println("How much money want to send below 50000");
            amount = OnlyInt.onlyIntBelowFiftyTh();
            SendMoneyDL sendMoneyDLObj = new SendMoneyDL();
            res=sendMoneyDLObj.sendMoney(userId, amount,"Phone Number : '"+ toPhoneNumber +"'");
        }
        else {
            System.out.println("This phone Number have no account");
        }
        if(res==1)
        {
            String fromPhoneNumber= GetPhNoByID.getPhNoById(userId);
            String todayDate= GetTodayDate.getTodayDate();

            InsertSendByPhNoTable insertSendByPhNoTableObj=new InsertSendByPhNoTable();
            insertSendByPhNoTableObj.insertSendByPhNoTable(fromPhoneNumber,toPhoneNumber,todayDate,amount);

            CreditToSendAccount creditToSendAccount=new CreditToSendAccount();
            creditToSendAccount.creditToSendAccountByPhNo(toPhoneNumber,amount,userId);

        }
    }
    public void sendMoneyByAccNo(int userId)
    {
        int res=0;
        System.out.println("Please enter Account number 14 Digits");
        EnterAccNo enterAccNo=new EnterAccNo();

        String accountNumber=enterAccNo.enterAccNo();
        int amount = 0;


        IsAccNoReg isAccNoRegObj=new IsAccNoReg();

        if(isAccNoRegObj.isAccNoReg(accountNumber)) {

            GetAccountHolderName getAccountHolderNameObj=new GetAccountHolderName();
            System.out.println("ACCOUNT HOLDER NAME : "+getAccountHolderNameObj.getAccHolderNameByAccNo(accountNumber));
            System.out.println();
            System.out.println("How much money want to send below 50000");
            amount=OnlyInt.onlyIntBelowFiftyTh();
            SendMoneyDL sendMoneyDLObj = new SendMoneyDL();
            res=sendMoneyDLObj.sendMoney(userId, amount,"Account NUmber : '"+accountNumber+"'");
        }
        else
        {
            System.out.println("This account Number is Not Valid Check again");
        }
        if(res==1)
        {
            String fromAccountNumber= GetAccNoById.getAccNoById(userId);
            String todayDate= GetTodayDate.getTodayDate();

            InsertIntoSendByAccNoTable insertIntoSendByAccNoTableObj=new InsertIntoSendByAccNoTable();
            insertIntoSendByAccNoTableObj.insertIntoSendByAccNoTable(fromAccountNumber,accountNumber,todayDate,amount);

            CreditToSendAccount creditToSendAccount=new CreditToSendAccount();
            creditToSendAccount.creditToSendAccountByAccNo(accountNumber,amount,userId);

        }

    }
}
