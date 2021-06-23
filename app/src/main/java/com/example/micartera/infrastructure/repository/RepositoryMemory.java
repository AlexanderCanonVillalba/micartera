package com.example.micartera.infrastructure.repository;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.entity.FinancialDetails;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMemory implements Repository {

    @Override
    public List<FinancialDetailsSimple> GetTotals(GetFinancialAdjustment query) {

        List<FinancialDetailsSimple> listFinancialDetailsSimple =  new ArrayList<>();
        Account account =  new Account(1 , 1234);
        for (int i = 0; i < 3; i++){
            FinancialDetailsSimple financialDetailsSimple =  new FinancialDetailsSimple(
                    3000 , 2000 , 4+i , 2021);
           listFinancialDetailsSimple.add(financialDetailsSimple);
        }
        return listFinancialDetailsSimple;
    }

}
