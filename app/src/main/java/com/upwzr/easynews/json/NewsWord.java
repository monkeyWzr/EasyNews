package com.upwzr.easynews.json;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by wzr on 2017/9/6.
 */

public class NewsWord {
    private String def;

    @SerializedName("hyouki")
    private String[] text;

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "NewsWord{" +
                "def='" + def + '\'' +
                ", text='" + Arrays.toString(text) + '\'' +
                '}';
    }
}
