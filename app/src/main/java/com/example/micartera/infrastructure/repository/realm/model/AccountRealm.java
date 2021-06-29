package com.example.micartera.infrastructure.repository.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AccountRealm extends RealmObject {
   @PrimaryKey
    int id;
    int accountID ;
    int userID ;
    String nameAccount;

    private RealmList<FinancialAdjustmentRealm> financialAdjustmentRealm;

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

    public RealmList<FinancialAdjustmentRealm> getFinancialAdjustmentRealm() {
        return financialAdjustmentRealm;
    }

    public void addFinancialAdjustmentRealm(FinancialAdjustmentRealm financialAdjustmentRealm) {
        if (this.financialAdjustmentRealm == null){
            this.financialAdjustmentRealm = new RealmList<>();
        }
        this.financialAdjustmentRealm.add(financialAdjustmentRealm);
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }
}
