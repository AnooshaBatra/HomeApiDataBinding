package  com.example.mvvmexample.data.network.models


data class Section (
    var SectionId:Int,
    var SectionName:String,
    var IsSectionMore:Boolean,
    var Videos:ArrayList<VideoEntity>,
    var IsCategories:Boolean,
    var Categories:MutableList<Categories>
)