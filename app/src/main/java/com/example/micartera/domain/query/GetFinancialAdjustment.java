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
}
