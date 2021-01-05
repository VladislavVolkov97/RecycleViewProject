package com.vame_owl.recycleviewproject.viewModel.mes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vame_owl.recycleviewproject.BR;
import com.vame_owl.recycleviewproject.R;
import com.vame_owl.recycleviewproject.databinding.ListItemBinding;
import com.vame_owl.recycleviewproject.model.Message;

import java.util.ArrayList;
import java.util.List;

public class DataAdapterMessages extends RecyclerView.Adapter<DataAdapterMessages.ViewHolder>{
        List<Message> listMessage = new ArrayList<>();


    public DataAdapterMessages(List<Message> listMessage) {
        this.listMessage.addAll(listMessage);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       ListItemBinding listItemBinding = ListItemBinding.inflate(layoutInflater,parent,false);
        return new DataAdapterMessages.ViewHolder(listItemBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Message message = listMessage.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }
    public void onChanged(List<Message> listMessage){
        this.listMessage.clear();
        this.listMessage.addAll(listMessage);

        notifyDataSetChanged();
        System.out.println("oncganged &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
        //ViewHolder должен иметь сылки на все элементы разметки
    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

       public ViewHolder(View view){
            super(view);
            //сылки на элементы разметки получаем с помощью разметки дата бингинг
            binding = DataBindingUtil.bind(view);

        }
        public void bind(Object o){

            binding.setVariable(BR.message,o);
            binding.executePendingBindings();

        }
    }
}
