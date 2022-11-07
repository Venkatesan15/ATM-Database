package ExtraFeatures.MiddleLayer1;

import ExtraFeatures.DataLayer1.SeeProfileDL;

import java.sql.ResultSet;

public class GetUserProfile {
    public static ResultSet getUserProfile(int userId)
    {
        SeeProfileDL seeProfileDLObj = new SeeProfileDL();
        ResultSet rs = seeProfileDLObj.seeProfileDL(userId);
        return rs;
    }
}
