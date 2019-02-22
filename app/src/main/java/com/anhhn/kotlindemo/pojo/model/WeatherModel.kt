package com.anhhn.kotlindemo.pojo.model

import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.pojo.WeatherResponseDTO
import com.anhhn.kotlindemo.utils.AppUtils
import com.anhhn.kotlindemo.utils.ImageUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.parcel.Parcelize

/**
 * Created by Andy Ha on 5/8/18.
 */

@Parcelize
data class WeatherModel(
    var name: String? = null,
    var id: Int = 0,
    var weather: String? = null,
    var weatherDescription: String? = null,
    var icon: String? = null,
    var currentTemp: Int = 0,
    var minTemp: Int = 0,
    var maxTemp: Int = 0,
    var sunrise: Long = 0,
    var sunset: Long = 0,
    var pressure: Double = 0.toDouble(),
    var humid: Int = 0,
    var windSpeed: Double = 0.toDouble()
) : Parcelable {

    fun convert(weatherResponse: WeatherResponseDTO?): WeatherModel? {
        if (weatherResponse == null) return null

        val weatherDTO = WeatherModel()
        weatherDTO.id = weatherResponse.id
        weatherDTO.name = weatherResponse.name
        weatherDTO.sunrise = weatherResponse.sys!!.sunrise
        weatherDTO.sunset = weatherResponse.sys!!.sunset
        weatherDTO.weather = weatherResponse.weathers!![0].main
        weatherDTO.weatherDescription = weatherResponse.weathers!![0].description
        weatherDTO.icon = weatherResponse.weathers!![0].icon
        weatherDTO.currentTemp = weatherResponse.main!!.temperature.toInt()
        weatherDTO.minTemp = weatherResponse.main!!.minTemp.toInt()
        weatherDTO.maxTemp = weatherResponse.main!!.maxTemp.toInt()
        weatherDTO.windSpeed = weatherResponse.wind!!.speed
        weatherDTO.humid = weatherResponse.main!!.humid.toInt()
        weatherDTO.pressure = weatherResponse.main!!.pressure

        return weatherDTO
    }
}

@BindingAdapter("imageUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        ImageUtils.loadImage(view, AppUtils.instance.getWeatherIconByName(imageUrl))
    }
}

@BindingAdapter("sunrise")
fun bindSunrise(view: TextView, sunrise: Long){
    view.text = String.format(view.context.getString(R.string.text_sunrise),
        AppUtils.instance.formatTimestampFromServer(sunrise))
}

@BindingAdapter("sunset")
fun bindSunset(view: TextView, sunset: Long){
    view.text = String.format(view.context.getString(R.string.text_sunrise),
        AppUtils.instance.formatTimestampFromServer(sunset))
}