package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micartera.ui.adjustment.AdjustmentFragment;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjustment_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AdjustmentFragment.newInstance())
                    .commitNow();
        }
    }
}