package com.exhibtion.view;

import com.exhibtion.model.ExhibtorDetailsData;

import java.util.List;

public interface ExhibtorDetailsListView {
    void showExhibtorDetailsListView(List<ExhibtorDetailsData> exhibtorDetailsDataList);
    void showError();
}
