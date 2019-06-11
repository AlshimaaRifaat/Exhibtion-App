package com.exhibtion.view;

import com.exhibtion.model.CurrentExhibtionData;
import com.exhibtion.model.PreviousExhibtionData;

import java.util.List;

public interface PreviousExhibtionView {
    void showPreviousExhibtionList(List<PreviousExhibtionData> previousExhibtionDataList);
    void showError();

    void showSearchPreviousExhibtionList(List<PreviousExhibtionData> previousExhibtionDataList);
    void showErrorSearchPrevious(String Msg);
}
