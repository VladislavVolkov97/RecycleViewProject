package com.vame_owl.recycleviewproject.viewModel.login;

import android.content.Context;
import android.os.Build;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vame_owl.recycleviewproject.model.Message;
import com.vame_owl.recycleviewproject.views.AuthAppRepository;

import java.util.List;

public class ViewModelLogIn extends ViewModel {

    private AuthAppRepository authAppRepository ;
    public MutableLiveData<String> email ;
    public MutableLiveData<String> password ;
    public MutableLiveData<List<Message>> listOfMessages;

    public MutableLiveData<List<Message>> getListOfMessages() {
        return listOfMessages;
    }

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public void setEmail(MutableLiveData<String> email) {
        this.email = email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public void setPassword(MutableLiveData<String> password) {
        this.password = password;
    }

    Context context;

    public ViewModelLogIn(Context context){
        this.context = context;

        this.authAppRepository = new AuthAppRepository(context);
       // this.listOfMessages =  authAppRepository.getMesMutableLiveData();
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
