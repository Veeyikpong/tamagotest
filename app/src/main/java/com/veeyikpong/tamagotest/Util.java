package com.veeyikpong.tamagotest;

import android.content.res.Resources;
import android.graphics.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 30/4/2018.
 */

public class Util {
    public static final ArrayList<Language> languageArrayList =
            new ArrayList<>(Arrays.asList(
                    new Language(Color.parseColor("#F5AA97"),R.string.english),
                    new Language(Color.parseColor("#DD757C"),R.string.chinese),
                    new Language(Color.parseColor("#8571A2"),R.string.indonesian),
                    new Language(Color.parseColor("#627D90"),R.string.tagalog),
                    new Language(Color.parseColor("#74E4CB"),R.string.vietnamese),
                    new Language(Color.parseColor("#add8e6"),R.string.melayu)));
}
