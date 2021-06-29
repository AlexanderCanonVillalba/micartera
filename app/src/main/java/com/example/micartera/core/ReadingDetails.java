package com.example.micartera.core;

import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.util.List;

public class ReadingDetails {

    private Repository repository ;

    public ReadingDetails(Repository repository){
        this.repository = repository;
    }

    public  List<FinancialAdjustment> Execute(GetFinancialAdjustment query){
        List<FinancialAdjustment> list =  this.repository.GetDetails(query);
        return list;
    }
}
