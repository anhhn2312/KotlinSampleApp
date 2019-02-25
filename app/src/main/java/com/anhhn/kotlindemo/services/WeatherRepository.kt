package com.anhhn.kotlindemo.services

import com.anhhn.kotlindemo.pojo.model.WeatherModel
import com.anhhn.kotlindemo.utils.Constants
import io.reactivex.Single

/**
 * Created by Andy Ha on 2/21/19.
 */
class WeatherRepository(val weatherApi: WeatherApi) {
    fun getWeatherDetail(id: String): Single<WeatherModel?> {
        return weatherApi.getWeatherDetail(id, Constants.API_KEY)
            .flatMap {
                Single.just(WeatherModel().convert(it))
            }
    }

    fun getUpcomingWeather(id: String): Single<List<WeatherModel>> {
        return weatherApi.getWeatherForecast(id, Constants.API_KEY, Constants.FORECASE_DAYS)
            .flatMap { weatherResponseDTOs ->
                var weatherModels: List<WeatherModel>? = weatherResponseDTOs.data?.map { WeatherModel().convert(it) }
                Single.just(weatherModels)
            }
    }


}