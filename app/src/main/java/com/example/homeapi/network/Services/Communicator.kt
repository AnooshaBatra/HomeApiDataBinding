package com.tapmad.webservices.Services

import android.util.Log

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class Communicator {
    companion object{
        // lateinit var  res:RetrofitWrapper
    }
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
   /* fun getNetwork() {
        val repository = APIRepositoryProvider.provideNetworkRepository()
        compositeDisposable.add(
            repository.getNetwork(Constants.VERSION, Constants.LANGUAGE, Constants.PLATFORM)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    Log.d(
                        "Result",
                        "There are ${result.Response.status}" + " and network size is: " + "${result.MobileNetwors.size}"
                    )
                }, { error ->
                    Log.d("Result", "There are ${error.message}")
                })
        )

    }

    fun getHomePageDetails()
    {
        val repository = APIRepositoryProvider.provideHomeRepository()

        compositeDisposable.add(
            repository.getHomePageData(Constants.VERSION, Constants.LANGUAGE, Constants.PLATFORM)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    //res=result
                    Log.d(
                        "Result",
                        "AdvertismentID IS ${result.Ad.AdvertisementAgencyId}" + " and SECTION size is: " + "${result.Tabs.size}"

                    )


                }, { error ->
                    Log.d("Result", "There are ${error.message}")
                }
                )
        )
    }
*/

}