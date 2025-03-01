package com.sunnyweather.android.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.ui.weather.WeatherActivity

/**
 * @author shiningYang
 * @date 2025-02-26-22:22
 * @description:
 */
class PlaceAdapter(private val fragment: PlaceFragment, private val placeList: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeName: TextView = view.findViewById(R.id.placeName)
        val placeAddress: TextView = view.findViewById(R.id.placeAddress)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        val holder = ViewHolder(view)

        holder.itemView.setOnClickListener {
            val position = holder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val place = placeList[position]
                val activity = fragment.activity
                if (activity is WeatherActivity) {
                    activity.drawerLayout.closeDrawers()
                    activity.viewModel.locationLng = place.location.lng
                    activity.viewModel.locationLat = place.location.lat
                    activity.viewModel.placeName = place.name
                    activity.refreshWeather()
                } else {
                    val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                        putExtra("location_lng", placeList[position].location.lng)
                        putExtra("location_lat", placeList[position].location.lat)
                        putExtra("place_name", placeList[position].name)
                    }
                    fragment.startActivity(intent)
                    fragment.activity?.finish()
                }
                fragment.viewModel.savePlace(placeList[position])
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = placeList.size
}