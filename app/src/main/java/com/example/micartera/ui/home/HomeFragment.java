package com.example.micartera.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.micartera.R;
import com.example.micartera.core.ReadingTotals;
import com.example.micartera.databinding.FragmentHomeBinding;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;
import com.example.micartera.infrastructure.repository.RepositoryMemory;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Repository repository  = new RepositoryMemory();
        ReadingTotals useCase = new ReadingTotals(repository) ;
        GetFinancialAdjustment query =  new GetFinancialAdjustment(1 , 1234 , 0);
        List<FinancialDetailsSimple> listFinancialDetailsSimple = useCase.Execute(query);


        int margen = 0;
        for (FinancialDetailsSimple financialDetailsSimple : listFinancialDetailsSimple ) {
            System.out.println("validandoo...");
            final View view =  new View(this.getContext());
            view.setBackgroundColor(Color.YELLOW);
            view.setX(140);
            view.setY(320+margen);
            view.setLayoutParams(new ViewGroup.LayoutParams(800, 300));
            final TextView textView  =  new TextView(this.getContext());
            textView.setBackgroundColor(Color.BLUE);


            binding.getRoot().addView(view);
            margen += 400;
        }
       /* final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}