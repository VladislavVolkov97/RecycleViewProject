package com.vame_owl.recycleviewproject.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vame_owl.recycleviewproject.R;
import com.vame_owl.recycleviewproject.databinding.ActivityLogInAndRegBinding;
import com.vame_owl.recycleviewproject.viewModel.login.LogInFragment;
import com.vame_owl.recycleviewproject.viewModel.mes.MessageFragment;
import com.vame_owl.recycleviewproject.viewModel.register.RegisterFragment;

public class LogInAndRegActivity extends AppCompatActivity {
        ActivityLogInAndRegBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_log_in_and_reg);
        binding.setLifecycleOwner(this);

        fragmentManager.beginTransaction().add(R.id.frameLayout,new RegisterFragment()).commit();

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_dashboard:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new RegisterFragment()).commit();
                        return true;
                    case R.id.navigation_home:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new LogInFragment()).commit();
                        return true;
                    case R.id.secondActivity:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new MessageFragment()).commit();
                }
                return false;
            }
        });




    }
}