package com.exhibtion.view;

import com.exhibtion.model.ExhibtorsData;

import java.util.List;

public interface ExhibtorsView {
    void showExhibtorsList(List<ExhibtorsData> exhibtorsDataList);
    void showError();
}
