package com.example.sune.myapplication.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Date;

public class FællesViewModel extends AndroidViewModel {
    Application a; //benyttes ikke, men er muligt med AndroidViewModel

    private MutableLiveData<String> mineData;

    public FællesViewModel(@NonNull Application application) {
        super(application);
        a=application;
        getMineData();

    }

    public MutableLiveData<String> getMineData() {
        if (mineData == null) {
            mineData = new MutableLiveData<String>();
            //Simulerer at initialisering tager 4 sekunder
            handler.postDelayed(hentData, 4000);
        }
        return mineData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Toast.makeText(a, "onCleared", Toast.LENGTH_LONG).show();
        handler.removeCallbacks(hentData);
    }

    Handler handler = new Handler();
    Runnable hentData = new Runnable() {
        @Override
        public void run() {
            mineData.setValue("data opdateret d "+new Date());
            Toast.makeText(a,  mineData.getValue(), Toast.LENGTH_LONG).show();
            handler.postDelayed(hentData, 10000);
        }
    };
}
