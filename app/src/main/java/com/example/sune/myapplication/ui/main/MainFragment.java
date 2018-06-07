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

    private FællesViewModel mViewModel;
    Button knap;
    TextView tekst;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);

        tekst = v.findViewById(R.id.message);
        knap = v.findViewById(R.id.button);
        knap.setText("klik inden 4 sekunder");
        knap.setOnClickListener(this);
        System.out.println("oncreateView fragment 1");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(FællesViewModel.class);

        //Bemærk: getValue() returnerer null første gang vi spørger. Og bliver ikke opdateret før vi vender tilbage til fragment1
        //Vi burde observere ligesom i Fragment2
        tekst.setText(mViewModel.getMineData().getValue());
        System.out.println("onActivityCreated Fragment 1. getValue: "+mViewModel.getMineData().getValue());
    }

    @Override
    public void onClick(View v) {
        tekst.setText("der blev klikket");
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, Fragment2.newInstance())
                .addToBackStack(null)
                .commit();

    }
}
