package com.exhibtion.view;

import com.exhibtion.model.AboutUsData;
import com.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public interface AboutUsView {
    void showAboutUsResult(List<AboutUsData> aboutUsDataList);
    void showError();
}
