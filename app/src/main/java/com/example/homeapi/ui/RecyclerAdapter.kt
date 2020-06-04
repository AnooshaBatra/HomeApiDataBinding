package com.example.homeapi.ui

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeapi.R
import com.example.homeapi.databinding.RecyclerMainItemsBinding
import com.example.mvvmexample.data.network.models.Section

class RecyclerAdapter(var context: FragmentActivity, var dataList:MutableList<Section>, var recycler :RecyclerView): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
      var itemsBinding:RecyclerMainItemsBinding= DataBindingUtil.inflate( LayoutInflater.from(parent.getContext()),R.layout.recycler_main_items, parent, false)
        var myViewHolder: ViewHolder= ViewHolder(itemsBinding)

        return myViewHolder
    }

    override fun getItemCount(): Int {
        return if (null != dataList) dataList.size else 0
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
       holder.iview.itemTitle.setText( dataList[position].SectionName)
        var itemListDataAdapter = NestedRecyclerAdapter(dataList[position].Categories, dataList[position].Videos, dataList[position].IsCategories)
        holder.iview.nestedRecycler.layoutManager= LinearLayoutManager( context, LinearLayoutManager.HORIZONTAL, false)
        holder.iview.nestedRecycler.setHasFixedSize(true)
        holder.iview.nestedRecycler.setNestedScrollingEnabled(false)

        holder.iview.nestedRecycler.setItemAnimator(DefaultItemAnimator())
        holder.iview.nestedRecycler.adapter= itemListDataAdapter
        (holder.iview.nestedRecycler.adapter as NestedRecyclerAdapter).notifyDataSetChanged()



    }
    fun addItems(newDataSetItems: MutableList<Section>) {
        dataList.addAll(newDataSetItems)
        //postAndNotifyAdapter(Handler())
    }

    class ViewHolder(var iview:RecyclerMainItemsBinding) : RecyclerView.ViewHolder(iview.root) {
            private var itembind: RecyclerMainItemsBinding= iview


    }
}