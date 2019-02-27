package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public interface CurrentExhibtionView {
    void showCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList);
    void showError();
}
