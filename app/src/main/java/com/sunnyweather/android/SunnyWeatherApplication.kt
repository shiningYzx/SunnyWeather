package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author shiningYang
 * @date 2025-02-26-21:02
 * @description:
 */
class SunnyWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        const val TOKEN = "jA4GeE5Ww0TFlP5n"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}