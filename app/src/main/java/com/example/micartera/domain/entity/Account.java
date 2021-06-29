package com.example.micartera.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {

    int id;
    int accountID ;
    int userID ;
    String nameAccount ;



    public void setListFinancialAdjustment(List<FinancialAdjustment> listFinancialAdjustment) {
        this.listFinancialAdjustment = listFinancialAdjustment;
    }

    List<FinancialAdjustment> listFinancialAdjustment ;

    public Account( int accountID,int userID, int id, String nameAccount){
        this.accountID =  accountID;
        this.userID = userID;
        this.id = id;
        this.nameAccount = nameAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public List<FinancialAdjustment> getListFinancialAdjustment() {
        return listFinancialAdjustment;
    }

    public void addFinancialAdjustment(FinancialAdjustment financialAdjustment) {
        if (this.listFinancialAdjustment == null){
            listFinancialAdjustment =  new ArrayList<>();
        }
        this.listFinancialAdjustment.add(financialAdjustment);
    }


    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

}
