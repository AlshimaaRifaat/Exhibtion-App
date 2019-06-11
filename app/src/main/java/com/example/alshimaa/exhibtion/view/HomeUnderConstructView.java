package com.exhibtion.view;

import com.exhibtion.model.AboutUsData;
import com.exhibtion.model.HomeUnderConstructData;

import java.util.List;

public interface HomeUnderConstructView {
    void showHomeUnderConstructList(List<HomeUnderConstructData> homeUnderConstructDataList);
    void showError();
}
