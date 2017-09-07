package com.upwzr.easynews.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wzr on 2017/8/30.
 */

public class DictWord {
    private String pinYin;

    private String PronounceJp;

    private String Tone;

    @SerializedName("Word")
    private String Text;

    private String Comment;

    private String Pronounce;

    @SerializedName("TtsUrl")
    private String Mp3Url;

    private boolean IsAddWord;

    private long WordId;

    private String FromLang;

    private String ToLang;

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public String getPronounceJp() {
        return PronounceJp;
    }

    public void setPronounceJp(String pronounceJp) {
        PronounceJp = pronounceJp;
    }

    public String getTone() {
        return Tone;
    }

    public void setTone(String tone) {
        Tone = tone;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getPronounce() {
        return Pronounce;
    }

    public void setPronounce(String pronounce) {
        Pronounce = pronounce;
    }

    public String getMp3Url() {
        return Mp3Url;
    }

    public void setMp3Url(String mp3Url) {
        Mp3Url = mp3Url;
    }

    public boolean isAddWord() {
        return IsAddWord;
    }

    public void setAddWord(boolean addWord) {
        IsAddWord = addWord;
    }

    public long getWordId() {
        return WordId;
    }

    public void setWordId(long wordId) {
        WordId = wordId;
    }

    public String getFromLang() {
        return FromLang;
    }

    public void setFromLang(String fromLang) {
        FromLang = fromLang;
    }

    public String getToLang() {
        return ToLang;
    }

    public void setToLang(String toLang) {
        ToLang = toLang;
    }
}
