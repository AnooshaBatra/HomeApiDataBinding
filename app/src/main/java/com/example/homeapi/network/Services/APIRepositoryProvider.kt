package com.tapmad.webservices.Services

object APIRepositoryProvider {

    fun provideNetworkRepository():APIRepository{
        return APIRepository(ServiceGenerator.Companion.createService(ApiService::class.java, null));
    }
    fun provideHomeRepository():APIRepository{
        return APIRepository(ServiceGenerator.Companion.createService(ApiService::class.java, null));
    }

   /* fun provideDCBRepository(isFetch:Boolean):DCBRepository
    {
        DCBRetrofitClient.isFetchCall= isFetch
        return DCBRepository(DCBRetrofitClient.createService(DCBService::class.java, null))
    }*/
}