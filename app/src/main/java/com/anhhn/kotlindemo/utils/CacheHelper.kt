package com.anhhn.kotlindemo.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by andy on 11/5/2017.
 */

class CacheHelper private constructor() {
    private var mContext: Context? = null
    private var mSharedPreferences: SharedPreferences? = null

    companion object {
        private val PREF_NAME = "com.anhhn.kotlindemo"
        private var mInstance: CacheHelper? = null
        val instance: CacheHelper
            @Synchronized get() {
                if (mInstance == null) mInstance = CacheHelper()
                return mInstance as CacheHelper
            }
    }

    fun init(context: Context) {
        this.mContext = context
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // ======================== UTILITY FUNCTIONS ========================

    /**
     * Save a long integer to SharedPreferences
     *
     * @param key
     * @param n
     */
    fun putLongValue(key: String, n: Long) {
        mSharedPreferences!!.edit().putLong(key, n).apply()
    }

    /**
     * Read a long integer to SharedPreferences
     *
     * @param key
     * @return
     */
    fun getLongValue(key: String): Long {
        return mSharedPreferences!!.getLong(key, 0)
    }

    /**
     * Save an integer to SharedPreferences
     *
     * @param key
     * @param n
     */
    fun putIntValue(key: String, n: Int) {
        mSharedPreferences!!.edit().putInt(key, n).apply()
    }

    /**
     * Read an integer to SharedPreferences
     *
     * @param key
     * @return
     */
    fun getIntValue(key: String): Int {
        return mSharedPreferences!!.getInt(key, 0)
    }


    /**
     * Save an string to SharedPreferences
     *
     * @param key
     * @param s
     */
    fun putStringValue(key: String, s: String) {
        mSharedPreferences!!.edit().putString(key, s).apply()
    }

    /**
     * Save an string to SharedPreferences
     *
     * @param key
     * @param s
     * @param sync
     */
    fun putStringValue(key: String, s: String, sync: Boolean) {
        if (!sync)
            putStringValue(key, s)
        else
            mSharedPreferences!!.edit().putString(key, s).commit()
    }

    /**
     * Read an string to SharedPreferences
     *
     * @param key
     * @return
     */
    fun getStringValue(key: String): String {
        return mSharedPreferences!!.getString(key, "")
    }

    /**
     * Read an string to SharedPreferences
     *
     * @param key
     * @param defaultValue
     * @return
     */
    fun getStringValue(key: String, defaultValue: String): String? {
        return mSharedPreferences!!.getString(key, defaultValue)
    }

    /**
     * Save an boolean to SharedPreferences
     *
     * @param key
     * @param key,b
     */
    fun putBooleanValue(key: String, b: Boolean?) {
        mSharedPreferences!!.edit().putBoolean(key, b!!).apply()
    }

    /**
     * Read an boolean to SharedPreferences
     *
     * @param key
     * @return
     */
    fun getBooleanValue(key: String): Boolean {
        return mSharedPreferences!!.getBoolean(key, false)
    }

    /**
     * Save an float to SharedPreferences
     *
     * @param key
     * @param key,f
     */
    fun putFloatValue(key: String, f: Float) {
        mSharedPreferences!!.edit().putFloat(key, f).apply()
    }

    /**
     * Read an float to SharedPreferences
     *
     * @param key
     * @return
     */
    fun getFloatValue(key: String): Float {
        return mSharedPreferences!!.getFloat(key, 0.0f)
    }

    //  public void saveListLanguage(int key, List<LanguageModel> list) {
    //    mSharedPreferences.edit().putString(LIST_LANGUAGE + key, JsonHelper.getGson().toJson(list)).commit();
    //  }
    //
    //  public void saveListCountry(int key, List<CountryModel> list) {
    //    mSharedPreferences.edit().putString(LIST_COUNTRY + key, JsonHelper.getGson().toJson(list)).commit();
    //  }
}