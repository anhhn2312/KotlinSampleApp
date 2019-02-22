package com.anhhn.kotlindemo.utils

import android.os.Build
import android.util.Log
import com.anhhn.kotlindemo.BuildConfig

/**
 * Created by Ha Anh on 3/23/2018.
 */

object Logger {

    val TAG = "KotlinDemo"

    fun d(log: String) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, log)
    }

    fun i(log: String) {
        if (BuildConfig.DEBUG)
            Log.i(TAG, log)
    }

    fun w(log: String) {
        if (BuildConfig.DEBUG)
            Log.w(TAG, log)
    }

    fun e(log: String) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, log)
    }

    fun logException(e: Exception) {
        //todo
        e.printStackTrace()
    }

    fun logException(throwable: Throwable?) {
        //todo
        throwable?.printStackTrace()
    }
}
