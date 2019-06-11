package com.exhibtion.view;

import com.exhibtion.model.PuthesData;

import java.util.List;

public interface PuthesView {
    void showPuthesList(List<PuthesData> puthesDataList);
    void showError();
}
