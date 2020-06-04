package com.tapmad.webservices.Services

import com.tapmad.webservices.Wrapper.RetrofitWrapper

class APIRepository(val apiService: ApiService) {
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
}