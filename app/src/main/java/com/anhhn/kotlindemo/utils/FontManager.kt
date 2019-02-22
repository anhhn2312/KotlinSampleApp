package com.anhhn.kotlindemo.utils

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView

import java.util.HashMap

/**
 * Created by andy on 30/10/2017.
 */

class FontManager private constructor() {
    private val fonts: HashMap<String, Typeface> = HashMap()

    companion object {
        private var sInstance: FontManager? = null

        val instance: FontManager?
            get() {
                if (sInstance == null) {
                    synchronized(FontManager::class.java) {
                        if (sInstance == null) {
                            sInstance = FontManager()
                        }
                    }
                }
                return sInstance
            }
    }

    fun getFont(context: Context, fontPath: String): Typeface? {
        if (!fonts.containsKey(fontPath)) {
            val typeface = Typeface.createFromAsset(context.assets, fontPath)
            fonts[fontPath] = typeface
        }
        return fonts[fontPath]
    }

    fun setFonts(context: Context, fontPath: String, textView: TextView) {
        val typeface = getFont(context, fontPath)
        if (typeface != null)
            textView.typeface = typeface
    }
}
