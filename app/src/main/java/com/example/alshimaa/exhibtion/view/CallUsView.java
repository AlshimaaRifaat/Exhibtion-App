package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.CallUsData;

import java.util.List;

public interface CallUsView {
   void showCallUsData(List<CallUsData> callUsDataList);
   void showError();
}
