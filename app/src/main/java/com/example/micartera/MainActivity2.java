package com.example.micartera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Fragment;
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

        setContentView(R.layout.details_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, DetailsFragment.newInstance(), "detailsFragment")
                    .commitNow();

        }
    }

}