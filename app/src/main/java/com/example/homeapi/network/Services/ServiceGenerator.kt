package com.tapmad.webservices.Services

import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator {
    companion object {
        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val API_NODE = "https://app.tapmad.com/api/"
        var GAME_NODE = "Game/"
        val CONNECT_TIMEOUT: Long = 200
        val READ_TIMEOUT: Long = 120
        val WRITE_TIMEOUT: Long = 120

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(
                WRITE_TIMEOUT,
                TimeUnit.SECONDS
            ) //.

        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_NODE)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())

        fun <S> createService(serviceClass: Class<S>): S {
            return createService(serviceClass, null)
        }

        fun <S> createService(
            serviceClass: Class<S>?,
            authToken: String?
        ): S {
            if (authToken != null) {
                if (!httpClient.interceptors().isEmpty()) {
                    httpClient.interceptors().clear()
                }
                httpClient.addInterceptor { chain ->
                    val original = chain.request()
                    // Request customization: add request headers
                    val requestBuilder = original.newBuilder()
                        .header("authorization", authToken)
                        .method(original.method(), original.body())
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
            }
            //        if (authToken != null && authToken.equals("TESTTELENOR"))
//            builder.baseUrl("http://api.tapmad.com/api/");
//        else
//            builder.baseUrl(API_BASE_URL);
            val retrofit = builder.client(httpClient.build()).baseUrl(API_NODE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            return retrofit.create(serviceClass)
        }


    }


    }