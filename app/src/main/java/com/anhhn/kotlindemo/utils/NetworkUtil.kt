package com.anhhn.kotlindemo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by andy on 10/28/16.
 */
object NetworkUtil {
    fun checkNetwork(context: Context?): NetworkType {

        if (context == null) return NetworkType.DISCONNECT

        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetInfo = manager.activeNetworkInfo
        return if (activeNetInfo == null || !activeNetInfo.isAvailable) {
            NetworkType.DISCONNECT
        } else {
            if (activeNetInfo.type == ConnectivityManager.TYPE_MOBILE) {
                NetworkType.MOBILE
            } else {
                NetworkType.WIFI
            }
        }
    }

    enum class NetworkType {
        DISCONNECT,
        WIFI,
        MOBILE
    }
}
