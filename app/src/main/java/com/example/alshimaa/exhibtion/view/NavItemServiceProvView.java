package com.exhibtion.view;

import com.exhibtion.model.CurrentExhibtionData;
import com.exhibtion.model.NavItemServiceProviderData;

import java.util.List;

public interface NavItemServiceProvView {
    void showNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderDataList);
    void showError();

    void showSearchNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderData);
    void showErrorSearch(String Msg);
}
