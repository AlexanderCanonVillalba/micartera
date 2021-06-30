package com.example.micartera.infrastructure.repository;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.entity.FinancialDetails;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.security.cert.CertPath;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositoryMemory implements Repository {


    @Override
    public List<FinancialAdjustment> GetTotals(GetFinancialAdjustment query) {
        return null;
    }

    @Override
    public List<FinancialAdjustment> GetDetails(GetFinancialAdjustment query) {
        List<FinancialAdjustment> details  = new ArrayList<>();
        long  millis = System.currentTimeMillis ();
        Date date = new Date(millis);
        for (int i=0; i<10 ; i++){
            System.out.println("repository");
            FinancialAdjustment financialAdjustment = new FinancialAdjustment(4000,2, "MERCADO", "Compra en el ara", date);
            details.add(financialAdjustment);
        }

        return details;
    }

    @Override
    public int addFinancialAdjustment(Account account) {
        return 0;
    }

    @Override
    public void addAccount(Account account) {

    }

}
