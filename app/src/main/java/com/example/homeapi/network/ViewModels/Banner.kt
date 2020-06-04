package  com.example.mvvmexample.data.network.models


import android.os.Parcelable
import java.io.Serializable

data class Banner(
    var TabPosterPath: String,
    var VideoEntityId: Int,
    var TabURL: String,
    var IsPosterVideo: Boolean = false,
    var IsVideoChannel: Boolean = true,
    var GameRedirect: Boolean = false
) : Serializable