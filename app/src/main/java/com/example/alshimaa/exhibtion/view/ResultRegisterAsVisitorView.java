package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.ResultRegisterAsVisitorData;

import java.util.List;

public interface ResultRegisterAsVisitorView {
    void showRegisterAsVisitorData(List<ResultRegisterAsVisitorData> registerAsVisitorDataList);
    void showError();
}
