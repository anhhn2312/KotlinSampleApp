package com.anhhn.kotlindemo.di.components

import com.anhhn.kotlindemo.base.BaseFragment
import com.anhhn.kotlindemo.di.modules.WebserviceModule
import com.anhhn.kotlindemo.di.scopes.UserScope
import com.anhhn.kotlindemo.services.WeatherApi
import com.anhhn.kotlindemo.services.WeatherRepository
import com.anhhn.kotlindemo.ui.currentWeather.CurrentWeatherFragment
import com.anhhn.kotlindemo.ui.currentWeather.CurrentWeatherViewModel
import com.anhhn.kotlindemo.ui.upcomingWeather.UpcomingWeatherFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Andy Ha on 2/21/19.
 */

@Singleton
@Component(modules = [WebserviceModule::class])
interface WebserviceComponent {
//    fun inject(currentWeatherFragment: CurrentWeatherFragment)
//    fun inject(upcomingWeatherFragment: UpcomingWeatherFragment)
    fun weatherRepository(): WeatherRepository
}