package com.example.micartera.core;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.port.Repository;

public class SaveAccount {

    private Repository repository;

    public SaveAccount(Repository repository){
        this.repository = repository;
    }

    public void Execute(Account account){
        this.repository.addAccount(account);
    }
}
