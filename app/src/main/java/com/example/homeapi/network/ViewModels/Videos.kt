package  com.example.mvvmexample.data.network.models

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.homeapi.R
import com.squareup.picasso.Picasso

data class Videos(
    var SectionMoreEntityId: Int,
    var VideoType: Int,
    var VideoEntityId: Int,
    var VideoName: String,
    var VideoDescription: String,
    var VideoImagePath: String,
    var NewChannelThumbnailPath: String,
    var VideoCategoryId: Int,
    var VideoPackageId: Int,
    var VideoTotalViews: Long,
    var VideoAddedDate: String,
    var IsVideoFree: Boolean,
    var IsComingSoon:Boolean,
    var IsVideoChannel:Boolean,
    var PackageName: String,
    var NewVideoImageThumbnail: String,
    var NewVideoOnDemandThumb :String,
    var NewCatchUpThumb : String


)
{

}