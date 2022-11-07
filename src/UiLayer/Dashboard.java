package UiLayer;
import MiddleLayer.CallAtmProcesses;

public class Dashboard {

    CallAtmProcesses callAtmProcessesObj =new CallAtmProcesses();

    public int enterProcess()
    {
        System.out.println("if u want add money--------------->1");
        System.out.println("if u want check balance----------->2");
        System.out.println("if u want withdraw money---------->3");
        System.out.println("if u want to change ur password--->4");
        System.out.println("if u want send Money to anyone---->5");
        System.out.println("if u want to apply credit card---->6");
        System.out.println("See transaction history------------>7");
        System.out.println("See credit Card details------------>8");
        System.out.println("See profile------------------------>9");
        System.out.println("exit------------------------------->10");
        System.out.println("***************************************");
        OnlyInt onlyIntObj=new OnlyInt();
        int a=onlyIntObj.onlyInt();
        if(a>0&&a<11) {
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
        callAtmProcessesObj.addMoney(depositAmount, idNumber);
        System.out.println("Successfully deposited");
    }
    public void enterWithdrawAmount(int idNumber)
    {
        System.out.println("Please enter how much money u want");
        OnlyInt onlyIntObj=new OnlyInt();
        int withdrawAmount= onlyIntObj.onlyInt();
        callAtmProcessesObj.withdraw(withdrawAmount, idNumber);
    }
    public void enterChangePassword(int idNumber)
    {
        EnterRegisterDetails enterRegisterDetailsObj=new EnterRegisterDetails();
        System.out.println("Please Enter Your new Password");
        String newPass=enterRegisterDetailsObj.enterPassword();
        callAtmProcessesObj.changePass(newPass,idNumber);

        System.out.println("The password is set Successfully");
        System.out.println("_________________________________");
    }
    public void accountBalance(int idNumber)
    {
        System.out.println("Your account Balance is " + callAtmProcessesObj.accountBalance(idNumber) );
    }
    public void ifWithdrawGreaterBalance(long accountBalance)
    {
        System.out.println("Your account balance is less than debit amount,Account balance : "+accountBalance);
    }
    public void ifWithdrawLesserBalance()
    {
        System.out.println("Withdraw/debit Successful");
        System.out.println("_________________________________");

    }
}
