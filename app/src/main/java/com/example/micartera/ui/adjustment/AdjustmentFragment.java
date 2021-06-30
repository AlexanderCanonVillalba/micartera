package com.example.micartera.ui.adjustment;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.micartera.DashboardActivity;
import com.example.micartera.R;
import com.example.micartera.core.SaveFinancialAdjustment;
import com.example.micartera.databinding.AdjustmentFragmentBinding;
import com.example.micartera.databinding.CategoryFragmentBinding;
import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.infrastructure.repository.realm.RealmRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AdjustmentFragment extends Fragment {

    private AdjustmentFragmentBinding binding;
    private AdjustmentViewModel mViewModel;

    public static AdjustmentFragment newInstance() {
        return new AdjustmentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AdjustmentFragmentBinding.inflate(inflater, container, false);
        int accountID = this.getArguments().getInt("accountID");
        String category = this.getArguments().getString("category");
        Context context = this.getContext();

        binding.txtCategory.setText(category);
        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date =  new Date();
                try {
                    date=  new SimpleDateFormat("dd/MM/yyyy").parse(binding.date.getText().toString());
                }catch (Exception e){
                    throw  new RuntimeException(e.getMessage());
                }

                int adjustmentType =  0;


                if (binding.txtAdjusmentType.getText().toString().equals("Gasto")) {
                    adjustmentType =  1 ;
                }else {
                    adjustmentType = 2;
                }

                FinancialAdjustment financialAdjustment =  new FinancialAdjustment(
                        new Float(binding.txtValue.getText().toString()),
                        adjustmentType,
                        binding.txtCategory.getText().toString(),
                        binding.txtDescription.getText().toString(),
                        date);

                Account account =  new Account(1, 1, accountID, "Cuenta personal");
                account.addFinancialAdjustment(financialAdjustment);

                Repository repository =  new RealmRepository();
                SaveFinancialAdjustment useCase =  new SaveFinancialAdjustment(repository);
                useCase.Execute(account);

                Intent dashboard =  new Intent(context, DashboardActivity.class);
                dashboard.putExtra("accountID", accountID);
                startActivity(dashboard);
            }
        });
        return binding.getRoot();
    }


    private void showDatePickerDialog() {
       DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                binding.date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        });
        newFragment.show(this.getActivity().getSupportFragmentManager(), "datePicker");
    }

    private void Save(View view) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AdjustmentViewModel.class);
        // TODO: Use the ViewModel
    }
}