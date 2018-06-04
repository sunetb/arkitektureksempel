package com.example.sune.myapplication.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class MainViewModel extends AndroidViewModel {
    Application a;
    public String data = "ikke sat";
    public MainViewModel(@NonNull Application application) {
        super(application);
        a=application;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data = "sat";
            }
        }, 2050); //din kode køres om 50 milisekunder

    }
    // TODO: Implement the ViewModel


    @Override
    protected void onCleared() {
        super.onCleared();
        Toast.makeText(a, "onCleared", Toast.LENGTH_LONG).show();
    }
}
