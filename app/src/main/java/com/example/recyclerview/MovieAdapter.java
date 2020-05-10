package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<MovieEntity> movies;
    private final Context mContext;

    public MovieAdapter(List<MovieEntity> movies, Context mContext) {
        this.movies = movies;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    public int imageResourceId(Context mContext, String imageName) {
        return mContext.getResources()
                .getIdentifier("drawable/" + imageName, null, mContext.getPackageName());
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        MovieEntity movie = movies.get(position);

        holder.movieTitle.setText(String.format("%s (%d)", movie.getTitle(), movie.getYear()));
        holder.movieSynopsis.setText(movie.getSynopsis());
        holder.movieThumbnail.setImageResource(imageResourceId(mContext, movie.getThumbnail()));
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
