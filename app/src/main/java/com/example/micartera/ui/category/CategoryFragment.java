package com.example.micartera.ui.category;

import androidx.lifecycle.ViewModelProvider;

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
        binding.btnMercado.setOnClickListener(this::Registrar);
        return binding.getRoot();
    }

   public void Registrar(View view){
       Intent dashboard =  new Intent(this.getContext(), MainActivity4.class);
       startActivity(dashboard);
   }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        // TODO: Use the ViewModel
    }

}