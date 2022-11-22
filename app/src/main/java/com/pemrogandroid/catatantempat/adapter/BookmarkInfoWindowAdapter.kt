package com.pemrogandroid.catatantempat.adapter

import android.app.Activity
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.pemrogandroid.catatantempat.databinding.ContentBookmarkInfoBinding
import com.pemrogandroid.catatantempat.ui.MapsActivity
import com.pemrogandroid.catatantempat.viewmodel.MapsViewModel

class BookmarkInfoWindowAdapter(val context: Activity) : GoogleMap.InfoWindowAdapter {

    private val binding = ContentBookmarkInfoBinding.inflate(context.layoutInflater)

    override fun getInfoWindow(marker: Marker): View? {
        return null
    }

    override fun getInfoContents(marker: Marker): View? {
        binding.title.text = marker.title ?: ""
        binding.phone.text = marker.snippet ?: ""
        val imageView = binding.photo
        when (marker.tag) {
            is MapsActivity.PlaceInfo -> {
                imageView.setImageBitmap(
                    (marker.tag as MapsActivity.PlaceInfo).image
                )
            }
            is MapsViewModel.BookmarkView -> {
                val bookMarkview = marker.tag as
                        MapsViewModel.BookmarkView
                imageView.setImageBitmap(bookMarkview.getImage(context))
            }
        }
        return binding.root
    }
}