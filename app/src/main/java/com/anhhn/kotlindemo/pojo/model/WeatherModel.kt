package com.anhhn.kotlindemo.pojo.model

import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.pojo.WeatherResponseDTO
import com.anhhn.kotlindemo.utils.AppUtils
import com.anhhn.kotlindemo.utils.ImageUtils
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
    var date: Long = 0,
    var currentTemp: Int = 0,
    var minTemp: Int = 0,
    var maxTemp: Int = 0,
    var sunrise: Long = 0,
    var sunset: Long = 0,
    var pressure: Double = 0.toDouble(),
    var humid: Int = 0,
    var windSpeed: Double = 0.toDouble()
) : Parcelable {

    fun convert(weatherResponse: WeatherResponseDTO): WeatherModel {
        val weatherModel = WeatherModel()
        weatherModel.id = weatherResponse.id
        weatherModel.name = weatherResponse.name
        weatherModel.sunrise = weatherResponse.sys!!.sunrise
        weatherModel.sunset = weatherResponse.sys!!.sunset
        weatherModel.weather = weatherResponse.weathers!![0].main
        weatherModel.weatherDescription = weatherResponse.weathers!![0].description
        weatherModel.icon = weatherResponse.weathers!![0].icon
        weatherModel.date = weatherResponse.date
        weatherModel.currentTemp = weatherResponse.main!!.temperature.toInt()
        weatherModel.minTemp = weatherResponse.main!!.minTemp.toInt()
        weatherModel.maxTemp = weatherResponse.main!!.maxTemp.toInt()
        weatherModel.windSpeed = weatherResponse.wind!!.speed
        weatherModel.humid = weatherResponse.main!!.humid.toInt()
        weatherModel.pressure = weatherResponse.main!!.pressure
        return weatherModel
    }
}

@BindingAdapter("imageUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        ImageUtils.loadImage(view, AppUtils.instance.getWeatherIconByName(imageUrl))
    }
}

@BindingAdapter("date")
fun bindDate(view: TextView, timeStamp: Long){
    view.text = AppUtils.instance.formatTimestampToDate(timeStamp)
}

@BindingAdapter("sunrise")
fun bindSunrise(view: TextView, timeStamp: Long){
    view.text = String.format(view.context.getString(R.string.text_sunrise),
        AppUtils.instance.formatTimestampToHour(timeStamp))
}

@BindingAdapter("sunset")
fun bindSunset(view: TextView, timeStamp: Long){
    view.text = String.format(view.context.getString(R.string.text_sunrise),
        AppUtils.instance.formatTimestampToHour(timeStamp))
}