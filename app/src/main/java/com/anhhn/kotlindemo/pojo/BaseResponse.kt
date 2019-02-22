package com.anhhn.kotlindemo.pojo

import com.google.gson.annotations.SerializedName

/**
 * Created by Andy Ha on 5/8/18.
 */
class BaseResponse<T> {
    @SerializedName("cnt")
    var count: Int = 0
    @SerializedName("list")
    var data: T? = null
    @SerializedName("cod")
    var code: Int = 0
    @SerializedName("message")
    var message: String? = null
}
