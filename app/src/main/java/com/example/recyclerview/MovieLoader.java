package com.example.recyclerview;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class MovieLoader extends AsyncTaskLoader<String> {
    @Nullable
    @Override
    public String loadInBackground() {
        return null;
    }
}
