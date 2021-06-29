package com.example.micartera.core;

import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

public class ReadingTotals {
    private Repository repository;

    public ReadingTotals(Repository repository){
        this.repository = repository;
    }

    public List<FinancialDetailsSimple> Execute(GetFinancialAdjustment query){
        List<FinancialDetailsSimple> listFinancialDetailsSimple =  new ArrayList<>();
        List<FinancialAdjustment> listFinancialAdjustment = new ArrayList<>();
        int mes1 , mes2, mes3 = 0;

        Calendar calendar = Calendar.getInstance();
        mes1 = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.MONTH , -1);
        mes2 = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.MONTH, -1);
        mes3 = calendar.get(Calendar.MONTH);
        System.out.println("validando tipo use case...." + mes1 + "....." + mes2 + "........." + mes3);

        try {
            listFinancialAdjustment =  repository.GetTotals(query);
            FinancialDetailsSimple  financialDetailsSimpleUno = new FinancialDetailsSimple(),
                    financialDetailsSimpleDos = null,
                    financialDetailsSimpleTres = null;

            for (FinancialAdjustment financialAdjustment: listFinancialAdjustment){
              Calendar  dateFinancialAdjustment =  Calendar.getInstance();
                dateFinancialAdjustment.setTime(financialAdjustment.getDate());
                    if(dateFinancialAdjustment.get(Calendar.MONTH) == mes1){
                        if (financialAdjustment.getAdjustmentType() == 1){
                            financialDetailsSimpleUno.setTotalExpense(financialDetailsSimpleUno.GetTotalExpense()+ financialAdjustment.getValue());
                        }else {
                            financialDetailsSimpleUno.setTotalIncome(financialDetailsSimpleUno.GetTotalIncome()+ financialAdjustment.getValue());
                        }
                        financialDetailsSimpleUno.setMonth(mes1);
                        financialDetailsSimpleUno.setYear(dateFinancialAdjustment.get(Calendar.YEAR));
                    }else if (dateFinancialAdjustment.get(Calendar.MONTH) == mes2){
                        System.out.println("validancion item 2......" + dateFinancialAdjustment.get(Calendar.MONTH) + "...../ " + financialAdjustment.getDate() + "......" + mes2);
                        if (financialDetailsSimpleDos == null) {
                            financialDetailsSimpleDos =  new FinancialDetailsSimple();
                        }
                        if (financialAdjustment.getAdjustmentType() == 1){
                            financialDetailsSimpleDos.setTotalExpense(financialDetailsSimpleDos.GetTotalExpense()+ financialAdjustment.getValue());
                        }else {
                            financialDetailsSimpleDos.setTotalIncome(financialDetailsSimpleDos.GetTotalIncome()+ financialAdjustment.getValue());
                        }
                        financialDetailsSimpleDos.setMonth(mes2);
                        financialDetailsSimpleDos.setYear(dateFinancialAdjustment.get(Calendar.YEAR));
                    }else {
                        if (financialDetailsSimpleTres == null) {
                            financialDetailsSimpleTres =  new FinancialDetailsSimple();
                        }
                        if (financialAdjustment.getAdjustmentType() == 1){
                            financialDetailsSimpleTres.setTotalExpense(financialDetailsSimpleTres.GetTotalExpense()+ financialAdjustment.getValue());
                        }else {
                            financialDetailsSimpleTres.setTotalIncome(financialDetailsSimpleTres.GetTotalIncome()+ financialAdjustment.getValue());
                        }
                        financialDetailsSimpleTres.setMonth(mes3);
                        financialDetailsSimpleTres.setYear(dateFinancialAdjustment.get(Calendar.YEAR));
                    }
            }

            if (financialDetailsSimpleUno !=  null){
                listFinancialDetailsSimple.add(financialDetailsSimpleUno);
            }
            if (financialDetailsSimpleDos != null) {
                listFinancialDetailsSimple.add(financialDetailsSimpleDos);
            }

            if (financialDetailsSimpleTres != null){
                listFinancialDetailsSimple.add(financialDetailsSimpleTres);
            }


        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

       return listFinancialDetailsSimple;
    }
}
