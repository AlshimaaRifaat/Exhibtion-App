package com.exhibtion.view;

import com.exhibtion.model.CurrentExhibtionData;
import com.exhibtion.model.HomeServiceProviderData;

import java.util.List;

public interface CurrentExhibtionView {
    void showCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList);
    void showError();

    void showSearchCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList);
    void showErrorSearch(String Msg);



}
