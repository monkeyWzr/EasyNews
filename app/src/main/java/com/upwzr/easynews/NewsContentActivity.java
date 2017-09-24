package com.upwzr.easynews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.upwzr.easynews.json.News;
import com.upwzr.easynews.json.NewsWord;
import com.upwzr.easynews.model.Word;
import com.upwzr.easynews.util.EasyNews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NewsContentActivity extends AppCompatActivity {
    public static final int UPDATE_CONTENT = 1;
    public static final int UPDATE_WORDS = 2;

    private EasyNews.Article article;
    private WordAdapter adapter;
    private List<Word> mWordList = new ArrayList<>();

    public static void actionStart(Context context, String newsId, String newsTitle, String imageUri) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_id", newsId);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_image_uri", imageUri);
        context.startActivity(intent);
    }

    @TargetApi(24)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        Intent intent = getIntent();
        final String id = intent.getStringExtra("news_id");
        String title = intent.getStringExtra("news_title");
        String imageUri = intent.getStringExtra("news_image_uri");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView titleImage = (ImageView) findViewById(R.id.news_title_background_image);
        final WebView contentText = (WebView) findViewById(R.id.news_content_text);
        final RecyclerView wordList = (RecyclerView) findViewById(R.id.word_list);
        wordList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WordAdapter(mWordList);
        wordList.setAdapter(adapter);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout.setTitle(title);
        Glide.with(this).load(imageUri).into(titleImage);

        final Handler handler = new Handler() {
            public void handleMessage(Message message) {
                switch (message.what) {
                    case UPDATE_CONTENT:
                        if (article != null) {
                            WebSettings settings = contentText.getSettings();
                            settings.setDefaultTextEncodingName("utf-8");
                            contentText.loadDataWithBaseURL(null, article.getContent(), "text/html", "UTF-8", null);
                        }
                    case UPDATE_WORDS:
                        adapter.notifyDataSetChanged();
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                article = EasyNews.getNewsArticle(id);
                if (article != null) {
                    Message message = new Message();
                    message.what = UPDATE_CONTENT;
                    handler.sendMessage(message);
                    if (handleDict()) {
                        message = new Message();
                        message.what = UPDATE_WORDS;
                        handler.sendMessage(message);
                    }
                }
            }
        }).start();
    }

    class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
        private List<Word> mWordList;
//        private ViewHolder holder;
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView wordText;
            TextView wordDef;
            public ViewHolder(View itemView) {
                super(itemView);
                wordText = itemView.findViewById(R.id.word_text);
                wordDef = itemView.findViewById(R.id.word_definition);
            }
        }

        public WordAdapter(List<Word> wordList) {
            mWordList = wordList;
        }

        @Override
        public WordAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
//            if (holder == null) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_list_item, parent, false);
//                holder = new ViewHolder(view);
//            }

            return holder;
        }

        @TargetApi(24)
        @Override
        public void onBindViewHolder(WordAdapter.ViewHolder holder, int position) {
            Word word = mWordList.get(position);
            holder.wordText.setText(word.getText());
            for (String def : word.getDefinitions()) {
                holder.wordDef.append(Html.fromHtml(def, Html.FROM_HTML_MODE_COMPACT) + "\n");
            }
        }

        @Override
        public int getItemCount() {
            return mWordList.size();
        }
    }

    private boolean handleDict() {
        if (article != null) {
            for (Map.Entry<String, List<NewsWord>> entry : article.getDict().entrySet()) {
                Word word = new Word();
                List<NewsWord> list = entry.getValue();
                List<String> def = new ArrayList<>();
                for (NewsWord newsWord : list)
                    def.add(newsWord.getDef());
                word.setDefinitions(def);
                word.setText(list.get(0).getText()[0]);
                mWordList.add(word);
            }
            return true;
        }
        return false;
    }

//    TODO: complete NewsContentActivity
}
