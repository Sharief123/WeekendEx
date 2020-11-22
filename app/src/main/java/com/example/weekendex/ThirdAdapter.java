package com.example.weekendex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ThirdAdapter extends RecyclerView.Adapter<ThirdAdapter.ThirdViewHolder> {


    private List<Movies> moviesList;
    private Context context;

    public ThirdAdapter(List<Movies> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThirdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.firstmenu, parent, false);

        return new ThirdViewHolder(view, context, moviesList);
    }

    @Override
    public void onBindViewHolder(@NonNull ThirdViewHolder holder, int position) {

        holder.movies.setText(moviesList.get(position).getNames());

    }


    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class ThirdViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView movies;
        Context context;
        List<Movies> moviesList;

        public ThirdViewHolder(@NonNull View itemView, Context context, List<Movies> moviesList) {
            super(itemView);
            itemView.setOnClickListener(this);
            movies = itemView.findViewById(R.id.movies);
            this.context = context;
            this.moviesList = moviesList;
        }

        @Override
        public void onClick(View v) {

            if (getLayoutPosition() == 0) {
                Intent intent = new Intent(context, DisplaActivtiy.class);
                context.startActivity(intent);

            } else if (getLayoutPosition()==6){

                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("image_id", moviesList.get(getAdapterPosition()).getImages());
                intent.putExtra("flower12", moviesList.get(getAdapterPosition()).getNames());
                context.startActivity(intent);
            }
        }
    }
}

