package com.anhhn.kotlindemo.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by andy on 12/3/2017.
 */

class ScreenUtils private constructor() {

    companion object {
        private var sInstance: ScreenUtils? = null

        val instance: ScreenUtils?
            get() {
                if (sInstance == null) {
                    synchronized(ScreenUtils::class.java) {
                        if (sInstance == null)
                            sInstance = ScreenUtils()
                    }
                }
                return sInstance
            }
    }

    var screenWidth: Int = 0
        private set
    var screenHeight: Int = 0
        private set

    fun init(context: Context) {
        val displayMetrics = DisplayMetrics()
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels
        screenHeight = displayMetrics.heightPixels
    }
}
