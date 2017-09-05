package com.upwzr.easynews.json;

import java.util.List;
import java.util.Map;

/**
 * Created by wzr on 2017/9/5.
 */

public class MonthNews {
    private Map<String, List<News>> monthNews;

    public MonthNews(Map<String, List<News>> monthNews) {
        this.monthNews = monthNews;
    }

    public Map<String, List<News>> getMonthNews() {
        return monthNews;
    }
}
