package com.exhibtion.view;

import com.exhibtion.model.OrganizersAndServiceProvidersData;
import com.exhibtion.model.SponsorData;

import java.util.List;

public interface OrganizersAndServiceProvidersView {
    void showOrganizersAndServiceProvidersList(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList);
    void  showSponsorData(List<SponsorData> sponsorDataList);
    void showError();
}
