package com.anhhn.kotlindemo.ui.upcomingWeather

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anhhn.kotlindemo.pojo.model.WeatherModel
import com.anhhn.kotlindemo.services.WeatherRepository
import com.anhhn.kotlindemo.utils.Constants
import com.anhhn.kotlindemo.utils.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Andy Ha on 2/20/19.
 */
@SuppressLint("CheckResult")
class UpcomingWeatherViewModel(weatherRepository: WeatherRepository) : ViewModel() {
    val mWeatherModels: MutableLiveData<List<WeatherModel>> = MutableLiveData()

    init {
        weatherRepository.getUpcomingWeather(Constants.HANOI_ID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1: List<WeatherModel>?, t2: Throwable? ->
                mWeatherModels.value = t1
                Logger.logException(t2)
            }
    }
}