package com.example.sune.ViewModelLiveDataDemo;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sune.ViewModelLiveDataDemo.ui.main.MainFragment;
import com.example.sune.ViewModelLiveDataDemo.ui.main.FællesViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, MainFragment.newInstance())
                    .commitNow();

       FællesViewModel mViewModel = ViewModelProviders.of(this).get(FællesViewModel.class);




    }
}
