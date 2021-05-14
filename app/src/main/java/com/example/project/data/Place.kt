package com.example.project.data

import android.content.Context
import com.example.project.R

class Place(private val context: Context) {

    fun getPlayerPlaceForRoles1(): String {
        val places = ArrayList<String>()
        places.addAll(context.resources.getStringArray(R.array.places_roles_1))
        return places.random()
    }

    fun getPlayerPlaceForRoles2(): String {
        val places = ArrayList<String>()
        places.addAll(context.resources.getStringArray(R.array.places_roles_2_1))
        return places.random()
    }

    fun getSpyPlaceForRoles2(): String {
        val places = ArrayList<String>()
        places.addAll(context.resources.getStringArray(R.array.places_roles_2_2))
        return places.random()
    }

}