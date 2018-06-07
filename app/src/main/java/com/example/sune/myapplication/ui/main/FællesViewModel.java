package com.example.sune.myapplication.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class FællesViewModel extends AndroidViewModel {
    Application a;
    public String data = "ikke sat";

    private MutableLiveData<String> mineData;

    public FællesViewModel(@NonNull Application application) {
        super(application);
        a=application;





    }
    // TODO: Implement the ViewModel


    // Create a LiveData with a String


    public MutableLiveData<String> getCurrentName() {
        if (mineData == null) {
            mineData = new MutableLiveData<String>();
        }
        return mineData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Toast.makeText(a, "onCleared", Toast.LENGTH_LONG).show();
    }

    void hentData(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mineData.setValue("hej");
            }
        }, 2050);

    }
}
