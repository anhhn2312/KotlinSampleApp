package com.anhhn.kotlindemo.di.modules

import com.anhhn.kotlindemo.factory.CurrentWeatherViewModelFactory
import com.anhhn.kotlindemo.factory.UpcomingWeatherViewModelFactory
import com.anhhn.kotlindemo.services.WeatherRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Andy Ha on 2/21/19.
 */
@Module
class ViewModelFactoryModule {

    @Provides
    fun provideCurrentWeatherViewModelFactory(weatherRepository: WeatherRepository): CurrentWeatherViewModelFactory {
        return CurrentWeatherViewModelFactory(weatherRepository)
    }

    @Provides
    fun provideUpcomingWeatherViewModelFactory(weatherRepository: WeatherRepository): UpcomingWeatherViewModelFactory {
        return UpcomingWeatherViewModelFactory(weatherRepository)
    }

}