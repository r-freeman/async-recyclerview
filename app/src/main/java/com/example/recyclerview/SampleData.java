package com.example.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static final String SAMPLE_MOVIE_THUMBNAIL_0 = "movie_thumb_0";
    public static final String SAMPLE_MOVIE_THUMBNAIL_1 = "movie_thumb_1";
    public static final String SAMPLE_MOVIE_THUMBNAIL_2 = "movie_thumb_2";
    public static final String SAMPLE_MOVIE_THUMBNAIL_3 = "movie_thumb_3";
    public static final String SAMPLE_MOVIE_THUMBNAIL_4 = "movie_thumb_4";
    public static final String SAMPLE_MOVIE_THUMBNAIL_5 = "movie_thumb_5";
    public static final String SAMPLE_MOVIE_THUMBNAIL_6 = "movie_thumb_6";
    public static final String SAMPLE_MOVIE_THUMBNAIL_7 = "movie_thumb_7";
    public static final String SAMPLE_MOVIE_THUMBNAIL_8 = "movie_thumb_8";
    public static final String SAMPLE_MOVIE_THUMBNAIL_9 = "movie_thumb_9";


    public static final String SAMPLE_MOVIE_TITLE_0 = "The Shawshank Redemption";
    public static final String SAMPLE_MOVIE_TITLE_1 = "The Godfather";
    public static final String SAMPLE_MOVIE_TITLE_2 = "The Dark Knight";
    public static final String SAMPLE_MOVIE_TITLE_3 = "The Godfather: Part II";
    public static final String SAMPLE_MOVIE_TITLE_4 = "The Lord of the Rings: The Return of the King";
    public static final String SAMPLE_MOVIE_TITLE_5 = "Pulp Fiction";
    public static final String SAMPLE_MOVIE_TITLE_6 = "Schindler's List";
    public static final String SAMPLE_MOVIE_TITLE_7 = "12 Angry Men";
    public static final String SAMPLE_MOVIE_TITLE_8 = "Inception";
    public static final String SAMPLE_MOVIE_TITLE_9 = "Fight Club";

    public static final String SAMPLE_MOVIE_SYNOPSIS_0 = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_1 = "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_2 = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_3 = "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_4 = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_5 = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_6 = "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_7 = "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_8 = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.";
    public static final String SAMPLE_MOVIE_SYNOPSIS_9 = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.";

    public static final int SAMPLE_MOVIE_YEAR_0 = 1994;
    public static final int SAMPLE_MOVIE_YEAR_1 = 1972;
    public static final int SAMPLE_MOVIE_YEAR_2 = 2008;
    public static final int SAMPLE_MOVIE_YEAR_3 = 1974;
    public static final int SAMPLE_MOVIE_YEAR_4 = 2003;
    public static final int SAMPLE_MOVIE_YEAR_5 = 1994;
    public static final int SAMPLE_MOVIE_YEAR_6 = 1993;
    public static final int SAMPLE_MOVIE_YEAR_7 = 1957;
    public static final int SAMPLE_MOVIE_YEAR_8 = 2010;
    public static final int SAMPLE_MOVIE_YEAR_9 = 1999;

    public static List<MovieEntity> getMovies() {
        List<MovieEntity> movies = new ArrayList<>();
        movies.add(new MovieEntity(1, SAMPLE_MOVIE_THUMBNAIL_0, SAMPLE_MOVIE_TITLE_0, SAMPLE_MOVIE_SYNOPSIS_0, SAMPLE_MOVIE_YEAR_0));
        movies.add(new MovieEntity(2, SAMPLE_MOVIE_THUMBNAIL_1, SAMPLE_MOVIE_TITLE_1, SAMPLE_MOVIE_SYNOPSIS_1, SAMPLE_MOVIE_YEAR_1));
        movies.add(new MovieEntity(3, SAMPLE_MOVIE_THUMBNAIL_2, SAMPLE_MOVIE_TITLE_2, SAMPLE_MOVIE_SYNOPSIS_2, SAMPLE_MOVIE_YEAR_2));
        movies.add(new MovieEntity(4, SAMPLE_MOVIE_THUMBNAIL_3, SAMPLE_MOVIE_TITLE_3, SAMPLE_MOVIE_SYNOPSIS_3, SAMPLE_MOVIE_YEAR_3));
        movies.add(new MovieEntity(5, SAMPLE_MOVIE_THUMBNAIL_4, SAMPLE_MOVIE_TITLE_4, SAMPLE_MOVIE_SYNOPSIS_4, SAMPLE_MOVIE_YEAR_4));
        movies.add(new MovieEntity(6, SAMPLE_MOVIE_THUMBNAIL_5, SAMPLE_MOVIE_TITLE_5, SAMPLE_MOVIE_SYNOPSIS_5, SAMPLE_MOVIE_YEAR_5));
        movies.add(new MovieEntity(7, SAMPLE_MOVIE_THUMBNAIL_6, SAMPLE_MOVIE_TITLE_6, SAMPLE_MOVIE_SYNOPSIS_6, SAMPLE_MOVIE_YEAR_6));
        movies.add(new MovieEntity(8, SAMPLE_MOVIE_THUMBNAIL_7, SAMPLE_MOVIE_TITLE_7, SAMPLE_MOVIE_SYNOPSIS_7, SAMPLE_MOVIE_YEAR_7));
        movies.add(new MovieEntity(9, SAMPLE_MOVIE_THUMBNAIL_8, SAMPLE_MOVIE_TITLE_8, SAMPLE_MOVIE_SYNOPSIS_8, SAMPLE_MOVIE_YEAR_8));
        movies.add(new MovieEntity(10, SAMPLE_MOVIE_THUMBNAIL_9, SAMPLE_MOVIE_TITLE_9, SAMPLE_MOVIE_SYNOPSIS_9, SAMPLE_MOVIE_YEAR_9));

        return movies;
    }
}
