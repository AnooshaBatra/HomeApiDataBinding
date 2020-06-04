package com.example.homeapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tapmad.webservices.Services.APIRepository
import com.tapmad.webservices.Wrapper.RetrofitWrapper
import kotlinx.coroutines.Job

class SectionVideosTabFragmentHViewModel(val repository:APIRepository) : ViewModel() {
   private val _tabs= MutableLiveData<RetrofitWrapper>()

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

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}
