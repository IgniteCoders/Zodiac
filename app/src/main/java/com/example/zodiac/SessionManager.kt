package com.example.zodiac

import android.R
import android.content.Context


class SessionManager(context: Context) {

    private val sharedPref = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)

    fun setFavorite(id: String, favorite: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean("${id}_favorite", favorite)
        editor.apply()
    }
    fun setHated(id: String, hated: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean("${id}_hated", hated)
        editor.apply()
    }
    fun isFavorite(id: String): Boolean {
        return sharedPref.getBoolean("${id}_favorite", false)
    }
    fun isHated(id: String): Boolean {
        return sharedPref.getBoolean("${id}_hated", false)
    }
}