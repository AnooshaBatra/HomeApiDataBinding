package com.tapmad.webservices.Services


import com.tapmad.webservices.Wrapper.RetrofitWrapper
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @GET("getFeaturedHomePageDetail/{version}/{locale}/{platform}")
    suspend fun getHomePageData1(
        @Path("version") version: String?,
        @Path("locale") locale: String?,
        @Path("platform") platform: String?
    ): Response<RetrofitWrapper>

    @GET("getHomePageDetailByTabId/{version}/{locale}/{platform}/{TabId}")
   suspend fun getHomePageDetailByTabId1(
        @Path("version") version: String?,
        @Path("locale") locale: String?,
        @Path("platform") platform: String?,
        @Path("TabId") TabId: Int
    ): Response<RetrofitWrapper>
    companion object
    {
        operator fun invoke():ApiService
        {
          return  Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://app.tapmad.com/api/").build().create(ApiService::class.java)
        }
    }
}







