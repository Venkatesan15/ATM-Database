package ExtraFeatures.MiddleLayer1;

import ExtraFeatures.DataLayer1.CreditCardDetails;

public class SaveCCDetails {
    public void saveCreditCardDetails(int userId,String userPhoneNumber,String aadharNumber,long creditCardNumber,int cvv,String expiryDate)
    {
        CreditCardDetails creditCardDetailsObj=new CreditCardDetails();
        creditCardDetailsObj.creditCardDetails(userId,userPhoneNumber,aadharNumber,creditCardNumber,cvv,expiryDate);
    }
}
