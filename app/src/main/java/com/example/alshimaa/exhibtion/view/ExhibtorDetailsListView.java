package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.ExhibtorDetailsData;

import java.util.List;

public interface ExhibtorDetailsListView {
    void showExhibtorDetailsListView(List<ExhibtorDetailsData> exhibtorDetailsDataList);
    void showError();
}
