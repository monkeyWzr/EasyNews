package com.upwzr.easynews.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.upwzr.easynews.json.Word;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by wzr on 2017/8/30.
 */

public class Dict {
    public static final String JP_API = "http://m.hujiang.com/d/dict_jp_api.ashx?w=%s&type=%s";
    public static final String TYPE_JAPANESE_TO_CHINESE = "jc";
    public static final String TYPE_CHINESE_TO_JAPANESE = "cj";
    public static final String ENCODING = "utf-8";
    private static final String TAG = "Dict";

    public static List<Word> query(String word, String type) {
        List<Word> result = new ArrayList<>();
        try {
            String encodedWord = URLEncoder.encode(word, ENCODING);
            String requestUrl = String.format(JP_API, encodedWord, type);
            Response response = HttpUtil.sendSynchronousOkHttpRequest(requestUrl);
            if (response != null) {
                try {
//                    Log.d(TAG, response.body().string());
                    result = (new Gson()).fromJson(response.body().string(), new TypeToken<List<Word>>(){}.getType());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UnsupportedEncodingException e) {
            Log.d(TAG, "Unsupported encoding");
        }
        return result;
    }

    public static Word handleJsonResponse(String response) {
        try {
            JSONObject jsonObject = (new JSONArray(response)).getJSONObject(0);
            Gson gson = new Gson();
            Word word = gson.fromJson(jsonObject.toString(), Word.class);
            return word;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
