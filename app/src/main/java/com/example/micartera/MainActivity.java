package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.micartera.databinding.ActivityDashboardBinding;
import com.example.micartera.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(this::Enter);
        setContentView(binding.getRoot());
    }

    public void Enter(View view) {
        Intent dashboard =  new Intent(this, DashboardActivity.class);
        startActivity(dashboard);
    }
}