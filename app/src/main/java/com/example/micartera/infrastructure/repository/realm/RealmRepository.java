package com.example.micartera.infrastructure.repository.realm;

import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.entity.FinancialDetails;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;
import com.example.micartera.infrastructure.repository.realm.model.AccountRealm;
import com.example.micartera.infrastructure.repository.realm.model.FinancialAdjustmentRealm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class RealmRepository implements Repository {

    @Override
    public List<FinancialAdjustment> GetTotals(GetFinancialAdjustment query) {
        // OBTENER RANGO DE FECHA
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date fechaInicial =  new GregorianCalendar(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH) , calender.get(Calendar.DAY_OF_MONTH)).getTime();

        calender.set(Calendar.MONTH, calender.get(Calendar.MONTH)-2);
        calender.set(Calendar.DAY_OF_MONTH, 1);
        Date fechaFinal =  new GregorianCalendar(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH) , calender.get(Calendar.DAY_OF_MONTH)).getTime();



        Realm realm = Realm.getDefaultInstance();
        RealmResults<FinancialAdjustmentRealm> listFinancialAdjustmentRealm =  realm.where(FinancialAdjustmentRealm.class).equalTo("idAccount" , query.getAccountID())
                .between("date", fechaFinal ,fechaInicial).findAll();


        List<FinancialAdjustment> list =  new ArrayList<>();
        for (FinancialAdjustmentRealm financialAdjustmentRealm :  listFinancialAdjustmentRealm){
            FinancialAdjustment financialAdjustment =  new FinancialAdjustment(financialAdjustmentRealm.getValue(),financialAdjustmentRealm.getAdjustmentType(),
                    financialAdjustmentRealm.getCategory(), financialAdjustmentRealm.getDescription(), financialAdjustmentRealm.getDate());

            list.add(financialAdjustment);
        }

        return list;
    }

    @Override
    public List<FinancialAdjustment> GetDetails(GetFinancialAdjustment query) {
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.DAY_OF_MONTH, 1);
        calender.set(Calendar.MONTH , query.getPeriod());
        Date fechaInicial =  calender.getTime();

        calender.set(Calendar.DAY_OF_MONTH, calender.getActualMaximum(Calendar.DAY_OF_MONTH));
        calender.set(Calendar.MONTH , query.getPeriod());
        Date fechaFinal =  calender.getTime();


        Realm realm = Realm.getDefaultInstance();
        RealmResults<FinancialAdjustmentRealm> listFinancialAdjustmentRealm =  realm.where(FinancialAdjustmentRealm.class).equalTo("idAccount" , query.getAccountID())
                .between("date", fechaInicial ,fechaFinal).findAll();

        List<FinancialAdjustment> list =  new ArrayList<>();
        for (FinancialAdjustmentRealm financialAdjustmentRealm :  listFinancialAdjustmentRealm){
            FinancialAdjustment financialAdjustment =  new FinancialAdjustment(financialAdjustmentRealm.getValue(),financialAdjustmentRealm.getAdjustmentType(),
                    financialAdjustmentRealm.getCategory(), financialAdjustmentRealm.getDescription(), financialAdjustmentRealm.getDate());

            list.add(financialAdjustment);
        }

        return list;
    }

    @Override
    public final int addFinancialAdjustment(Account account){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        AccountRealm accountRealm =  realm.where(AccountRealm.class).equalTo("id" , account.getId()).findFirst();

                  FinancialAdjustment financialAdjustmentDomain =  account.getListFinancialAdjustment().get(0);
                  FinancialAdjustmentRealm financialAdjustmentRealm =  realm.createObject(FinancialAdjustmentRealm.class);
                  financialAdjustmentRealm.setAdjustmentType(financialAdjustmentDomain.getAdjustmentType());
                  financialAdjustmentRealm.setCategory(financialAdjustmentDomain.getCategory());
                  financialAdjustmentRealm.setValue(financialAdjustmentDomain.getValue());
                  financialAdjustmentRealm.setDescription(financialAdjustmentDomain.getDescription());
                  financialAdjustmentRealm.setDate(financialAdjustmentDomain.getDate());
                  financialAdjustmentRealm.setIdAccount(account.getId());
                  accountRealm.addFinancialAdjustmentRealm(financialAdjustmentRealm);
                  realm.insertOrUpdate(accountRealm);
                  realm.commitTransaction();

        return 0;
    }

    @Override
    public void addAccount(Account account) {
        Realm realm =  Realm.getDefaultInstance();
        realm.beginTransaction();
        AccountRealm accountRealm =  realm.createObject(AccountRealm.class, account.getId());
        accountRealm.setAccountID(account.getAccountID());
        accountRealm.setUserID(account.getUserID());
        accountRealm.setNameAccount(account.getNameAccount());
        realm.commitTransaction();
    }
}
