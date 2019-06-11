package com.exhibtion.view;

import com.exhibtion.model.ResultRegisterAsVisitorData;

import java.util.List;

public interface ResultRegisterAsVisitorView {
    void showRegisterAsVisitorData(List<ResultRegisterAsVisitorData> registerAsVisitorDataList);
    void showError();
}
