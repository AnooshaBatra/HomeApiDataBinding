package  com.example.mvvmexample.data.network.models


data class Tabs(
    var TabId:Int,
    var TabName:String,
    var TabPosterPath:String,
    var TabURL:String,
    var Sections:MutableList<Section>,
    var Banners: List<Banner>


)