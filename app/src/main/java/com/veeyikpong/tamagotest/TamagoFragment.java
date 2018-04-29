package com.veeyikpong.tamagotest;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class TamagoFragment extends Fragment {

    private MainActivity parentActivity;
    protected SliderLayout sliderShow;
    protected PagerIndicator pagerIndicator;

    protected RecyclerView rv_language;
    private LanguageAdapter languageAdapter;

    private ArrayList<String> imageUrls = new ArrayList<>();

    private String moviesJson;
    protected RecyclerView rv_movies;
    private MovieAdapter movieAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentActivity = (MainActivity) getActivity();
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tamago, container, false);

        sliderShow = (SliderLayout) rootView.findViewById(R.id.slider);
        pagerIndicator = (PagerIndicator) rootView.findViewById(R.id.custom_indicator);
        rv_language = (RecyclerView) rootView.findViewById(R.id.rv_language);

        initSlideshow();

        languageAdapter = new LanguageAdapter(parentActivity,Util.languageArrayList);
        rv_language.setLayoutManager(new LinearLayoutManager(parentActivity,LinearLayoutManager.HORIZONTAL,false));
        rv_language.setAdapter(languageAdapter);

        moviesJson = readJSONFromAsset();

        if(moviesJson!=null) {
            Gson gson = new GsonBuilder().create();
            JsonResponse response = gson.fromJson(moviesJson, JsonResponse.class);

            rv_movies = (RecyclerView) rootView.findViewById(R.id.rv_movies);
            GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
            rv_movies.setLayoutManager(mLayoutManager);

            movieAdapter = new MovieAdapter(parentActivity,response.movieList);
            rv_movies.setAdapter(movieAdapter);
        }

        return rootView;
    }

    private void initSlideshow(){
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMjkyMTE1OTYwNF5BMl5BanBnXkFtZTcwMDIxODYzMw@@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM1NjYyNTY5OV5BMl5BanBnXkFtZTcwMjgwNTMzMQ@@._V1_SX300.jpg");
        imageUrls.add("http://ia.media-imdb.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1_SX300.jpg");

        sliderShow.setDuration(5000);
        for(int i = 0;i<imageUrls.size();i++){
            DefaultSliderView defaultSliderView = new DefaultSliderView(parentActivity);
            defaultSliderView.image(imageUrls.get(i));

            sliderShow.addSlider(defaultSliderView);
        }


        sliderShow.setCustomIndicator(pagerIndicator);
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = parentActivity.getAssets().open("movies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

