package com.vame_owl.recycleviewproject.rec;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vame_owl.recycleviewproject.R;

import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Phone> phones;

    DataAdapter(Context context, List<Phone> phones) {
        this.phones = phones;
        this.inflater = LayoutInflater.from(context);
    }
    //возвращает объект ViewHolder, который будет хранить данные по одному объекту Phone.

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    //inflate читает xml и создаёт Java класс для того что бы работать с ним с помощью java
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
        //выполняет привязку объекта ViewHolder к объекту Phone по определенной позиции.
    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Phone phone = phones.get(position);
        holder.imageView.setImageResource(phone.getImage());
        holder.nameView.setText(phone.getName());
        holder.companyView.setText(phone.getCompany());
    }
        //возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        Log.i("getItemCount","count"+ phones.size());
        return phones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, companyView;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.image);
            nameView =  view.findViewById(R.id.name);
            companyView = view.findViewById(R.id.company);
        }
    }
}