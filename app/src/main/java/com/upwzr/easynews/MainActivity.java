package com.upwzr.easynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.upwzr.easynews.json.News;
import com.upwzr.easynews.json.NewsWord;
import com.upwzr.easynews.util.EasyNews;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                List<Word> wordList = Dict.query("私", Dict.TYPE_JAPANESE_TO_CHINESE);
//                for (Word word : wordList)
//                    Log.d("MainActivity", word.PronounceJp);
//                Map<String, List<NewsWord>> dict = EasyNews.getNewsDictionary("k10011127161000");
//                for (Map.Entry<String, List<NewsWord>> entry : dict.entrySet()) {
//                    Log.d("MainActivity", entry.getKey() + ": " + entry.getValue());
//                }
                EasyNews.Article article = EasyNews.getNewsArticle("k10011127161000");
                Log.d("MainActivity", article.getAudio());
            }
        }).start();

//
    }
}
