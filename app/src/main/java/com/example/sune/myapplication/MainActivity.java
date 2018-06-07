package com.example.sune.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sune.myapplication.ui.main.MainFragment;
import com.example.sune.myapplication.ui.main.FællesViewModel;

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

       FællesViewModel mViewModel = ViewModelProviders.of(this).get(FællesViewModel.class);

        mViewModel.data = "sat fra aktivitet";

        final Observer<String> minObservatør = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String newName) {
                //mitTextview.setText(newName);
                System.out.println("onchanged kaldt");
            }


        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mViewModel.getCurrentName().observe(this, minObservatør);




    }
}
