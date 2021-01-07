package com.vame_owl.recycleviewproject.viewModel.mes;

import android.content.Context;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vame_owl.recycleviewproject.model.Message;
import com.vame_owl.recycleviewproject.views.AuthAppRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewModelMessanger extends ViewModel {
    Context context;
    public MutableLiveData<List<Message>> listOfMessages;
    private AuthAppRepository authAppRepository ;
    public MutableLiveData<String> sendMessage;
    List<Message> listMessage = new ArrayList<>();

    public MutableLiveData<List<Message>> getListOfMessages() {
        System.out.println(listOfMessages.getValue()+" hhhhhhhhhhhhhhhhhhhhhhh"+ "  "+ listOfMessages);
        return listOfMessages;
    }

   public ViewModelMessanger(Context context){
        this.context = context;
        this.sendMessage = new MutableLiveData<>();
        this.authAppRepository = new AuthAppRepository(context);
        this.listOfMessages =  authAppRepository.getMesMutableLiveData();
    }

    public void sendMessage(View view){
        authAppRepository.addMessage(sendMessage.getValue());
    }

}
