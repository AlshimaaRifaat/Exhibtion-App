package com.exhibtion.view;

import com.exhibtion.model.ServicesProvidedData;

import java.util.List;

public interface ServicesProvidedView {
    void showServicesProvidedList(List<ServicesProvidedData> servicesProvidedDataList);
    void showError();
}
