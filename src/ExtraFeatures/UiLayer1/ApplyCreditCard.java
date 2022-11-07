package ExtraFeatures.UiLayer1;
import ExtraFeatures.MiddleLayer1.EnterAadharNumber;
import ExtraFeatures.MiddleLayer1.GenerateCreditCard;
import ExtraFeatures.MiddleLayer1.IsAccAlreadyHaveCC;
import ExtraFeatures.MiddleLayer1.SaveCCDetails;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class ApplyCreditCard {

    public  void applyCreditCard(int userId,String userPhoneNumber)
    {

        IsAccAlreadyHaveCC isAccAlreadyHaveCCObj=new IsAccAlreadyHaveCC();

        if(isAccAlreadyHaveCCObj.isAccAlreadyHaveCC(userId)==1)
        {
            System.out.println("This Account already have an Credit Card");
            System.out.println();
            return;
        }

        String aadharNumber;
        long creditCardNumber;
        Date date;
        String expiryDate;
        int cvv;


        EnterAadharNumber enterAadharNumberObj=new EnterAadharNumber();
        aadharNumber=enterAadharNumberObj.aadharNumber();
        creditCardNumber= GenerateCreditCard.generateCreditCardNumber();
        cvv= GenerateCreditCard.generateCVV();
        date=new Date();

        SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");
        String d=dateForm.format(date);

        LocalDate todayDate=LocalDate.parse(d);
        int expiryYear=todayDate.getYear()+5;
        int month=todayDate.getMonthValue();

        expiryDate= String.valueOf(month)+"-"+String.valueOf(expiryYear);


        SaveCCDetails saveCCDetailsObj=new SaveCCDetails();
        saveCCDetailsObj.saveCreditCardDetails(userId,userPhoneNumber,aadharNumber,creditCardNumber,cvv,expiryDate);

        System.out.println();
        System.out.println("*********************************");
        System.out.println("Credit Card N0 : "+creditCardNumber);
        System.out.println("CVV no : "+cvv);
        System.out.println("Expiry Date : "+expiryDate);
        System.out.println("*********************************");
        System.out.println();

    }

}
