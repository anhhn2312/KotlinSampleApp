package com.anhhn.kotlindemo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anhhn.kotlindemo.services.WeatherRepository
import com.anhhn.kotlindemo.ui.upcomingWeather.UpcomingWeatherViewModel

/**
 * Created by Andy Ha on 2/22/19.
 */
class UpcomingWeatherViewModelFactory(private val weatherRepository: WeatherRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        UpcomingWeatherViewModel(weatherRepository) as T
}