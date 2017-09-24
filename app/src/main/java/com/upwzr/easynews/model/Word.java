package com.upwzr.easynews.model;

import java.util.List;

/**
 * Created by wzr on 2017/9/25.
 */

public class Word {
    private String text;
    private String pronunciation;
    private List<String> definitions;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }
}
