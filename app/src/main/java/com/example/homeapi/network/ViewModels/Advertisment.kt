package com.example.mvvmexample.data.network.models


data class Advertisment(
    var AdvertisementAgencyId: Int,
    var AdvertisementClientId: Int,
    var AdvertisementCampaignId: Int,
    var AdvertisementId: Int,
    var AdvertisementName: String,
    var AdvertisementUrl: String,
    var IsJavascriptTag: Boolean,
    var AdvertisementJavascriptTag: String,
    var AdvertisementCallToActionUrl: String,
    var AdvertisementCallToActionImageUrl: String,
    var AdvertisementViewsDone: Int,
    var AdvertisementTargetViews: Int,
    var AdvertisementTypeId: Int,
    var AdvertisementMinAdsPerDay: Int,
    var AdvertisementTodayCount: Int,
    var AdvertisementCpmRate: Int,
    var IsAllowSkipAd: Boolean,
    var AdvertisementShowSkipAfter: Int,
    var IsAllowOnNonPlayer: Boolean,
    var AdvertisementVastURL:String,
    var  IsVast: Boolean,
    var RandomPriority: Int
)