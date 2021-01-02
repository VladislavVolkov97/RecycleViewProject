package com.vame_owl.recycleviewproject.viewModel.mes;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class MessangerFactory implements ViewModelProvider.Factory {
    Context context;

    public MessangerFactory(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ViewModelMessanger.class)) {
            return (T) new ViewModelMessanger(context);
        } else {
            throw new IllegalArgumentException("Unknown class");
        }
    }
}

