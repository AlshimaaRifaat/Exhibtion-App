package com.example.alshimaa.exhibtion.api;

import com.example.alshimaa.exhibtion.model.AboutUsResponse;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionResponse;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderResponse;
import com.example.alshimaa.exhibtion.model.HomeSliderResponse;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructResponse;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersResponse;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionResponse;
import com.example.alshimaa.exhibtion.model.SponsorResponse;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {
    @POST("super_panner")
    Call<HomeSliderResponse> getHomeSliderData(@Body Map<String,String> map);

    @POST("super_service_providers")
    Call<HomeServiceProviderResponse> getHomeServiceProviderData(@Body Map<String,String> map);

    @POST("super_abouts")
    Call<AboutUsResponse> getAboutUsData(@Body Map<String,String> map);

    @POST("current_fair")
    Call<CurrentExhibtionResponse> getCurrentExhibtionData(@Body Map<String,String> map);

    @POST("last_fair")
    Call<PreviousExhibtionResponse> getPreviousExhibtionData(@Body Map<String,String> map);

    @POST("underconstruction_fair")
    Call<HomeUnderConstructResponse> getHomeUnderConstructData(@Body Map<String,String> map);

    @POST("service_provider_fairs")
    Call<OrganizersAndServiceProvidersResponse> getOrganizersAndServiceProvidersData(@Body Map<String,String> map);

    @POST("sponser_fairs")
    Call<OrganizersAndServiceProvidersResponse> getSponsorData(@Body Map<String,String> map);

}
