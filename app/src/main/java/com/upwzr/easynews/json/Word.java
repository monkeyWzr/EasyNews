package com.upwzr.easynews.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wzr on 2017/8/30.
 */

public class Word {
    public String PinYin;

    public String PronounceJp;

    public String Tone;

    @SerializedName("Word")
    public String text;

    public String Comment;

    public String Pronounce;

    @SerializedName("TtsUrl")
    public String mp3;

    public boolean IsAddWord;

    public long WordId;

    public String FromLang;

    public String ToLang;

}
