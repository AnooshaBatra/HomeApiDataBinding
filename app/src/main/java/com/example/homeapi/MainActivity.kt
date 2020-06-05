package com.example.homeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.homeapi.Helper.TabViewPagerAdapter
import com.example.homeapi.ui.SectionVideosTabFragmentHS
import com.example.homeapi.ui.SectionVideosTabFragmentHS.Companion.tabId
import com.example.mvvmexample.data.network.models.Tabs
import com.google.android.material.tabs.TabLayout
import com.tapmad.webservices.Services.APIRepository
import com.tapmad.webservices.Services.APIRepositoryProvider
import com.tapmad.webservices.Services.ApiService
import com.tapmad.webservices.Services.ServiceGenerator.Companion.compositeDisposable
import com.tapmad.webservices.Wrapper.RetrofitWrapper
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    lateinit var adapter: TabViewPagerAdapter
    var homeRespone: RetrofitWrapper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val repository= APIRepository(ApiService())

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {

                var position = p0?.position
                when (position) {
                    0 -> Log.d("Position", 0.toString())
                    1 -> Log.d("Position", 1.toString())
                    2 -> Log.d("Position", 2.toString())


                }
            }
        });

        adapter = TabViewPagerAdapter(supportFragmentManager)


        loadData()


        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)
        adapter.notifyDataSetChanged()
    }


    fun loadData() {
        var fragment: Fragment
        val repository = APIRepositoryProvider.provideHomeRepository()
        val observer = repository.getHomePageData("v1", "en", "android")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
//
//                    }

                        for (tab: Tabs in result.Tabs) {
                            fragment = SectionVideosTabFragmentHS()

                            adapter.addFragmentAndData(fragment, tab.TabName)
                            if (tab.Sections != null)
                                (fragment as SectionVideosTabFragmentHS).setSectionEntities(tab.Sections, tab.TabName, tabId)


                        adapter.notifyDataSetChanged()

                        homeRespone = result

                        Log.d(
                            "result",
                            "AdvertismentID IS ${result.Ad.AdvertisementAgencyId}" + " and SECTION size is: " + "${result.Tabs.size}"
                        )


                        viewPager?.addOnPageChangeListener(this)

                      onPageSelected(0)
                        setViews(View.GONE, View.VISIBLE, View.GONE, View.GONE)

                    }


                },
                    { error ->   Log.d(
                        "result",error.message)
                        Toast.makeText(this,"unable to load data", Toast.LENGTH_LONG)
                            .show();
                        setViews(View.GONE, View.GONE, View.GONE, View.VISIBLE)
                    })


        compositeDisposable.add(observer)



    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

        var fragment: Fragment = adapter.getItem(position)
        tabId= homeRespone?.Tabs?.get(position)?.TabId!!
       /* (fragment as SectionVideosTabFragmentHS).getHomePageDetailByTabId(homeRespone?.Tabs?.get(position)?.TabId!!, position)
        Log.d(
            "result",
            "tab is: " + homeRespone?.Tabs?.get(position)?.TabName + " tab Id is: " + homeRespone?.Tabs?.get(
                position
            )?.TabId)*/


    }

    private fun setViews(
        progressBar: Int,
        tabLayout: Int,
        noDataView: Int,
        errorView: Int
    ) {
       // this.progressBar.visibility = progressBar
        this.tabs.visibility = tabLayout
        //this.noDataView.visibility = noDataView
       // this. errorView.visibility = errorView
    }
}
