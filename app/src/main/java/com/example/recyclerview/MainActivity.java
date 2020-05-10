package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Movies";

    private RecyclerView recyclerView;
    private MovieAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<MovieEntity> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = SampleData.getMovies();

        for (MovieEntity movie : movies) {
            Log.i(TAG, movie.toString());
        }

        // initialise the RecyclerView
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // improves the performance of the RecyclerView if items are of fixed size.
        recyclerView.setHasFixedSize(true);

        // create and set a LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // connect the MovieAdapter to the RecyclerView
        mAdapter = new MovieAdapter(movies, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }
}
