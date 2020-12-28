package com.vame_owl.recycleviewproject.viewModel.register;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vame_owl.recycleviewproject.R;
import com.vame_owl.recycleviewproject.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

            FragmentRegisterBinding binding;
            RegisterFactory factoryLogIn;
            ViewModelRegister viewModelRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_register,container,false);

        View view = binding.getRoot();
        factoryLogIn = new RegisterFactory(view.getContext().getApplicationContext());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        viewModelRegister = ViewModelProviders.of(this,factoryLogIn).get(ViewModelRegister.class);
        binding.setVariableViewModel(viewModelRegister);
        super.onActivityCreated(savedInstanceState);
    }
}