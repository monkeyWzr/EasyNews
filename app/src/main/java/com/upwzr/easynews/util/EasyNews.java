package com.upwzr.easynews.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.LinkedHashTreeMap;
import com.google.gson.reflect.TypeToken;
import com.upwzr.easynews.json.MonthNews;
import com.upwzr.easynews.json.News;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.Response;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

/**
 * Created by wzr on 2017/9/5.
 */

public class EasyNews {
    public static final String API_TOP_NEWS = "http://www3.nhk.or.jp/news/easy/top-list.json?_=";
    public static final String API_NEWS_LIST = "http://www3.nhk.or.jp/news/easy/news-list.json?_=";
    public static final String API_KOYOMI = "http://www3.nhk.or.jp/news/json/koyomi.json?date=";

    private static final String TAG = "EasyNews";

    public static List<News> getTodayNews() {
        return null;
    }

    /**
     * news in a month
     * @return Map
     */
    public static Map<String, List<News>> getMonthNews() {
        MonthNews monthNews = null;
        Date date = new Date();
        String requestUrl = API_NEWS_LIST + date.getTime();
        Response response = HttpUtil.sendSynchronousOkHttpRequest(requestUrl);
        if (response != null) {
            try {
                JSONObject jsonObject = (new JSONArray(response.body().string())).getJSONObject(0);

//                ## An easy way to generate ##
//                Gson gson = new Gson();
//                Map<String, List<News>> month = new LinkedHashTreeMap<>();
//                JSONArray names = jsonObject.names();
//                for (int i = 0; i < names.length(); i++) {
//                    String day = jsonObject.getString(names.getString(i));
//                    List<News> news = gson.fromJson(day, new TypeToken<List<News>>(){}.getType());
//                    month.put(names.getString(i), news);
//                }
//                monthNews = new MonthNews(month);

//              ## Use Gson builder to generate ##
                GsonBuilder builder = new GsonBuilder();
                builder.registerTypeAdapter(MonthNews.class, new JsonDeserializer<MonthNews>() {
                    @Override
                    public MonthNews deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        JsonObject jsonObject = json.getAsJsonObject();
                        Map<String, List<News>> month = new LinkedHashTreeMap<>();
                        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                            List<News> day = context.deserialize(entry.getValue(), new TypeToken<List<News>>(){}.getType());
                            month.put(entry.getKey(), day);
                        }
                        return new MonthNews(month);
                    }
                });

                Gson gson = builder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES).create();
                monthNews = gson.fromJson(jsonObject.toString(), MonthNews.class);

                for (Map.Entry<String, List<News>> day : monthNews.getMonthNews().entrySet()) {
                    Log.d(TAG, day.getKey() + ": " + day.getValue());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return monthNews.getMonthNews();
    }

    /**
     * get top news
     * @return news list
     */
    public static List<News> getTopNews() {
        List<News> topNews = new ArrayList<>();
        Date date = new Date();
        String requestUrl = API_TOP_NEWS + date.getTime();
        Log.d(TAG, requestUrl);

        Response response = HttpUtil.sendSynchronousOkHttpRequest(requestUrl);
        if (response != null) {
            try {
                Gson json = new Gson();
                topNews = json.fromJson(response.body().string(), new TypeToken<List<News>>(){}.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return topNews;
    }
}
