package com.exhibtion.view;

import com.exhibtion.model.JopsData;

import java.util.List;

public interface JopsView {
    void showJopsList(List<JopsData> jopsDataList);
    void showError();
}
