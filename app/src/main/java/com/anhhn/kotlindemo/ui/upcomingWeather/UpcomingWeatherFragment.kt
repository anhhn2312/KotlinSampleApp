package com.anhhn.kotlindemo.ui.upcomingWeather

import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.base.BaseFragment
import com.anhhn.kotlindemo.databinding.FragmentUpcomingWeatherBinding

/**
 * Created by Andy Ha on 2/11/19.
 */
class UpcomingWeatherFragment: BaseFragment<FragmentUpcomingWeatherBinding>() {
    override fun getLayoutResId(): Int {
        return R.layout.fragment_upcoming_weather
    }
}