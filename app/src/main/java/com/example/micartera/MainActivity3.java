package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.micartera.ui.category.CategoryFragment;
import com.example.micartera.ui.details.DetailsFragment;

public class MainActivity3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int accountID = getIntent().getExtras().getInt("accountID");
        setContentView(R.layout.category_activity);
        if (savedInstanceState == null) {
            Bundle args =  new Bundle();
            args.putInt("accountID", accountID);
            CategoryFragment fragment =  CategoryFragment.newInstance();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,fragment)
                    .commitNow();
        }
    }
}