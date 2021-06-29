package com.example.micartera.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.micartera.DashboardActivity;
import com.example.micartera.MainActivity2;
import com.example.micartera.MainActivity3;
import com.example.micartera.R;
import com.example.micartera.core.ReadingTotals;
import com.example.micartera.databinding.FragmentHomeBinding;
import com.example.micartera.domain.entity.FinancialDetailsSimple;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.domain.query.GetFinancialAdjustment;
import com.example.micartera.infrastructure.repository.RepositoryMemory;
import com.example.micartera.infrastructure.repository.realm.RealmRepository;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Bundle datosRecuperados =  getArguments();


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.add.setOnClickListener(this::add);
        View root = binding.getRoot();


        Repository repository  = new RealmRepository();
        ReadingTotals useCase = new ReadingTotals(repository) ;
        GetFinancialAdjustment query =  new GetFinancialAdjustment(45 , 1234 , 0);
        List<FinancialDetailsSimple> listFinancialDetailsSimple = useCase.Execute(query);


        int margen = 0;
        for (FinancialDetailsSimple financialDetailsSimple : listFinancialDetailsSimple ) {
            final LinearLayout view =  new LinearLayout(this.getContext());

            view.setX(140);
            view.setY(320+margen);
            view.setLayoutParams(new ViewGroup.LayoutParams(800, 300));
            view.setOrientation(LinearLayout.VERTICAL);

            view.setElevation(new Float(100));


            String uri = "@drawable/linear";
            int imageResource = getResources().getIdentifier(uri, null, getActivity().getPackageName());
            Drawable imagen = ContextCompat.getDrawable(this.getContext(), imageResource);
            view.setBackground(imagen);
            view.setOnClickListener(this::Cambiar);

            System.out.println("validando mes view...." + financialDetailsSimple.GetMonth() );
            Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
            final TextView textView  =  new TextView(this.getContext());
            textView.setText(financialDetailsSimple.GetMonth());
            textView.setX(60);
            textView.setY(60);
            textView.setTypeface(boldTypeface);


            final TextView totalExpense  =  new TextView(this.getContext());
            totalExpense.setText("TOTAL GASTOS : " + String.valueOf(financialDetailsSimple.GetTotalExpense()));
            totalExpense.setX(250);
            totalExpense.setY(90);
            totalExpense.setTypeface(boldTypeface);


            final TextView totalIncome  =  new TextView(this.getContext());
            totalIncome.setText("TOTAL INGRESO : "+ String.valueOf(financialDetailsSimple.GetTotalIncome()) );
            totalIncome.setX(250);
            totalIncome.setY(120);
            totalIncome.setTypeface(boldTypeface);


            view.addView(textView);
            view.addView(totalExpense);
            view.addView(totalIncome);


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


    public void Cambiar(View view) {
        Intent dashboard =  new Intent(this.getContext(), MainActivity2.class);
        startActivity(dashboard);

    }


    public void add(View view){
        Intent dashboard =  new Intent(this.getContext(), MainActivity3.class);
        startActivity(dashboard);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}