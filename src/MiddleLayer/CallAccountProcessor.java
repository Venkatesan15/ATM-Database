package MiddleLayer;
import DataLayer.AccountProcess;
import DataLayer.InterAccountProcess;
import UiLayer.Dashboard;
public class CallAccountProcessor {
    InterAccountProcess accountProcessObj =new AccountProcess();
    public  int getId(String phoneNumber,String password)
    {
        return accountProcessObj.getId(phoneNumber,password);
    }

    public void addMoney(int depositAmount, int idNumber)
    {
        accountProcessObj.addMoney(depositAmount,idNumber);

    }
    public void withdraw(int withdrawAmount,int idNumber)
    {
        Dashboard dashboardObj=new Dashboard();
        long accountBalance= accountProcessObj.getAccountBalanceInJdbc(idNumber);

        if(withdrawAmount>accountBalance)
            dashboardObj.ifWithdrawGreaterBalance(accountBalance);
        else {
            dashboardObj.ifWithdrawLesserBalance();
            accountProcessObj.getWithdraw(withdrawAmount,idNumber);
        }
    }
    public long accountBalance(int ID)
    {
        return accountProcessObj.getAccountBalanceInJdbc(ID);
    }
    public void changePass(String pass,int id)
    {
        accountProcessObj.changePassword(pass,id);
    }
}
