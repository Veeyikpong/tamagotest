package com.veeyikpong.tamagotest.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.veeyikpong.tamagotest.models.Language;
import com.veeyikpong.tamagotest.MainActivity;
import com.veeyikpong.tamagotest.R;

import java.util.ArrayList;

/**
 * Created by Juan on 23/4/2018.
 */

public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>{
    private static MainActivity mActivity;
    private ArrayList<Language> languageList = new ArrayList<>();

    public LanguageAdapter(MainActivity activity, ArrayList<Language> languageList) {
        this.mActivity = activity;
        this.languageList = languageList;
    }

    @Override
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_language, parent, false);
        return new LanguageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LanguageViewHolder holder, final int position) {
        holder.tv_language.setText(mActivity.getString(languageList.get(position).getLanguage()));
        holder.tv_language.setBackgroundColor(languageList.get(position).getColor());

        if(position!=languageList.size()-1){
            //set margin right to all items except last item
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,30,0);
            holder.tv_language.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }

    public static class LanguageViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv_language;

        public LanguageViewHolder(View v) {
            super(v);
            tv_language = (TextView)v.findViewById(R.id.tv_language);
        }
    }
}
