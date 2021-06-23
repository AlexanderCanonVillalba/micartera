package com.example.micartera.core;

import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.util.ArrayList;
import java.util.List;

public class ReadingTotals {
    private Repository repository;

    public ReadingTotals(Repository repository){
        this.repository = repository;
    }

    public List<FinancialDetailsSimple> Execute(GetFinancialAdjustment query){
        List<FinancialDetailsSimple> listFinancialDetailsSimple = new ArrayList<>();
        try {
            listFinancialDetailsSimple =  repository.GetTotals(query);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

       return listFinancialDetailsSimple;
    }
}
