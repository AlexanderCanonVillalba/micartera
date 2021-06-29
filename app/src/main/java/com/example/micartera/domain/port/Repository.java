package com.example.micartera.domain.port;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.entity.FinancialDetails;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.util.List;

public interface Repository {
    public List<FinancialAdjustment> GetTotals(GetFinancialAdjustment query);
    public  List<FinancialAdjustment> GetDetails(GetFinancialAdjustment query);
    public  int addFinancialAdjustment(Account account);
    public  void addAccount(Account account);
}
