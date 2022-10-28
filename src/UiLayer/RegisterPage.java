package UiLayer;

import MiddleLayer.SaveRegisterDetails;


public class RegisterPage {

    public void register(){
        String name;
        int age;
        String gender;
        String phoneNumber;
        String password;

        EnterRegisterDetails enterRegisterDetailsObj=new EnterRegisterDetails();


        name= enterRegisterDetailsObj.enterName();
        age= enterRegisterDetailsObj.enterAge();
        gender= enterRegisterDetailsObj.selectGender();
        phoneNumber= enterRegisterDetailsObj.enterPhoneNumber();
        password= enterRegisterDetailsObj.enterPassword();

        SaveRegisterDetails saveRegisterDetailsObj=new SaveRegisterDetails();
        saveRegisterDetailsObj.saveRegisterDetails(name,age,gender,phoneNumber,password);

        System.out.println("Registration Successful");
    }
}
