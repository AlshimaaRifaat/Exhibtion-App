package com.example.alshimaa.exhibtion.view;

import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;

import java.util.List;

public interface OrganizersAndServiceProvidersView {
    void showOrganizersAndServiceProvidersList(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList);
    void showError();
}
