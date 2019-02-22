package com.anhhn.kotlindemo.pojo

import com.google.gson.annotations.SerializedName

/**
 * Created by Andy Ha on 5/8/18.
 */
class WeatherResponseDTO {
    @SerializedName("sys")
    var sys: SysDTO? = null
    @SerializedName("weather")
    var weathers: List<WeatherDTO>? = null
    @SerializedName("main")
    var main: MainDTO? = null
    @SerializedName("wind")
    var wind: WindDTO? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("name")
    var name: String? = null
}
