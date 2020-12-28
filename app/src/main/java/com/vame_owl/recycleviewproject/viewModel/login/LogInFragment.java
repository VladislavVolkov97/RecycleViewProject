package com.vame_owl.recycleviewproject.viewModel.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vame_owl.recycleviewproject.R;
import com.vame_owl.recycleviewproject.databinding.FragmentLogInBinding;


public class LogInFragment extends Fragment {
            FragmentLogInBinding binding;
            ViewModelLogIn vmLogIn;
            LogInFactory factory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false);

        View view = binding.getRoot();
        factory= new LogInFactory(view.getContext().getApplicationContext());
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // mainViewModel= ViewModelProviders.of(getActivity()).get(FragmentViewModel.class);
        vmLogIn   = ViewModelProviders.of(this, factory).get(ViewModelLogIn.class);
        binding.setVariables(vmLogIn);
        //binding.button.setOnClickListener(mainViewModel::makeToast);
        binding.executePendingBindings();
        super.onActivityCreated(savedInstanceState);
    }
}