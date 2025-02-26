package com.sunnyweather.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Place

/**
 * @author shiningYang
 * @date 2025-02-26-21:43
 * @description:
 */
class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    // 个placeList 集合用于对界面上显示的城市数据进行缓存
    // 因为原则上与界面相关的数据都应该放到ViewModel中
    // 这样可以保证它们在手机屏幕发生旋转的时候不会丢失
    val placeList = ArrayList<Place>()

    val placeLiveData = searchLiveData.switchMap {
        query ->
        Repository.searchPlace(query)
    }

    fun searchPlace(query: String) {
        searchLiveData.value = query
    }
}