package com.veeyikpong.tamagotest;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class TamagoFragment extends Fragment {

    private MainActivity parentActivity;
    protected SliderLayout sliderShow;
    protected PagerIndicator pagerIndicator;

    protected RecyclerView rv_language;
    private LanguageAdapter adapter;

    ArrayList<String> imageUrls = new ArrayList<>();

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

        adapter = new LanguageAdapter(parentActivity,Util.languageArrayList);
        rv_language.setLayoutManager(new LinearLayoutManager(parentActivity,LinearLayoutManager.HORIZONTAL,false));
        rv_language.setAdapter(adapter);

        return rootView;
    }

    private void initSlideshow(){
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMTMzODU0NTkxMF5BMl5BanBnXkFtZTcwMjQ4MzMzMw@@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BMjkyMTE1OTYwNF5BMl5BanBnXkFtZTcwMDIxODYzMw@@._V1_SX300.jpg");
        imageUrls.add("https://images-na.ssl-images-amazon.com/images/M/MV5BNTM1NjYyNTY5OV5BMl5BanBnXkFtZTcwMjgwNTMzMQ@@._V1_SX300.jpg");

        sliderShow.setDuration(5000);
        for(int i = 0;i<imageUrls.size();i++){
            DefaultSliderView defaultSliderView = new DefaultSliderView(parentActivity);
            defaultSliderView.image(imageUrls.get(i));

            sliderShow.addSlider(defaultSliderView);
        }


        sliderShow.setCustomIndicator(pagerIndicator);
    }
}

