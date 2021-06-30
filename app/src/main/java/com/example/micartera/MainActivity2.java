package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.micartera.databinding.ActivityMainBinding;
import com.example.micartera.databinding.DetailsActivityBinding;
import com.example.micartera.databinding.DetailsFragmentBinding;
import com.example.micartera.ui.details.DetailsFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int periodo =  getIntent().getExtras().getInt("periodo");
        int accountID =  getIntent().getExtras().getInt("accountID");

        setContentView(R.layout.details_activity);
        if (savedInstanceState == null) {
            Bundle args =  new Bundle();
            args.putInt("accountID", accountID);
            args.putInt("periodo" , periodo);
            DetailsFragment fragment =  DetailsFragment.newInstance();
            fragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, "detailsFragment")
                    .commitNow();

        }
    }

}