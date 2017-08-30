package com.upwzr.easynews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.upwzr.easynews.json.Word;
import com.upwzr.easynews.util.Dict;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Word> wordList = Dict.query("私", Dict.TYPE_JAPANESE_TO_CHINESE);
                for (Word word : wordList)
                    Log.d("MainActivity", word.PronounceJp);
            }
        }).start();

//
    }
}
