package com.example.sune.ViewModelLiveDataDemo.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Date;

public class FællesViewModel extends AndroidViewModel {
    //Application a; //benyttes til Toast

    private MutableLiveData<String> mineData;

    public FællesViewModel(@NonNull Application application) {
        super(application);

        //a = application;
     
    }

    public MutableLiveData<String> getMineData() {
        if (mineData == null) {
            mineData = new MutableLiveData<String>();

            handler.postDelayed(hentData, 4000);//simulerer en forsinkelse på 4 sek
        }
        return mineData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Toast.makeText(getApplication(), "onCleared", Toast.LENGTH_LONG).show();
        handler.removeCallbacks(hentData);
    }

    Handler handler = new Handler();
    Runnable hentData = new Runnable() {
        @Override
        public void run() {
            mineData.setValue("data opdateret d "+new Date());
            Toast.makeText(getApplication(),  mineData.getValue(), Toast.LENGTH_LONG).show();
            handler.postDelayed(hentData, 5000); //Simulerer forsinkelse
        }
    };
}
