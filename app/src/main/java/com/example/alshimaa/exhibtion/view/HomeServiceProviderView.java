package com.exhibtion.view;

/*import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;
import com.example.alshimaa.exhibtion.model.HomeSliderData;*/

import java.util.List;

public interface HomeServiceProviderView {
    void showHomeServiceProviderList(List<com.exhibtion.model.HomeServiceProviderData> homeServiceProviderDataList);
    void showError();
}
