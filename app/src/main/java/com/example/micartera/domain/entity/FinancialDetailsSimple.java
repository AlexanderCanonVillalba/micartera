package com.example.micartera.domain.entity;

import com.example.micartera.domain.service.DateService;

public class FinancialDetailsSimple extends FinancialDetails{
    private float totalIncome ;
    private float totalExpense;
    private int month, year;

    public FinancialDetailsSimple(){}

    public FinancialDetailsSimple(float totalIncome,float totalExpense,int month, int year){
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.totalExpense = totalExpense;
        this.month = month;
        this.year = year;
    }


    public void setTotalIncome(float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public void setTotalExpense(float totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float GetTotalIncome() {
        return  this.totalIncome;
    }

    public float GetTotalExpense() {
        return  this.totalExpense;
    }

    public String GetMonth(){
        return new DateService().GetMonth(this.month);
    }

    public int GetMonthID(){
        return this.month;
    }

}
