package com.example.sune.myapplication.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sune.myapplication.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;
    Button b;
    TextView t;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        t = v.findViewById(R.id.message);
        b= v.findViewById(R.id.button);
        b.setOnClickListener(this);
        System.out.println("oncreateView");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        t.setText(mViewModel.data);
        // TODO: Use the ViewModel
        System.out.println("onActivityCreated");
    }

    @Override
    public void onClick(View v) {
        t.setText("der blev klikket");
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, Fragment2.newInstance())
                .addToBackStack(null)
                .commit();
        //mViewModel.data = "der blev klikket";
        //t.setText(mViewModel.data);
    }
}
