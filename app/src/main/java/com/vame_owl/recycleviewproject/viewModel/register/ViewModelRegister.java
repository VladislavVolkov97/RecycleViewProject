package com.vame_owl.recycleviewproject.viewModel.register;

import android.content.Context;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vame_owl.recycleviewproject.views.AuthAppRepository;

public class ViewModelRegister extends ViewModel {
    private AuthAppRepository authAppRepository ;
    public MutableLiveData<String> email ;
    public MutableLiveData<String> password ;

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

    private Context context;

   public ViewModelRegister(Context context){
       this.context= context;
       if(this.email == null){
           this.email = new MutableLiveData<>();
       }
       if(this.password == null){
           this.password = new MutableLiveData<>();
       }
    }



    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(View view){
        System.out.println(email.getValue() + " " + password.getValue()+ "''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
       authAppRepository.register(email.getValue(),password.getValue());
    }
}
