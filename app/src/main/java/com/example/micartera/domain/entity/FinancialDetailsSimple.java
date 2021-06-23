package com.example.micartera.domain.entity;

public class FinancialDetailsSimple extends FinancialDetails{
    private float totalIncome ;
    private float totalExpense;
    private int month, year;

    public FinancialDetailsSimple(float totalIncome,float totalExpense,int month, int year){
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.totalExpense = totalExpense;
        this.month = month;
        this.year = year;
    }
}
