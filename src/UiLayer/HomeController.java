package UiLayer;


public class HomeController {
    RegisterPage registerPageObj =new RegisterPage();
    LoginController loginControllerObj =new LoginController();
    OnlyInt onlyIntObj=new OnlyInt();
    int enterRegOrLoginOrExitByUser;
    public void regOrLoginOrExitByUser(){
        enterRegOrLoginOrExitByUser=1;

        while (enterRegOrLoginOrExitByUser == 1 || enterRegOrLoginOrExitByUser == 2) {
            System.out.println("_______________________________");
            System.out.println("Register--->1");
            System.out.println("Login------>2");
            System.out.println("Exit------->3");
            System.out.println("_______________________________");
            enterRegOrLoginOrExitByUser =onlyIntObj.onlyInt();
            if (enterRegOrLoginOrExitByUser == 1) {
                registerPageObj.register();
            } else if (enterRegOrLoginOrExitByUser == 2) {
                loginControllerObj.checkAccount();
            }
        }
        if (enterRegOrLoginOrExitByUser == 3)
        {
            System.out.println("Thank You for using our ATM");
            System.out.println("HAVE A GOOD DAY");
        }
        if(enterRegOrLoginOrExitByUser>3)
        {
            System.out.println("Please enter valid process");
            regOrLoginOrExitByUser();
        }
    }
}
