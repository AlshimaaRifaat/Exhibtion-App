package com.exhibtion.api;

import com.exhibtion.model.AboutUsResponse;
import com.exhibtion.model.CallUsResponse;
import com.exhibtion.model.CurrentExhibtionResponse;
import com.exhibtion.model.DetailsNavItemServiceProvResponse;
import com.exhibtion.model.EShopResponse;
import com.exhibtion.model.ExhibtionOwnerResponse;
import com.exhibtion.model.ExhibtorDetailsResponse;
import com.exhibtion.model.ExhibtorsResponse;
import com.exhibtion.model.HallFourResponse;
import com.exhibtion.model.HallOneResponse;
import com.exhibtion.model.HallThreeResponse;
import com.exhibtion.model.HallTwoResponse;
import com.exhibtion.model.HomeJopsResponse;
import com.exhibtion.model.HomeSiteOptionResponse;
import com.exhibtion.model.HomeSliderResponse;
import com.exhibtion.model.HomeUnderConstructResponse;
import com.exhibtion.model.JopsResponse;
import com.exhibtion.model.NavItemServiceProviderResponse;
import com.exhibtion.model.NavigationServiceProviderResponse;
import com.exhibtion.model.NewsResponse;
import com.exhibtion.model.OrganizersAndServiceProvidersResponse;
import com.exhibtion.model.PreviousExhibtionResponse;
import com.exhibtion.model.PuthesRegisterResponse;
import com.exhibtion.model.PuthesResponse;
import com.exhibtion.model.ResultRegisterAsVisitorResponse;
import com.exhibtion.model.ServicesProvidedResponse;
import com.exhibtion.model.SponsorResponse;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Service {
    @POST("super_panner")
    Call<HomeSliderResponse> getHomeSliderData(@Body Map<String,String> map);

   /* @POST("super_service_providers")
    Call<HomeServiceProviderResponse> getHomeServiceProviderData(@Body Map<String,String> map);*/

    /*@POST("category_provider")
    Call<NavItemServiceProviderResponse> getHomeServiceProviderData(@Body Map<String,String> map);*/

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
    Call<SponsorResponse> getSponsorData(@Body Map<String,String> map);

    @POST("exhibitors")
    Call<ExhibtorsResponse> getExhibtorsData(@QueryMap Map<String,String> map);


    @POST("search_current_fair")
    Call<CurrentExhibtionResponse> getsearchCurrentExhibtionData(@Body Map<String,String> map);

    @POST("career_exhibitors")
    Call<JopsResponse> getJopsData(@Body Map<String,String> map);

    @POST("search_under_construction")
    Call<CurrentExhibtionResponse> getSearchHomeData(@Body Map<String,String> map);

    @POST("search_last_fair")
    Call<PreviousExhibtionResponse> getSearchPreviousExhibtionData(@Body Map<String,String> map);

    @POST("services_exhibitors")
    Call<ServicesProvidedResponse> getServicesProvidedData(@Body Map<String,String> map);

    @POST("product_exhibitors")
    Call<EShopResponse> getEShopData(@Body Map<String,String> map);


    @POST("super_inbox")
    Call<CallUsResponse> getCallUsData(@Body Map<String,String> map);

    @POST("super_news")
    Call<NewsResponse> getNewsData(@Body Map<String,String> map);

    @POST("request_services_provider")
    Call<NavigationServiceProviderResponse> getNavServiceProviderData(@Body Map<String,String> map);

    @POST("visitors")
    Call<ResultRegisterAsVisitorResponse> getRegisterAsVisitorData(@Body Map<String,String> map);

    @POST("available_partitions")
    Call<PuthesResponse> getPuthesData(@Body Map<String,String> map);

    @POST("register_viewer_partitions")
    Call<PuthesRegisterResponse> getPuthesRegisterData(@Body Map<String,String> map);

    @POST("super_OwnerFairRequest")
    Call<ExhibtionOwnerResponse> getExhibtionOwnerData(@QueryMap Map<String,String> map);

    @POST("super_site_option")
    Call<HomeSiteOptionResponse> getHomeSiteOptionData();

    @POST("category_provider")
    Call<NavItemServiceProviderResponse> getNavItemServiceProviderData(@Body Map<String,String> map);

    @POST("category_provider_details")
    Call<DetailsNavItemServiceProvResponse> getDetailsNavItemServiceProvData(@Body Map<String,String> map);

    @POST("category_provider_search")
    Call<NavItemServiceProviderResponse> getSearchNavItemServiceProvData(@Body Map<String,String> map);

    @POST("hole_exhibitor_No_1")
    Call<HallOneResponse> getHallOneData(@Body Map<String,String> map);
    @POST("hole_exhibitor_No_2")
    Call<HallTwoResponse> getHallTwoData(@Body Map<String,String> map);

    @POST("hole_exhibitor_No_3")
    Call<HallThreeResponse> getHallThreeData(@Body Map<String,String> map);

    @POST("hole_exhibitor_No_4")
    Call<HallFourResponse> getHallFourData(@Body Map<String,String> map);

    @POST("exhibitors_detials")
    Call<ExhibtorDetailsResponse> getExhibtorDetailsData(@Body Map<String,String> map);

    @POST("jobs")
    Call<HomeJopsResponse> getHomeJopsData(@Body Map<String,String> map);

    @POST("img_map_Illustration")
    Call<com.example.exhibtion.model.ExhibtionDiagramResponse> getExhibtionDiagramData(@Body Map<String,String> map);
}
