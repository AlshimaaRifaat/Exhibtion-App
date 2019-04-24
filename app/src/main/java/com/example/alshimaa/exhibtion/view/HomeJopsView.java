package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.HomeJopsData;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;

import java.util.List;

public interface HomeJopsView {
    void showHomeJopsList(List<HomeJopsData> homeJopsDataList);
    void showJopsError();
}
