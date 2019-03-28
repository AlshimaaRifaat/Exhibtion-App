package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.HallOneData;
import com.example.alshimaa.exhibtion.model.HallTwoData;

import java.util.List;

public interface HallOneView {
    void showHallOneList(List<HallOneData> hallOneDataList);
    void showError();

    void showHallTwoList(List<HallTwoData> hallTwoDataList);
    void showHallTwoError();
}
