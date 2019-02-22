package com.anhhn.kotlindemo.widget

import android.content.Context
import android.content.res.TypedArray
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.utils.FontManager


class CustomTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = -1) :
    AppCompatTextView(context, attrs, defStyleAttr) {
    private var mFontPath: String? = null

    init {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
            mFontPath = typedArray.getString(R.styleable.CustomText_font_path)
            typedArray.recycle()
        }

        if (TextUtils.isEmpty(mFontPath))
            mFontPath = "fonts/SFUIText-Regular.otf"

        typeface = FontManager.instance!!.getFont(getContext(), mFontPath!!)
        includeFontPadding = false
    }

    fun setFont(fontPath: String) {
        mFontPath = fontPath
        typeface = FontManager.instance!!.getFont(context, mFontPath!!)
    }
}
