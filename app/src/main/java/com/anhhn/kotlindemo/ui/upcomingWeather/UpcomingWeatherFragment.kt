package com.anhhn.kotlindemo.ui.upcomingWeather

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.adapter.WeatherAdapter
import com.anhhn.kotlindemo.base.BaseFragment
import com.anhhn.kotlindemo.base.KotlinDemoApplication
import com.anhhn.kotlindemo.databinding.FragmentUpcomingWeatherBinding
import com.anhhn.kotlindemo.factory.UpcomingWeatherViewModelFactory
import javax.inject.Inject

/**
 * Created by Andy Ha on 2/11/19.
 */
class UpcomingWeatherFragment : BaseFragment<FragmentUpcomingWeatherBinding>() {

    @Inject
    lateinit var factory: UpcomingWeatherViewModelFactory

    lateinit var viewModel: UpcomingWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.application as KotlinDemoApplication).viewModelFactoryComponent
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory)
            .get(UpcomingWeatherViewModel::class.java)
        viewBinding.setLifecycleOwner(this)

        val adapter = WeatherAdapter(context)
        viewBinding.weatherList.adapter = adapter
        viewModel.mWeatherModels.observe(viewLifecycleOwner, Observer { plants ->
            if (plants != null) adapter.refreshList(plants)
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_upcoming_weather
    }
}