package com.exhibtion.view;

import com.exhibtion.model.HomeSliderData;

import java.util.List;

public interface HomeSliderView {
    void showHomeSliderResult(List<HomeSliderData> homeSliderDataList);
    void showError();
}
