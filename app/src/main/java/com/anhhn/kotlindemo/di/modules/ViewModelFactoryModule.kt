package com.anhhn.kotlindemo.di.modules

import com.anhhn.kotlindemo.factory.CurrentWeatherViewModelFactory
import com.anhhn.kotlindemo.services.WeatherRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Andy Ha on 2/21/19.
 */
@Module
class ViewModelFactoryModule {

    @Provides
    fun provideCurrentWeatherViewModel(weatherRepository: WeatherRepository): CurrentWeatherViewModelFactory{
        return CurrentWeatherViewModelFactory(weatherRepository)
    }

}