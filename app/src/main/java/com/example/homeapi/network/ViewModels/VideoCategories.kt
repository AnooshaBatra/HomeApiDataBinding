package  com.example.mvvmexample.data.network.models

data class VideoCategories(
    var VideoCategoryId: Int,
    var VideoCategoryName: String,
    var VideoCategoryURL: String,
    var VideoCategoryThumbnailPath: String,
    var NewVideoCategoryThumbnailPath: String,
    var VideoCategoryImagePath: String,
    var VideoCategoryImagePathLarge: String,
    var IsVast: Boolean,
    var AdvertisementVastURL: String,
    var PackageName: String,
    var PackageIsFree: Boolean,
    var PackageProduct: Int,
    var PackagePrice: Int,
    var Videos:List<VideoEntity>


)