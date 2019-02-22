package com.anhhn.kotlindemo.base

import android.app.Application
import com.anhhn.kotlindemo.BuildConfig
import com.anhhn.kotlindemo.di.components.DaggerViewModelFactoryComponent
import com.anhhn.kotlindemo.di.components.DaggerWebserviceComponent
import com.anhhn.kotlindemo.di.components.ViewModelFactoryComponent
import com.anhhn.kotlindemo.di.components.WebserviceComponent
import com.anhhn.kotlindemo.di.modules.ViewModelFactoryModule
import com.anhhn.kotlindemo.di.modules.WebserviceModule
import com.anhhn.kotlindemo.utils.AppUtils

/**
 * Created by Andy Ha on 2/21/19.
 */
class KotlinDemoApplication : Application() {

    lateinit var viewModelFactoryComponent: ViewModelFactoryComponent

    override fun onCreate() {
        super.onCreate()

        AppUtils.instance.init(this)

        val webserviceComponent = DaggerWebserviceComponent.builder()
            .webserviceModule(WebserviceModule(BuildConfig.BASE_URL))
            .build();

        viewModelFactoryComponent = DaggerViewModelFactoryComponent.builder()
            .webserviceComponent(webserviceComponent)
            .viewModelFactoryModule(ViewModelFactoryModule())
            .build()
    }


}