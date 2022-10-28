package DataLayer;

public interface InterAccountProcess {
    int getId(String phNo, String pass);
    void addMoney(int depositAmount,int id);
    void getWithdraw(int withdrawAmount,int id);
    long getAccountBalanceInJdbc(int id);
    void changePassword(String newPass,int id);
}