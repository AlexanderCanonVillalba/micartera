package com.example.micartera.domain.query;

public class GetFinancialAdjustment {
    private int accountID ;
    private int userID ;
    private int period;

    public GetFinancialAdjustment(int accountID,int userID,int period){
        this.accountID = accountID;
        this.userID =  userID;
        this.period = period;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }


}
