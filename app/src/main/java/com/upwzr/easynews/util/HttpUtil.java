package com.upwzr.easynews.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wzr on 2017/8/30.
 */

public class HttpUtil {
    private final static OkHttpClient client = new OkHttpClient();

    public static void sendAsynchronousOkHttpRequest(String address, okhttp3.Callback callback) {
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

    public static Response sendSynchronousOkHttpRequest(String address) {
        Response response;
        try {
            Request request = new Request.Builder()
                    .url(address)
                    .build();
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response;
            }

        } catch (Exception  e) {
            e.printStackTrace();
        }
        return null;
    }


}
