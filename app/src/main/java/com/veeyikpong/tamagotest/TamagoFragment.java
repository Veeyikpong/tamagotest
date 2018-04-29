package com.veeyikpong.tamagotest;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
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

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
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

    private String moviesJson;
    protected RecyclerView rv_movies;
    private MovieAdapter movieAdapter;

    protected MaterialRefreshLayout materialRefreshLayout;

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

        materialRefreshLayout = (MaterialRefreshLayout) rootView.findViewById(R.id.refreshLayout);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
                                                             @Override
                                                             public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                                                                 Handler h = new Handler();
                                                                 h.postDelayed(new Runnable() {
                                                                     @Override
                                                                     public void run() {
                                                                         materialRefreshLayout.finishRefresh();
                                                                     }
                                                                 },1000);
                                                             }

                                                             @Override
                                                             public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                                                                 //load more refreshing...
                                                             }
                                                         });


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

        ArrayList<String> slideshowImageList = Util.slideshowImageList;

        sliderShow.setDuration(5000);
        for(int i = 0;i<slideshowImageList.size();i++){
            DefaultSliderView defaultSliderView = new DefaultSliderView(parentActivity);
            defaultSliderView.image(slideshowImageList.get(i));

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

