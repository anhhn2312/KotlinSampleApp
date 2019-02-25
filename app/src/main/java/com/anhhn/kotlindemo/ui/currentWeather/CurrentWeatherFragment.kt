package com.anhhn.kotlindemo.ui.currentWeather

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.base.BaseFragment
import com.anhhn.kotlindemo.base.KotlinDemoApplication
import com.anhhn.kotlindemo.databinding.FragmentCurrentWeatherBinding
import com.anhhn.kotlindemo.factory.CurrentWeatherViewModelFactory
import com.anhhn.kotlindemo.pojo.model.WeatherModel
import com.anhhn.kotlindemo.services.WeatherRepository
import com.anhhn.kotlindemo.utils.Constants
import com.anhhn.kotlindemo.utils.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Andy Ha on 2/21/19.
 */
@SuppressLint("CheckResult")
class CurrentWeatherFragment : BaseFragment<FragmentCurrentWeatherBinding>() {

    @Inject
    lateinit var viewModelFactory: CurrentWeatherViewModelFactory

    lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as KotlinDemoApplication).viewModelFactoryComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CurrentWeatherViewModel::class.java)
        viewBinding.viewModel = viewModel
        viewBinding.setLifecycleOwner(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_current_weather
    }
}