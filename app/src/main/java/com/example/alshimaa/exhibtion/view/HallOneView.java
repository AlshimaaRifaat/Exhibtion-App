package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.HallOneData;

import java.util.List;

public interface HallOneView {
    void showHallOneList(List<HallOneData> hallOneDataList);
    void showError();
}
