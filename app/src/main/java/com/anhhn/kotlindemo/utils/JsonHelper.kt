package com.anhhn.kotlindemo.utils

import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by andy on 10/20/17.
 */

object JsonHelper {
    private var sGson: Gson? = null

    val gson: Gson
        @Synchronized get() {
            if (sGson == null) {
                sGson = Gson()
            }
            return sGson as Gson
        }

    @Synchronized
    fun isJson(data: String?): Boolean {
        if (data == null || "" == data) return false
        try {
            JSONObject(data)
        } catch (e: JSONException) {
            //      Logger.logException(e);
            try {
                JSONArray(data)
            } catch (e1: JSONException) {
                //        Logger.logException(e1);
                return false
            }

        }

        return true
    }
}
