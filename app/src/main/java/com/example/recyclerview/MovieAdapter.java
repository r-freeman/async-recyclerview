package com.example.recyclerview;

import android.annotation.SuppressLint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<MovieEntity> movies;

    public MovieAdapter(List<MovieEntity> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        MovieEntity movie = movies.get(position);

        holder.movieTitle.setText(String.format("%s (%d)", movie.getTitle(), movie.getYear()));
        holder.movieSynopsis.setText(movie.getSynopsis());

        Glide.with(holder.itemView.getContext())
                .load(movie.getThumbnail())
                .fitCenter()
                .into(holder.movieThumbnail);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView movieSynopsis;
        ImageView movieThumbnail;

        public ViewHolder(@NonNull View view) {
            super(view);

            movieTitle = view.findViewById(R.id.movie_title);
            movieSynopsis = view.findViewById(R.id.movie_synopsis);
            movieThumbnail = view.findViewById(R.id.movie_thumbnail);
        }
    }
}
