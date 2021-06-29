package com.example.micartera.core;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.infrastructure.repository.realm.RealmRepository;

public class SaveFinancialAdjustment {

    private Repository repository;

    public SaveFinancialAdjustment(Repository repository){
        this.repository =  repository;
    }

    public int Execute(Account account){
        repository.addFinancialAdjustment(account);
        return  0;
    }
}
