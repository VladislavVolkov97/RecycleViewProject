package com.vame_owl.recycleviewproject.viewModel.mes;

import android.content.Context;

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
    List<Message> listMessage = new ArrayList<>();

    public MutableLiveData<List<Message>> getListOfMessages() {
        System.out.println(listOfMessages.getValue()+" hhhhhhhhhhhhhhhhhhhhhhh"+ "  "+ listOfMessages);
//                listMessage.add(new Message("1","2","3"));
//        listMessage.add(new Message("13","2","3"));
//        listMessage.add(new Message("12","2","3"));
//        listOfMessages.setValue(listMessage);
        return listOfMessages;
    }

   public ViewModelMessanger(Context context){
        this.context = context;
        this.authAppRepository = new AuthAppRepository(context);
        this.listOfMessages =  authAppRepository.getMesMutableLiveData();


    }



}
