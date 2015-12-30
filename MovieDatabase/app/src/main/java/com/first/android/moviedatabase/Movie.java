package com.first.android.moviedatabase;

import org.json.JSONException;
import org.json.JSONObject;


public class Movie implements Comparable<Movie> {
    String title, release, plot, poster_initial, rating, votes;
    String host="http://image.tmdb.org/t/p/w185/";


    Movie(String JsonMovie) throws JSONException {
        JSONObject movie=new JSONObject(JsonMovie);
        title = movie.getString("title");
        release = movie.getString("release_date");
        //runtime = movie.getString("Runtime");
        //genre = movie.getString("Genre");
        //director = movie.getString("Director");
        plot = movie.getString("overview");
        poster_initial = movie.getString("poster_path");
        rating = movie.getString("vote_average");
        votes = movie.getString("vote_count");
    }

    public String getTitle() {
        return title;
    }

    public String getRelease() {
        return release;
    }

   /* public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }*/

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        String poster_final=host+poster_initial.replace("\\","");
        return poster_final;
    }

    public float getRating() {
        return Float.parseFloat(rating);
    }

    public String getVotes() {
        return votes;
    }

    public int compareTo(Movie compareMovie) {
        String compareVotes = ((Movie) compareMovie).getVotes();
        int votes=Integer.parseInt(compareVotes.replaceAll(",",""));
        int currentVotes=Integer.parseInt(this.getVotes().replaceAll(",",""));
        return votes-currentVotes;
    }

}