package com.exhibtion.view;

import com.exhibtion.model.CurrentExhibtionData;

import java.util.List;

public interface SearchHomeView {
    void showSearchHomeExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList);
    void showErrorHomeSearch(String Msg);
}
