package com.anhhn.kotlindemo.di.components

import com.anhhn.kotlindemo.di.modules.ViewModelFactoryModule
import com.anhhn.kotlindemo.di.scopes.UserScope
import com.anhhn.kotlindemo.ui.currentWeather.CurrentWeatherFragment
import com.anhhn.kotlindemo.ui.upcomingWeather.UpcomingWeatherFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Andy Ha on 2/21/19.
 */

@UserScope
@Component(
    dependencies = [WebserviceComponent::class],
    modules = [ViewModelFactoryModule::class]
)
interface ViewModelFactoryComponent {
    fun inject(currentWeatherFragment: CurrentWeatherFragment)
    fun inject(upcomingWeatherFragment: UpcomingWeatherFragment)
}