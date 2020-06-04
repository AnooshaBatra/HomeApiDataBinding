package com.example.homeapi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.homeapi.R
import com.example.homeapi.databinding.SectionFragmentBinding
import com.example.mvvmexample.data.network.models.Section
import com.tapmad.webservices.Services.APIRepositoryProvider
import com.tapmad.webservices.Services.ServiceGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SectionVideosTabFragmentHS : Fragment() {
    var tabName: String = ""

    private var binding: SectionFragmentBinding?= null
    var sectionEntities: MutableList<Section> = mutableListOf()
    companion object {
        fun newInstance() = SectionVideosTabFragmentHS()
    }

    private lateinit var viewModel: SectionVideosTabFragmentHViewModel
    lateinit var adapter: RecyclerAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.section_fragment, container, false )
        recyclerView= binding?.recycler!!
        adapter = RecyclerAdapter(requireActivity(), sectionEntities, recyclerView)
        binding?.recycler?.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding?.recycler?.setHasFixedSize(true)
        binding?.recycler?.adapter= adapter

        binding?.lifecycleOwner= this
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SectionVideosTabFragmentHViewModel::class.java)

    }

    fun setSectionEntities(sectionEntities: List<Section>, tabName: String) {
        if (sectionEntities != null) {

            this.sectionEntities.clear();
            this.sectionEntities.addAll(sectionEntities);
            this.tabName = tabName;
        }

    }


    fun getHomePageDetailByTabId(tabId: Int, tabPosition: Int) {
        val repository = APIRepositoryProvider.provideHomeRepository()

        ServiceGenerator.compositeDisposable.add(
            repository.getHomePageDetailByTabId(
               "v1",
                "en",
               "android",
                tabId
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
Log.d("result", "result in section video is"+result.Tabs)
                        if (result.Tabs != null && result.Tabs.size > 0 && result.Tabs.get(0).Sections != null) {

//                            for (i in 0 until result.Tabs.get(tabPosition).Sections.size) {
//                                sectionEntities.add(result.Tabs.get(0).Sections)

                            adapter.addItems(result.Tabs.get(0).Sections)

                         adapter.notifyDataSetChanged()

                        } else {


                        }
                    }


                    , { error ->
                        //                        Toast.makeText(context, R.string.unable_to_load_data, Toast.LENGTH_LONG).show()


                    })
        )
    }

}