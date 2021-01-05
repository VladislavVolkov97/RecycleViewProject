package com.vame_owl.recycleviewproject.viewModel.mes;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vame_owl.recycleviewproject.R;
import com.vame_owl.recycleviewproject.databinding.FragmentMessageBinding;
import com.vame_owl.recycleviewproject.model.Message;
import com.vame_owl.recycleviewproject.viewModel.login.ViewModelLogIn;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {
        FragmentMessageBinding binding;
        Context context;
        ViewModelMessanger viewModelMessanger;
        MessangerFactory factory;
        List<Message> listMessage= new ArrayList<>();
DataAdapterMessages dataAdapterMessages = new DataAdapterMessages(listMessage);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_message,container,false);

        View view = binding.getRoot();
        factory = new MessangerFactory(view.getContext().getApplicationContext());
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModelMessanger   = ViewModelProviders.of(this, factory).get(ViewModelMessanger.class);

        binding.setAdapter(dataAdapterMessages);
        viewModelMessanger.getListOfMessages().observe(getViewLifecycleOwner(), new Observer<List<Message>>() {
            @Override
            public void onChanged(List<Message> messages) {

                dataAdapterMessages.onChanged(messages);
                System.out.println(messages + "......................................");
            }
        });

        binding.executePendingBindings();


    }
}