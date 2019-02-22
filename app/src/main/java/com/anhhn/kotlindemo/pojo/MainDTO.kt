package com.anhhn.kotlindemo.pojo

import com.google.gson.annotations.SerializedName

/**
 * Created by Andy Ha on 5/8/18.
 */
class MainDTO {
    @SerializedName("temp")
    var temperature: Double = 0.toDouble()
    @SerializedName("pressure")
    var pressure: Double = 0.toDouble()
    @SerializedName("humidity")
    var humid: Double = 0.toDouble()
    @SerializedName("temp_min")
    var minTemp: Double = 0.toDouble()
    @SerializedName("temp_max")
    var maxTemp: Double = 0.toDouble()
}
