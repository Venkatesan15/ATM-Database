package MiddleLayer;
import DataLayer.InterSetRegisterDetail;
import Main.User;
import DataLayer.SetRegisterDetails;
public class SaveRegisterDetails {
    public void saveRegisterDetails(User user){
        InterSetRegisterDetail setRegisterDetailsObj=new SetRegisterDetails();
        setRegisterDetailsObj.setRegisterDetails(user);
    }
}
