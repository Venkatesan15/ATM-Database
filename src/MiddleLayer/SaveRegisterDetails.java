package MiddleLayer;
import DataLayer.InterSetRegisterDetail;
import DataLayer.SetRegisterDetails;
public class SaveRegisterDetails {
    public void saveRegisterDetails(String name,int age,String gender,String phoneNumber,String password){
        InterSetRegisterDetail setRegisterDetailsObj=new SetRegisterDetails();
        setRegisterDetailsObj.setRegisterDetails(name,age,gender,phoneNumber,password,0);
    }
}
