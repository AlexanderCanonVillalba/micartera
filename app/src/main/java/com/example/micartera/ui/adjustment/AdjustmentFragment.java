package com.example.micartera.ui.adjustment;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.micartera.R;
import com.example.micartera.databinding.AdjustmentFragmentBinding;
import com.example.micartera.databinding.CategoryFragmentBinding;

import java.util.Calendar;

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
        binding.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        return binding.getRoot();
    }


    private void showDatePickerDialog() {
      System.out.println("validando.. date");
       DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                binding.date.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        });
        newFragment.show(this.getActivity().getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AdjustmentViewModel.class);
        // TODO: Use the ViewModel
    }

}