package com.exhibtion.view;

import com.exhibtion.model.HomeServiceProviderData;
import com.exhibtion.model.NewsData;

import java.util.List;

public interface HomeNewsView {
    void showHomeNewsList(List<NewsData> newsDataList);
    void showError();
}
