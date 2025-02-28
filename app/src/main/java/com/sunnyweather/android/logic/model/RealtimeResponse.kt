package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * @author shiningYang
 * @date 2025-02-27-0:04
 * @description:
 */
data class RealtimeResponse(val status: String, val result: Result) {
    // 将所有的数据模型类都定义在了RealtimeResponse的内部
    // 这样可以防止出现和其他接口的数据模型类有同名冲突的情况
    data class Result(val realtime: Realtime)

    data class Realtime(val skycon: String, val temperature: Float,
        @SerializedName("air_quality") val airQuality: AirQuality)

    data class AirQuality(val aqi: AQI)

    data class AQI(val chn: Float)
}