package com.vame_owl.recycleviewproject.viewModel.register;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class RegisterFactory implements ViewModelProvider.Factory{
    Context context;

    public RegisterFactory(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ViewModelRegister.class)){
            return (T) new ViewModelRegister(context);
        }
        else {
            throw new IllegalArgumentException("Unknown class");
        }
    }
}