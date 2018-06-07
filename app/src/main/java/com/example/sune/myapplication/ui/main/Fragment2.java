package com.example.sune.myapplication.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sune.myapplication.R;

public class Fragment2 extends Fragment {


    //Fragment som har sin egen ViewModel plus et delt

    private Fragment2ViewModel privatViewModel;
    private FællesViewModel fællesViewModel;

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        privatViewModel = ViewModelProviders.of(this).get(Fragment2ViewModel.class); //Fragmentets egen ViewModel
        fællesViewModel = ViewModelProviders.of(getActivity()).get(FællesViewModel.class); //Aktivitetetens Viewmodel som kan deles
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        final Observer<String> minObservatør = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String nystreng) {
                //mitTextview.setText(nystreng);
                System.out.println("onchanged kaldt");
            }


        };
        fællesViewModel.getMineData().observe(this, minObservatør);

    }






}
