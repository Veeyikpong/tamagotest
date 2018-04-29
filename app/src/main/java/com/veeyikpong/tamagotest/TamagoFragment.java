package com.veeyikpong.tamagotest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


public class TamagoFragment extends Fragment {

    private MainActivity parentActivity;
    protected SliderLayout sliderShow;
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
        sliderShow.setDuration(5000);
        DefaultSliderView defaultSliderView = new DefaultSliderView(parentActivity);
        defaultSliderView
                .image("https://images-na.ssl-images-amazon.com/images/M/MV5BMTUwODE3MDE0MV5BMl5BanBnXkFtZTgwNTk1MjI4MzE@._V1_SX300.jpg");

        sliderShow.addSlider(defaultSliderView);

        DefaultSliderView asd = new DefaultSliderView(parentActivity);
        asd
                .image("https://images-na.ssl-images-amazon.com/images/M/MV5BMTU5ODAyNzA4OV5BMl5BanBnXkFtZTcwNzYwNTIzNA@@._V1_SX300.jpg");

        sliderShow.addSlider(asd);

        return rootView;
    }
}

