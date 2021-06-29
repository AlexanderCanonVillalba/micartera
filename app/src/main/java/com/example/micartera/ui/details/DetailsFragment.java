package com.example.micartera.ui.details;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.example.micartera.DashboardActivity;
import com.example.micartera.MainActivity3;

import com.example.micartera.core.ReadingDetails;
import com.example.micartera.databinding.DetailsFragmentBinding;
import com.example.micartera.domain.entity.FinancialAdjustment;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;
import com.example.micartera.infrastructure.repository.RepositoryMemory;
import com.example.micartera.infrastructure.repository.realm.RealmRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DetailsFragment extends Fragment {

    private DetailsViewModel mViewModel;
    private DetailsFragmentBinding binding;

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        binding = DetailsFragmentBinding.inflate(inflater, container, false);
        binding.previus.setOnClickListener(this::previus);

        Repository repository = new RealmRepository();
        ReadingDetails  useCase = new ReadingDetails(repository);
        GetFinancialAdjustment query =  new GetFinancialAdjustment(45 , 1234 , Calendar.JUNE);
        List<FinancialAdjustment> list =  useCase.Execute(query);

        ArrayAdapter<FinancialAdjustment> mLeadsAdapter;
       // List<FinancialAdjustment> list = new RepositoryMemory().GetDetails(new GetFinancialAdjustment(39, 2,5));
        mLeadsAdapter = new ListViewAdapter(getActivity(), list);
        binding.listMovimientos.setAdapter(mLeadsAdapter);
       binding.add2.setOnClickListener(this::add);
        return binding.getRoot();

    }

    public void previus(View view){
        Intent dashboard =  new Intent(this.getContext(), DashboardActivity.class);
        startActivity(dashboard);
    }

    public void add(View view){
        Intent dashboard =  new Intent(this.getContext(), MainActivity3.class);
        startActivity(dashboard);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}