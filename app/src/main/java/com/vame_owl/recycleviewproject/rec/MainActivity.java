package com.vame_owl.recycleviewproject.rec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vame_owl.recycleviewproject.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DataAdapter adapter;
    List<Phone> phones = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialDataPhone();
        recyclerView = findViewById(R.id.list);
        adapter = new DataAdapter(getApplicationContext(), phones);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());

       linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private  void setInitialDataPhone(){
        phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.ic_launcher_foreground));
        phones.add(new Phone ("Elite z3", "HP", R.drawable.ic_launcher_foreground));
        phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.ic_launcher_foreground));
        phones.add(new Phone ("LG G 5", "LG", R.drawable.ic_launcher_foreground));
}
}