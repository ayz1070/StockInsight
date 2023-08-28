package com.example.stockinsight.model

import com.google.gson.annotations.SerializedName

data class User(
    var idx:Int,
    @SerializedName("user_id")
    var userId:String,
    @SerializedName("pw")
    var password:String,

)
