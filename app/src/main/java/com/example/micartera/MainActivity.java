package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.micartera.core.SaveAccount;
import com.example.micartera.databinding.ActivityDashboardBinding;
import com.example.micartera.databinding.ActivityMainBinding;
import com.example.micartera.domain.entity.Account;
import com.example.micartera.domain.port.Repository;
import com.example.micartera.infrastructure.repository.realm.RealmRepository;

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
        Repository repository =  new RealmRepository();
        SaveAccount useCase = new SaveAccount(repository);
        Account account = new Account(1, 1, 45 , "Cuenta personal");
        useCase.Execute(account);
        Intent dashboard =  new Intent(this, DashboardActivity.class);
        dashboard.putExtra("accountID" , 14 );
        startActivity(dashboard);
    }
}