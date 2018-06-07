package com.example.sune.myapplication.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Date;

public class FællesViewModel extends AndroidViewModel {

    private MutableLiveData<String> mineData;

    public FællesViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getMineData() {
        if (mineData == null) {
            mineData = new MutableLiveData<String>();

            handler.postDelayed(hentData, 4000);
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
            handler.postDelayed(hentData, 4567);
        }
    };
}
