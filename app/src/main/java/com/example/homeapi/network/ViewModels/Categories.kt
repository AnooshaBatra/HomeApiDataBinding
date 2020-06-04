package com.example.mvvmexample.data.network.models

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.example.homeapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.nested_item_list.view.*

data class Categories(
    var VoDCategoryId: Int,
    var SectionId: Int,
    var CategoryName: String,
    var CategorythumbImage: String,
    var NewCategoryImage: String,
    var CategoryIsOnline: Boolean,
    var IsCategoryFree: Boolean,
    var IsSeason: Boolean,
    var IsVideoChannel: Boolean,
    var PackageName: String,
    var PackageIsFree: Boolean,
    var PackageProduct: Int,
    var PackagePrice: Int


)

{
    object DataBindingAdapter {
        @JvmStatic
        @BindingAdapter("android:imageURL")
        fun loadImage(view: View, imagetext: String?) {
            var image: ImageView = view as ImageView

            Log.d("result", "image Catogries path is "+imagetext)

            imagetext?.let {  Picasso.with(view.context).load(it).into(image) }
            //image.setImageURI()
           /* if(imagetext != null && imagetext.isNotEmpty())
            Picasso.with(view.context).load(imagetext).into(image)*/
           /* else
                Picasso.with(view.context).load(R.drawable.loading).into(image)*/
        }
    }
}




