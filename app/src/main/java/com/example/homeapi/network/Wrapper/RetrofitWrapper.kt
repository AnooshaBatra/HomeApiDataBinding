package com.tapmad.webservices.Wrapper

import com.example.mvvmexample.data.network.models.*



data class RetrofitWrapper(
    var Response: Response,
    var MobileNetwors: List<MobileNetwors>,
    var Ad: Advertisment,
    var Tabs: List<Tabs>,
    var Categories: List<VideoCategories>,
    var DateTime: DateTime,
    var Videos:List<Videos>


    )