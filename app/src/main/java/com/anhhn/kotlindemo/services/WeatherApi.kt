package com.anhhn.kotlindemo.services

import com.anhhn.kotlindemo.pojo.BaseResponse
import com.anhhn.kotlindemo.pojo.WeatherResponseDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Andy Ha on 5/8/18.
 */
interface WeatherApi {
    @GET("data/2.5/weather?units=metric")
    fun getWeatherDetail(
        @Query("id") cityId: String,
        @Query("appid") apiKey: String
    ): Single<WeatherResponseDTO>

    @GET("data/2.5/forecast?units=metric")
    fun getWeatherForecast(
        @Query("id") cityId: String,
        @Query("appid") apiKey: String,
        @Query("cnt") count: Int
    ): Single<BaseResponse<List<WeatherResponseDTO>>>

}