package com.anhhn.kotlindemo.widget

import android.content.Context
import android.content.res.TypedArray
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.anhhn.kotlindemo.R
import com.anhhn.kotlindemo.utils.FontManager


class CustomEditText : AppCompatEditText {
    private var mEtFontPath: String? = null

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet?) {

        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
            mEtFontPath = typedArray.getString(R.styleable.CustomText_font_path)
            typedArray.recycle()
        }

        if (TextUtils.isEmpty(mEtFontPath))
            mEtFontPath = "fonts/SFUIText-Regular.otf"

        typeface = FontManager.instance!!.getFont(getContext(), mEtFontPath!!)
    }

    fun setFont(fontPath: String) {
        mEtFontPath = fontPath
        typeface = FontManager.instance!!.getFont(context, mEtFontPath!!)
    }
}
