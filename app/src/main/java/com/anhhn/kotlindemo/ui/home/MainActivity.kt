package com.anhhn.kotlindemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.base.BaseActivity
import com.anhhn.kotlindemo.databinding.ActivityMainBinding
import com.anhhn.kotlindemo.ui.upcomingWeather.UpcomingWeatherFragment
import com.anhhn.kotlindemo.ui.currentWeather.CurrentWeatherFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        var mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewBinding.viewPager.adapter = mSectionsPagerAdapter
        viewBinding.tabLayout.run {
            setupWithViewPager(viewBinding.viewPager)
            getTabAt(0)?.setCustomView(R.layout.item_tab_current_weather)
            getTabAt(1)?.setCustomView(R.layout.item_tab_upcoming_weather)
        }
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount() = 2

        override fun getItem(position: Int): Fragment? {
            return when (position) {
                0 -> CurrentWeatherFragment()
                1 -> UpcomingWeatherFragment()
                else -> null
            }
        }
    }

    override fun getLayoutResId() = R.layout.activity_main

    override fun getFirstFragment(): Nothing? = null

    override fun getFragmentContainerId() = 0
}
