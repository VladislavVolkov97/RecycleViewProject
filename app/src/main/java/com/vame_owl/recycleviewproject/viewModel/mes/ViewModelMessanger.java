package com.vame_owl.recycleviewproject.viewModel.mes;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vame_owl.recycleviewproject.model.Message;
import com.vame_owl.recycleviewproject.views.AuthAppRepository;

import java.util.List;

public class ViewModelMessanger extends ViewModel {
    Context context;
    public MutableLiveData<List<Message>> listOfMessages;
    private AuthAppRepository authAppRepository ;

    public MutableLiveData<List<Message>> getListOfMessages() {
        return listOfMessages;
    }

    ViewModelMessanger(Context context){
        this.context = context;
        this.authAppRepository = new AuthAppRepository(context);
        this.listOfMessages =  authAppRepository.getMesMutableLiveData();
    }


}
