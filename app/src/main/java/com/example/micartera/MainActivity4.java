package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micartera.ui.adjustment.AdjustmentFragment;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int accountID = getIntent().getExtras().getInt("accountID");
        String category =  getIntent().getExtras().getString("category");
        setContentView(R.layout.adjustment_activity);
        if (savedInstanceState == null) {
            Bundle args =  new Bundle();
            args.putInt("accountID", accountID);
            args.putString("category" , category);
            AdjustmentFragment fragment =  AdjustmentFragment.newInstance();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow();
        }
    }
}