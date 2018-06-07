package com.example.sune.myapplication.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

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
            hentData();
        }
        return mineData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Toast.makeText(a, "onCleared", Toast.LENGTH_LONG).show();
    }

    void hentData(){

            //Simulerer at initialisering tager 4 sekunder
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mineData.setValue("data opdateret");
            }
        }, 4000);

    }
}
