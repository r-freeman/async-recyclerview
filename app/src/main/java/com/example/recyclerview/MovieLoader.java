package com.example.recyclerview;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MovieLoader extends AsyncTaskLoader<String> {
    public MovieLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }

    @Override
    protected void onStartLoading() {
        super.forceLoad();
    }


}
