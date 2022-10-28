package UiLayer;
import MiddleLayer.CallAccountProcessor;

public class Dashboard {

    CallAccountProcessor callAccountProcessorObj =new CallAccountProcessor();

    public int enterProcess()
    {
        System.out.println("if u want add money--->1");
        System.out.println("if u want check balance--->2");
        System.out.println("if u want withdraw money--->3");
        System.out.println("if u want to change ur password--->4");
        System.out.println("exit----->5");
        System.out.println("_______________________________");
        OnlyInt onlyIntObj=new OnlyInt();
        int a=onlyIntObj.onlyInt();
        if(a>0&&a<6) {
            return a;
        }
        else {
            System.out.println("Please enter valid process");
            System.out.println("___________________________");
            return enterProcess();
        }
    }
    public void enterDepositAmount(int idNumber)
    {
        System.out.println("Please enter amount you deposit");
        OnlyInt onlyIntObj=new OnlyInt();
        int depositAmount =onlyIntObj.onlyInt();
        callAccountProcessorObj.addMoney(depositAmount, idNumber);
        System.out.println("Successfully deposited");
    }
    public void enterWithdrawAmount(int idNumber)
    {
        System.out.println("Please enter how much money u want");
        OnlyInt onlyIntObj=new OnlyInt();
        int withdrawAmount= onlyIntObj.onlyInt();
        callAccountProcessorObj.withdraw(withdrawAmount, idNumber);
    }
    public void enterChangePassword(int idNumber)
    {
        EnterRegisterDetails enterRegisterDetailsObj=new EnterRegisterDetails();
        System.out.println("Please Enter Your new Password");
        String newPass=enterRegisterDetailsObj.enterPassword();
        callAccountProcessorObj.changePass(newPass,idNumber);

        System.out.println("The password is set Successfully");
        System.out.println("_________________________________");
    }
    public void accountBalance(int idNumber)
    {
        System.out.println("Your account Balance is " + callAccountProcessorObj.accountBalance(idNumber) );
    }
    public void ifWithdrawGreaterBalance(long accountBalance)
    {
        System.out.println("Your account balance is less than your Account balance,Account balance : "+accountBalance);
    }
    public void ifWithdrawLesserBalance()
    {
        System.out.println("Withdraw Successful");
        System.out.println("_________________________________");

    }
}
