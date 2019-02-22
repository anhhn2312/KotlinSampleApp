package com.anhhn.kotlindemo.ui.currentWeather

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
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
class CurrentWeatherViewModel(weatherRepository: WeatherRepository) : ViewModel() {

    val mWeatherModel: MutableLiveData<WeatherModel> = MutableLiveData()

    init {
        weatherRepository.getWeatherDetail(Constants.HANOI_ID)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { weatherModel: WeatherModel?, throwable: Throwable? ->
                mWeatherModel.let { mWeatherModel.value = weatherModel }
                Logger.i(mWeatherModel.value.toString())
                Logger.logException(throwable)
            }
    }

}