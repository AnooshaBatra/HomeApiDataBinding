package  com.example.mvvmexample.data.network.models

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.homeapi.R
import com.squareup.picasso.Picasso
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoEntity(

     var VideoEntityId :Int= 0,
     var IsVideoChannel:Boolean = false,
     var VideoName: String,
     var VideoDescription: String? = null,
     var VideoImagePathLarge: String? = null,
     var VideoImageThumbnail: String? = null,
     var NewVideoImageThumbnail: String? = null,
     var VideoCategoryImagePath: String? = null,
     var VideoImagePath: String? = null,
     var VideoCategoryId:Int = 0,
     var VideoPackageId:Int = 0,
     var VideoSeasonNo:Int = 0,
     var VideoTotalViews: Long = 0,
     var VideoRating:Long = 0,
     var VideoAddedDate: String? = null,
     var VideoDuration: String? = null,
     var IsVideoFree:Boolean = false,
     var IsFavourite:Boolean = false,
     var IsComingSoon:Boolean = false,
     var VideoType:Int = 0,
     var VideoQuality:Int = 0,
     var VideoDownloadId: Long = 0,
     var VideoLocalPath: String? = null,
     var IsVideoOnline:Boolean = false,
     var VideoRssFeedURL: String? = null,
     var VideoUpdatedDate: String? = null,
     var VideoIsAllowedInternationally:Boolean = false,
     var VideoAllowCountryCodeList:Boolean = false,
     var VideoCountryCodeList: String? = null,
     var VideoDownloadDate: String? = null,
     var VideoDownloadStatus:Int = 0,
     var VideoDownloadURL: String? = null,
     var NewChannelThumbnailPath: String? = null,
     var NewVideoOnDemandThumb: String? = null,
     var NewCatchUpThumb: String? = null,
     var PackageName: String? = null,
     var PackageIsFree:Boolean = false,
     var PackageProduct:Int = 0,
     var PackagePrice:Int = 0,
     var IsRadio:Boolean = false,
     var Event_key:Int = 0


): Parcelable
{
     object DataBindingAdapter {
          @JvmStatic
          @BindingAdapter("bind:image")
          fun loadImage(view: View, imagetext: String?) {
               var image: ImageView = view as ImageView
               Log.d("result", "image VideoEntity path is "+imagetext)
               //image.setImageURI()

               imagetext?.let {  Picasso.with(view.context).load(it).into(image) }
               /*if(imagetext != null && imagetext.isNotEmpty() )
                    Picasso.with(view.context).load(imagetext).into(image)*/
              /* else
                    Picasso.with(view.context).load(R.drawable.loading).into(image)*/
          }
     }
}