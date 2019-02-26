package com.example.alshimaa.exhibtion.api;

import com.example.alshimaa.exhibtion.model.AboutUsResponse;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderResponse;
import com.example.alshimaa.exhibtion.model.HomeSliderResponse;


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
}
