package com.example.homeapi.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.homeapi.R
import com.example.homeapi.databinding.SectionFragmentBinding
import com.example.mvvmexample.data.network.models.Section
import com.tapmad.webservices.Services.APIRepository
import com.tapmad.webservices.Services.APIRepositoryProvider
import com.tapmad.webservices.Services.ApiService
import com.tapmad.webservices.Services.ServiceGenerator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class SectionVideosTabFragmentHS : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: SectionVideosTabFragmentHViewModelFactory by instance()
    var tabName: String = ""

    companion object{
        var tabId:Int=0

    }

//private lateinit var factory: SectionVideosTabFragmentHViewModelFactory
    private var binding: SectionFragmentBinding?= null
    var sectionEntities: MutableList<Section> = mutableListOf()


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
        /*val api= ApiService()
        val repository= APIRepository(api)
        factory= SectionVideosTabFragmentHViewModelFactory(repository)*/
        viewModel = ViewModelProvider(this, factory).get(SectionVideosTabFragmentHViewModel::class.java)

        Log.d("result", "tab Id is "+tabId+ " tab Name is: "+tabName)
        viewModel.getTabsDetails(tabId)

        viewModel.tabDetails.observe(viewLifecycleOwner, Observer {
            if (it.Tabs != null && it.Tabs.size > 0 && it.Tabs.get(0).Sections != null) {
            adapter.addItems(it.Tabs[0].Sections)
            adapter.notifyDataSetChanged()}
        })

    }

    fun setSectionEntities(sectionEntities: List<Section>, tabName: String, tabId: Int) {
        if (sectionEntities != null) {

            this.sectionEntities.clear();
            this.sectionEntities.addAll(sectionEntities);
            this.tabName = tabName;
//            this.tabId= tabId
        }

    }



}
