package ExtraFeatures.MiddleLayer1;

import ExtraFeatures.DataLayer1.SeeCreditCard;

public class IsUserHaveCC {//When user click see Credit card details then check the user have credit card or not;
    public static boolean isUserHaveCC(int userId)
    {
        if(SeeCreditCard.isAccountHaveCC(userId)==1)
        {
            return true;
        }
        return false;
    }
}
