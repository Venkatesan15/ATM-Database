package UiLayer;

import MiddleLayer.GenerateAccountNo;
import MiddleLayer.SaveRegisterDetails;


public class RegisterPage {

    public void register(){
        String name;
        int age;
        String gender;
        String phoneNumber;
        String password;
        long accountNumber;

        EnterRegisterDetails enterRegisterDetailsObj=new EnterRegisterDetails();


        name= enterRegisterDetailsObj.enterName();
        age= enterRegisterDetailsObj.enterAge();
        gender= enterRegisterDetailsObj.selectGender();
        phoneNumber= enterRegisterDetailsObj.enterPhoneNumber();
        password= enterRegisterDetailsObj.enterPassword();
        accountNumber= GenerateAccountNo.generateAccNo();

        System.out.println("Your account Number : "+accountNumber);

        SaveRegisterDetails saveRegisterDetailsObj=new SaveRegisterDetails();
        saveRegisterDetailsObj.saveRegisterDetails(name,age,gender,phoneNumber,password,accountNumber);

        System.out.println("Registration Successful");
    }
}
