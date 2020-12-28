package com.vame_owl.recycleviewproject.viewModel.login;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LogInFactory implements ViewModelProvider.Factory{
    Context context;

    public LogInFactory(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ViewModelLogIn.class)){
            return (T) new ViewModelLogIn(context);
        }
        else {
            throw new IllegalArgumentException("Unknown class");
        }
    }
}