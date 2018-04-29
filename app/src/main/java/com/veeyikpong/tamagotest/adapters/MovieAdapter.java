package com.veeyikpong.tamagotest.adapters;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.veeyikpong.tamagotest.models.JsonResponse;
import com.veeyikpong.tamagotest.MainActivity;
import com.veeyikpong.tamagotest.R;

import java.util.ArrayList;

/**
 * Created by Juan on 23/4/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private static MainActivity mActivity;
    private ArrayList<JsonResponse.Movie> movieArrayList = new ArrayList<>();

    public MovieAdapter(MainActivity activity, ArrayList<JsonResponse.Movie> movieArrayList) {
        this.mActivity = activity;
        this.movieArrayList = movieArrayList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        if(!movieArrayList.get(position).getPosterURL().equals("") && movieArrayList.get(position).getPosterURL()!=null && !TextUtils.isEmpty(movieArrayList.get(position).getPosterURL())){
            Picasso.with(mActivity).load(movieArrayList.get(position).getPosterURL()).resize(200,200).centerCrop().into(holder.img_thumbnail, new Callback() {
                @Override
                public void onSuccess() {
                    //Check if url doesnt contains an image
                    if(holder.img_thumbnail.getDrawable()==null){
                        holder.img_thumbnail.setBackgroundColor(ContextCompat.getColor(mActivity,R.color.darkgrey));
                    }else
                        holder.img_thumbnail.setBackgroundColor(Color.TRANSPARENT);
                }

                @Override
                public void onError() {
                    //If error, display default background
                    holder.img_thumbnail.setBackgroundColor(ContextCompat.getColor(mActivity,R.color.darkgrey));
                }
            });
        }

        holder.tv_actor.setText(movieArrayList.get(position).getDirector());
        holder.tv_title.setText(movieArrayList.get(position).getTitle());
        holder.tv_country.setText(movieArrayList.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        protected RoundedImageView img_thumbnail;
        protected TextView tv_actor;
        protected TextView tv_title;
        protected TextView tv_country;

        public MovieViewHolder(View v) {
            super(v);
            img_thumbnail = (RoundedImageView)v.findViewById(R.id.img_thumbnail);
            tv_actor = (TextView)v.findViewById(R.id.tv_actor);
            tv_title = (TextView)v.findViewById(R.id.tv_title);
            tv_country = (TextView)v.findViewById(R.id.tv_country);
        }
    }
}
