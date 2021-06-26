package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micartera.ui.category.CategoryFragment;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, CategoryFragment.newInstance())
                    .commitNow();
        }
    }
}