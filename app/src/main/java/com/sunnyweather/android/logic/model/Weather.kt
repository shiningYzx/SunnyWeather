package com.sunnyweather.android.logic.model

/**
 * @author shiningYang
 * @date 2025-02-27-0:15
 * @description:
 */
data class Weather (val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily) 