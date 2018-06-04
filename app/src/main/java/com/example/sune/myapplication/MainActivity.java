package com.example.sune.myapplication;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sune.myapplication.ui.main.MainFragment;
import com.example.sune.myapplication.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

       MainViewModel mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.data = "sat fra aktivitet";

    }
}
