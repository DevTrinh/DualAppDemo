package com.example.testvirtualapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemAppViewHolder> {

    private List<ItemApp> list = new ArrayList<>();

    public AdapterItem(List<ItemApp> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemAppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_app, parent, false);
        return new ItemAppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAppViewHolder holder, int position) {
        ItemApp itemApp = list.get(position);
        holder.tvNameApp.setText(itemApp.getNameApp());
        holder.ivApp.setImageDrawable(itemApp.getDrawable());
    }

    @Override
    public int getItemCount() {
        if (list!= null){
            return list.size();
        }
        return 0;
    }

    public class ItemAppViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivApp;
        private TextView tvNameApp;

        public ItemAppViewHolder(@NonNull View itemView) {
            super(itemView);
            ivApp = itemView.findViewById(R.id.iv_avt_app);
            tvNameApp = itemView.findViewById(R.id.tv_name_app);
        }
    }
}
