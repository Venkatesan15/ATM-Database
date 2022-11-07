package ExtraFeatures.UiLayer1;

import ExtraFeatures.DataLayer1.SeeCreditCard;
import ExtraFeatures.MiddleLayer1.IsUserHaveCC;

import java.sql.ResultSet;

public class GetCreditCardDetails {
    public static void getCreditCardDetails(int userId)
    {
        SeeCreditCard seeCreditCardObj=new SeeCreditCard();
        ResultSet rs=seeCreditCardObj.seeCreditCard(userId);

        if(IsUserHaveCC.isUserHaveCC(userId)) {
            try {
                rs.next();
                System.out.println("***********************************");
                System.out.println("Credit card Number : " + rs.getLong("cardNumber"));
                System.out.println("Expiry Date : " + rs.getString("expiryDate"));
                System.out.println("cvv : " + rs.getInt("cvv"));
                System.out.println("Aadhar card Number : " + rs.getLong("aadharNumber"));
                System.out.println("************************************");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("Please First apply for credit Card");
        }
    }
}
