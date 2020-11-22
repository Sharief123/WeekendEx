package com.example.weekendex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> {
    private List<String> list;

    public SecondAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstmenu,parent,false);

        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecondViewHolder holder, int position) {

        holder.names.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class SecondViewHolder extends RecyclerView.ViewHolder {

        TextView names;
        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.movies);
        }
    }
}
