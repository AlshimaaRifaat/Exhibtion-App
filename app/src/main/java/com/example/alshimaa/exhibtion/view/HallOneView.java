package com.exhibtion.view;

import com.exhibtion.model.HallFourData;
import com.exhibtion.model.HallOneData;
import com.exhibtion.model.HallThreeData;
import com.exhibtion.model.HallTwoData;

import java.util.List;

public interface HallOneView {
    void showHallOneList(List<HallOneData> hallOneDataList);
    void showError();

    void showHallTwoList(List<HallTwoData> hallTwoDataList);
    void showHallTwoError();

    void showHallThreeList(List<HallThreeData> hallThreeDataList);
    void showHallThreeError();

    void showHallFourList(List<HallFourData> hallFourDataList);
    void showHallFourError();
}
