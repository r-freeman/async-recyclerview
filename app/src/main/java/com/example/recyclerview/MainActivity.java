package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private static final String TAG =
            MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<MovieEntity> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            progressBar.setVisibility(View.VISIBLE);
            getSupportLoaderManager().restartLoader(0, null, this);
//            new FetchMovies(this).execute();
        } else {
            progressBar.setVisibility(View.GONE);
        }

        if (getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return new MovieLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        movies = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                MovieEntity movie =
                        new MovieEntity(
                                i,
                                jsonObject.getString("title"),
                                jsonObject.getString("synopsis"),
                                jsonObject.getInt("year"),
                                jsonObject.getString("thumbnail")
                        );

                movies.add(movie);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressBar.setVisibility(View.GONE);
        initRecyclerView();

        Log.d(TAG, data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    private void initRecyclerView() {
        // improves the performance of the RecyclerView if items are of fixed size.
        recyclerView.setHasFixedSize(true);

        // create and set a LinearLayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // connect the MovieAdapter to the RecyclerView
        RecyclerView.Adapter mAdapter = new MovieAdapter(movies);
        recyclerView.setAdapter(mAdapter);

        LayoutAnimationController layoutAnimationController
                = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(layoutAnimationController);
    }
}
