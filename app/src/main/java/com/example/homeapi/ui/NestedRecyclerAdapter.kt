package com.example.homeapi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.homeapi.R
import com.example.homeapi.databinding.NestedItemListBinding
import com.example.mvvmexample.data.network.models.Categories
import com.example.mvvmexample.data.network.models.VideoEntity

class NestedRecyclerAdapter(var categoriesList: MutableList<Categories>?, var dataList: ArrayList<VideoEntity>, var isCatogries: Boolean? ): RecyclerView.Adapter<NestedRecyclerAdapter.ItemViewholder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        var itemsBinding: NestedItemListBinding= DataBindingUtil.inflate( LayoutInflater.from(parent.getContext()),
            R.layout.nested_item_list, parent, false)
        var viewHolder: ItemViewholder= ItemViewholder(itemsBinding)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return if (isCatogries != null && isCatogries!!) categoriesList?.size ?: 0
        else if (null != dataList) dataList.size else 0
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {

        var categoriesEntity: Categories? = null
        var videoEntity: VideoEntity? = null
        if (isCatogries!!)
        { categoriesEntity = categoriesList?.get(position)
            holder.binding.live.visibility = if (categoriesEntity?.IsVideoChannel!!) View.VISIBLE else View.GONE

           }//dataList.get(i).getCategories().get(i);
        else{ videoEntity = dataList?.get(position)
            holder.binding.live.visibility=  if (videoEntity.IsVideoChannel || videoEntity.VideoPackageId != 0) View.VISIBLE else View.GONE


        }



    }

    class ItemViewholder(var binding: NestedItemListBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

}