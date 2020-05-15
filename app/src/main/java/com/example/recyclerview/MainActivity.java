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
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
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
            getSupportLoaderManager().restartLoader(0, null, this);
//            new FetchMovies(this).execute();
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    static class FetchMovies extends AsyncTask<Void, Void, String> {
        private WeakReference<MainActivity> mainActivityWeakReference;

        FetchMovies(MainActivity context) {
            mainActivityWeakReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {
            mainActivityWeakReference.get().progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {
            return NetworkUtils.getMovies();
        }

        @Override
        protected void onPostExecute(String s) {
            MainActivity mainActivity = mainActivityWeakReference.get();
            mainActivity.movies = new ArrayList<>();

            try {
                JSONArray jsonArray = new JSONArray(s);

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

                    mainActivity.movies.add(movie);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            mainActivity.progressBar.setVisibility(View.GONE);
            mainActivity.initRecyclerView();

            Log.d(TAG, s);
        }
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
