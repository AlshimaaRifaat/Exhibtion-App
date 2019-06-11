package com.exhibtion.view;

import com.exhibtion.model.DetailsNavItemServiceProvData;

import java.util.List;

public interface DetailsNavItemServiceProvView {
    void showDetailsNavItemServiceProvList(List<DetailsNavItemServiceProvData> detailsNavItemServiceProvDataList);
    void showError();
}
