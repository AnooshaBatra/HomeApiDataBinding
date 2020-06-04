package com.tapmad.webservices.Services


import com.tapmad.webservices.Wrapper.RetrofitWrapper
import retrofit2.http.*


interface ApiService {

    //var JSONURL = "https://apptest.tapmad.com/api/"

    @GET("getHomePageDetailByTabId/{version}/{locale}/{platform}/{TabId}")
    fun getHomePageDetailByTabId(
        @Path("version") version: String?,
        @Path("locale") locale: String?,
        @Path("platform") platform: String?,
        @Path("TabId") TabId: Int
    ): io.reactivex.Observable<RetrofitWrapper>

    @GET("getFeaturedHomePageDetail/{version}/{locale}/{platform}")
    fun getHomePageData(
        @Path("version") version: String?,
        @Path("locale") locale: String?,
        @Path("platform") platform: String?
    ): io.reactivex.Observable<RetrofitWrapper>
}







