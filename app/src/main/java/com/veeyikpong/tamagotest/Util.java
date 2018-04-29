package com.veeyikpong.tamagotest;

import android.graphics.Color;

import com.veeyikpong.tamagotest.models.Language;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {

    public static final ArrayList<String> slideshowImageList =
            new ArrayList<>(Arrays.asList(
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BMjkyMTE1OTYwNF5BMl5BanBnXkFtZTcwMDIxODYzMw@@._V1_SX300.jpg",
                    "https://images-na.ssl-images-amazon.com/images/M/MV5BNTM1NjYyNTY5OV5BMl5BanBnXkFtZTcwMjgwNTMzMQ@@._V1_SX300.jpg",
                    "http://ia.media-imdb.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1_SX300.jpg"));

    public static final ArrayList<Language> languageArrayList =
            new ArrayList<>(Arrays.asList(
                    new Language(Color.parseColor("#F5AA97"),R.string.english),
                    new Language(Color.parseColor("#DD757C"),R.string.chinese),
                    new Language(Color.parseColor("#8571A2"),R.string.indonesian),
                    new Language(Color.parseColor("#627D90"),R.string.tagalog),
                    new Language(Color.parseColor("#74E4CB"),R.string.vietnamese),
                    new Language(Color.parseColor("#add8e6"),R.string.melayu)));
}
