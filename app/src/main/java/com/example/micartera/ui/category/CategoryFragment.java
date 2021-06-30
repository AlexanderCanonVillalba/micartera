package com.example.micartera.ui.category;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.micartera.DashboardActivity;
import com.example.micartera.MainActivity4;
import com.example.micartera.R;
import com.example.micartera.databinding.CategoryFragmentBinding;
import com.example.micartera.databinding.DetailsFragmentBinding;

public class CategoryFragment extends Fragment {

    private CategoryFragmentBinding binding;
    private CategoryViewModel mViewModel;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CategoryFragmentBinding.inflate(inflater, container, false);

        int accountID = this.getArguments().getInt("accountID");
        Context context = this.getContext();
        binding.btnMercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Mercado");
                startActivity(dashboard);
            }
        });
    binding.btnTransporte.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent dashboard =  new Intent(context, MainActivity4.class);
            dashboard.putExtra("accountID" , accountID);
            dashboard.putExtra("category" , "Transporte");
            startActivity(dashboard);
        }
    });
        binding.btnFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Servicios");
                startActivity(dashboard);
            }
        });
        binding.btnRopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Ropa");
                startActivity(dashboard);
            }
        });

        binding.btnSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Salud");
                startActivity(dashboard);
            }
        });

        binding.btnCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Hogar");
                startActivity(dashboard);
            }
        });

        binding.btnGimnasio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Gimnasio");
                startActivity(dashboard);
            }
        });

        binding.btnEstudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Estudio");
                startActivity(dashboard);
            }
        });

        binding.btnEntretenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "Entretenimiento");
                startActivity(dashboard);
            }
        });

        binding.btnBelleza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboard =  new Intent(context, MainActivity4.class);
                dashboard.putExtra("accountID" , accountID);
                dashboard.putExtra("category" , "belleza");
                startActivity(dashboard);
            }
        });

        binding.previus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        // TODO: Use the ViewModel
    }

}