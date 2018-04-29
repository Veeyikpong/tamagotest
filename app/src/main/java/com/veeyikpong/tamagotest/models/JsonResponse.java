package com.veeyikpong.tamagotest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonResponse {
    public ArrayList<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(ArrayList<String> genreList) {
        this.genreList = genreList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @SerializedName("genres")
    ArrayList<String> genreList;

    @SerializedName("movies")
    ArrayList<Movie> movieList;

    public static class Movie{
        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("year")
        private String year;

        @SerializedName("runtime")
        private int runtime;

        @SerializedName("genres")
        private ArrayList<String> genreList;

        @SerializedName("director")
        private String director;

        @SerializedName("actors")
        private String actors;

        @SerializedName("plot")
        private String plot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getRuntime() {
            return runtime;
        }

        public void setRuntime(int runtime) {
            this.runtime = runtime;
        }

        public ArrayList<String> getGenreList() {
            return genreList;
        }

        public void setGenreList(ArrayList<String> genreList) {
            this.genreList = genreList;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
        }

        public String getPlot() {
            return plot;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public String getPosterURL() {
            return posterURL;
        }

        public void setPosterURL(String posterURL) {
            this.posterURL = posterURL;
        }

        @SerializedName("posterUrl")
        private String posterURL;
    }
}
