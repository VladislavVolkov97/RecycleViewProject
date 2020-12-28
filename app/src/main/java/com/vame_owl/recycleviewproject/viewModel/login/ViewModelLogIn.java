package com.vame_owl.recycleviewproject.viewModel.login;

import android.content.Context;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vame_owl.recycleviewproject.views.AuthAppRepository;

public class ViewModelLogIn extends ViewModel {

    private AuthAppRepository authAppRepository ;
    public MutableLiveData<String> email ;
    public MutableLiveData<String> password ;
    Context context;

    public ViewModelLogIn(Context context){
        this.context = context;
        if(this.email == null){
        this.email = new MutableLiveData<>();
    }
        if(this.password == null){
        this.password = new MutableLiveData<>();
    }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void logIn(View view){
        authAppRepository.login(email.getValue(),password.getValue());
    }
}
