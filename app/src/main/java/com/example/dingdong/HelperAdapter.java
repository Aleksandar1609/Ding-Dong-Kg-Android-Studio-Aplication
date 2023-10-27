package com.example.dingdong;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {

    List<FetchData> fetchData;
    Context context;


    public HelperAdapter(List<FetchData> fetchData) {
        this.fetchData = fetchData;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        final FetchData fetchDatalist = fetchData.get(position);
        viewHolderClass.textView.setText(fetchDatalist.getAdresa() +
                "\n" + fetchDatalist.getBroj() + "\n" + fetchDatalist.getNaselje()+"\n"+
                fetchDatalist.getBrojtelefona());
        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", fetchDatalist);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fetchData.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.maintextView);
        }
    }
}