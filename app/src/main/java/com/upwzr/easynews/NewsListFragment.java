package com.upwzr.easynews;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.upwzr.easynews.json.News;
import com.upwzr.easynews.util.EasyNews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzr on 2017/9/8.
 */

public class NewsListFragment extends Fragment {
    private List<News> monthNews = new ArrayList<>();
    RecyclerView newsListRecyclerView;
    NewsListAdapter adapter;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    adapter.notifyDataSetChanged();
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        newsListRecyclerView = (RecyclerView) view.findViewById(R.id.news_list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManager);
        adapter = new NewsListAdapter(monthNews);
        newsListRecyclerView.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (List<News> dayNews : EasyNews.getMonthNews().values()) {
                    monthNews.addAll(dayNews);
                }
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }).start();

        return view;
    }

    class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
        private List<News> mNewsList;
        private Context mContext;

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;
            ImageView newsTitleImage;

            public ViewHolder(View itemView) {
                super(itemView);
                newsTitleText = (TextView) itemView.findViewById(R.id.news_list_title);
                newsTitleImage = (ImageView) itemView.findViewById(R.id.news_list_image);
            }
        }

        public NewsListAdapter(List<News> newsList) {
            mNewsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (mContext == null)
                mContext = parent.getContext();
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    NewsContentActivity.actionStart(getActivity(), news.getNewsId(), news.getTitle(), EasyNews.getNewsImage(news));
                }
            });

            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
            // TODO: 重构EasyNews，封装imageUri，通过接口获取处理好的imageUri取代下面的实现，解耦
            String image = news.getWebImageUri();
            if (image.isEmpty()) {
                image = EasyNews.API_BASE + news.getNewsId() + "/" + news.getEasyImageUri();
            }
            Log.d("MainActivity", news.getTitle() + ": " + news.getWebImageUri());
            Glide.with(mContext).load(image).into(holder.newsTitleImage);
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

    }
}
