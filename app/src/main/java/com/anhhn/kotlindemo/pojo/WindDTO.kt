package com.anhhn.kotlindemo.pojo

import com.google.gson.annotations.SerializedName

/**
 * Created by Andy Ha on 5/8/18.
 */
class WindDTO {
    @SerializedName("speed")
    var speed: Double = 0.toDouble()
    @SerializedName("deg")
    var degree: Double = 0.toDouble()
}
