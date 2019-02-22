package com.anhhn.kotlindemo.pojo

import com.google.gson.annotations.SerializedName

/**
 * Created by Andy Ha on 5/8/18.
 */
class WeatherDTO {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("main")
    var main: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("icon")
    var icon: String? = null
}
