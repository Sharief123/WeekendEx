package com.example.weekendex;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {

    private List<Director> directorList;

    private Context context;

    public FirstAdapter(List<Director> directorList, Context context) {
        this.directorList = directorList;
        this.context = context;
    }

    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstmenu,parent,false);

        return new FirstViewHolder(view, context, directorList);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder holder, int position) {

        holder.movies.setText(directorList.get(position).getNames());
        //holder.puri.setImageResource(directorList.get(position).getImages());
    }


    @Override
    public int getItemCount() {
        return directorList.size();
    }
    public static class FirstViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView movies;
        ImageView puri;
        Context context;
        List<Director> directorList;

        public FirstViewHolder(@NonNull View itemView, Context context, List<Director> directorList) {
            super(itemView);
            movies = itemView.findViewById(R.id.movies);
            //puri = itemView.findViewById(R.id.puriIV);
            itemView.setOnClickListener(this);
            this.context = context;
            this.directorList = directorList;
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context,DisplaActivtiy.class);

            intent.putExtra("image_id",  directorList.get(getAdapterPosition()).getImages());
            intent.putExtra("flower12", directorList.get(getAdapterPosition()).getNames());
            context.startActivity(intent);

        }
    }
}
