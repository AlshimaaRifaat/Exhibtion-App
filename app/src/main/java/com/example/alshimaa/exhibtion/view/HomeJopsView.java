package com.exhibtion.view;

import com.exhibtion.model.HomeJopsData;
import com.exhibtion.model.HomeUnderConstructData;

import java.util.List;

public interface HomeJopsView {
    void showHomeJopsList(List<HomeJopsData> homeJopsDataList);
    void showJopsError();
}
