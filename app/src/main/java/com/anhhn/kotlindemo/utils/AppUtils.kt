package com.anhhn.kotlindemo.utils

import android.annotation.SuppressLint
import android.content.Context

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Andy Ha on 5/8/18.
 */

class AppUtils {
    private var mContext: Context? = null
    private val sdfHour = SimpleDateFormat("HH:mm", Locale.getDefault())
    private val sdfDate = SimpleDateFormat("EEE, dd/MM", Locale.getDefault())

    companion object {
        private var mInstance: AppUtils? = null
        val instance: AppUtils
            @Synchronized get() {
                if (mInstance == null) mInstance = AppUtils()
                return mInstance as AppUtils
            }
    }

    fun init(context: Context) {
        this.mContext = context
    }

    fun getWeatherIconByName(identifier: String): Int {
        return getDrawableResourceByName("icon$identifier")
    }

    private fun getDrawableResourceByName(identifier: String): Int {
        try {
            val packageName = mContext!!.packageName
            return mContext!!.resources.getIdentifier(identifier, "drawable", packageName)
        } catch (e: Exception) {
            return 0
        }

    }

    fun formatTimestampToHour(timeStamp: Long): String =
        sdfHour.format(Date(timeStamp * 1000))

    fun formatTimestampToDate(timeStamp: Long):String =
            sdfDate.format(Date(timeStamp * 1000))
}
