package Validator;
import DataLayer.SetRegisterDetails;
import UiLayer.EnterRegisterDetails;
import Validator.Validator;

import static java.lang.String.*;

public class CreationValidator implements Validator
{
    public boolean checkValidPassword(String pass,String reEnterPass)
    {
        if(!(pass.equals(reEnterPass)))
        {
            return  false;
        }
        return true;
    }
    public boolean checkValidGender(int gender)
    {
        if(gender==1||gender==2||gender==3) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkValidPhoneNumber(String phoneNumber)
    {
        SetRegisterDetails setRegisterDetailsObj=new SetRegisterDetails();
        EnterRegisterDetails enterRegisterDetailsObj=new EnterRegisterDetails();


        int c=1,c1;
        c1=isPhNoHaveTenDigit(phoneNumber);

        if(setRegisterDetailsObj.isPhNoAlreadyRegistered(phoneNumber))
        {
            enterRegisterDetailsObj.ifPhoneNumberAlreadyInRegisteredList();
            c=0;
        }
        if(c==0||c1==0)
        {
            return false;
        }
        else
            return true;
    }
    public int isPhNoHaveTenDigit(String phoneNumber)
    {
        int c1=0;
        int numberCount=0;
        char[] arr =phoneNumber.toCharArray();
        try {
            for (int i=0;i<arr.length;i++) {
                int i1 = Integer.parseInt(valueOf(arr[i]));
                if (i1>=0 && i1<=9) {
                    numberCount++;
                }
            }
        }
        catch (Exception e)
        {

        }
        if((phoneNumber.length()==10)&&numberCount==10) {
            c1 = 1;
        }
        return c1;
    }
    public boolean checkValidAge(int age)
    {
        if(age>17&&age<200) {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean checkValidName(String name)
    {
        if(name.length()==0)
        {
            return false;
        }
        int upperCaseCountInName=0;
        for(char i:name.toCharArray())
        {
            if((i>=65&&i<=90)||i==' ')
            {
                upperCaseCountInName++;
            }
        }
        if(upperCaseCountInName==name.length()) {
            return true;
        }
        else
        {
           return false;
        }

    }
}
