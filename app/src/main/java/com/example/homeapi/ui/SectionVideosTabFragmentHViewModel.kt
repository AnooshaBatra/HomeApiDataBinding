package com.example.homeapi.ui

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tapmad.webservices.Services.APIRepository
import com.tapmad.webservices.Services.APIRepositoryProvider
import com.tapmad.webservices.Services.ServiceGenerator
import com.tapmad.webservices.Wrapper.RetrofitWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job

class SectionVideosTabFragmentHViewModel(val repository:APIRepository) : ViewModel() {
   private val _tabs= MutableLiveData<RetrofitWrapper>()
    var homeResponse: RetrofitWrapper?= null

    private val _home=  MutableLiveData<RetrofitWrapper>()
    val homes: MutableLiveData<RetrofitWrapper>
        get() = _home

    private val _tabDetails=  MutableLiveData<RetrofitWrapper>()
private lateinit var job: Job
    val tabs: MutableLiveData<RetrofitWrapper>
    get() = _tabs
    val tabDetails:MutableLiveData<RetrofitWrapper>
        get() = _tabDetails


    fun getTabs()
    {
        job = Coroutines.ioTheMain(
            {    repository.getHomePageData1() },
            {    _tabs.value = it} )


    }

    fun getTabsDetails(tabId:Int)
    {
        job = Coroutines.ioTheMain(
            {    repository.getHomePageDetailByTabId1(tabId) },
            {    _tabDetails.value = it} )
    }


    fun getDetails(tabId:Int)
    {
        Log.d("result", "in getDetails()")
        job = Coroutines.ioTheMain(
            {
        val repo= APIRepositoryProvider.provideHomeRepository()

        val observer =  repo.getHomePageDetailByTabId("v1", "en", "android", tabId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->
                _home.value= result
                homeResponse= result
                Log.d("result", "in getDetails() result is"+homeResponse)
            },
                { error ->
                    Log.d("error",error.message)
                    //Toast.makeText(,"unable to load data", Toast.LENGTH_LONG).show();

                })


        ServiceGenerator.compositeDisposable.add(observer)}, {//_home.value= homeResponse
                 })


    }
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}
