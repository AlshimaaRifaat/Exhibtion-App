package com.exhibtion.view;

import com.exhibtion.model.EShopData;

import java.util.List;

public interface EShopView {
    void showEshopDataList(List<EShopData> eShopDataList);
    void showError();
}
