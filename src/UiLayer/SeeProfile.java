package UiLayer;

import MiddleLayer.GetUserProfile;

import java.sql.ResultSet;

public class SeeProfile {
    public void seeProfile(int userId)
    {
        try {
            ResultSet rs=GetUserProfile.getUserProfile(userId);
            rs.next();
            System.out.println("********************************************************");
            System.out.println("Name : "+rs.getString("userName"));
            System.out.println("Age : "+rs.getInt("userAge"));
            System.out.println("Gender : "+rs.getString("userGender"));
            System.out.println("Phone Number : "+rs.getString("userPhoneNumber"));
            System.out.println("Account Number : "+rs.getLong("userAccountNumber"));
            System.out.println("**********************************************************");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}



