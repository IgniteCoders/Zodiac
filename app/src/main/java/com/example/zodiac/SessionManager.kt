package com.example.zodiac

import android.R
import android.content.Context


class SessionManager(context: Context) {

    private val sharedPref = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)

    fun setFavorite(id: String) {
        val editor = sharedPref.edit()
        editor.putString("FAVORITE_HOROSCOPE", id)
        editor.apply()
    }

    fun getFavorite(): String {
        return sharedPref.getString("FAVORITE_HOROSCOPE", "")!!
    }

    fun isFavorite(id: String): Boolean {
        return id == getFavorite()
    }
}