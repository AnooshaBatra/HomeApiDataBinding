package com.tapmad.webservices.Services

import com.example.homeapi.network.Services.SafeApiRequest
import com.tapmad.webservices.Wrapper.RetrofitWrapper

class APIRepository(val apiService: ApiService): SafeApiRequest() {
    fun getHomePageDetailByTabId(
        version: String,
        locale: String,
        platform: String,
        TabId: Int
    ): io.reactivex.Observable<RetrofitWrapper> {
        return apiService.getHomePageDetailByTabId(version, locale, platform, TabId)
    }

    fun getHomePageData(
        version: String,
        locale: String,
        platform: String
    ): io.reactivex.Observable<RetrofitWrapper> {
        return apiService.getHomePageData(version, locale, platform)
    }

    suspend fun getHomePageData1() = apiRequest { apiService.getHomePageData1("v1", "en", "android") }

    suspend fun getHomePageDetailByTabId1(tabId: Int) = apiRequest { apiService.getHomePageDetailByTabId1("v1", "en", "android", tabId) }
}