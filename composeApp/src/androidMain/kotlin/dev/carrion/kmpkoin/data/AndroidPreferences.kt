package dev.carrion.kmpkoin.data

import android.content.Context
import androidx.core.content.edit

class AndroidPreferences(context: Context) : LocalPreferences {

    private val preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    override fun getString(key: String): String {
        return preferences.getString(key, "").orEmpty()
    }

    override fun putString(key: String, value: String) {
        preferences.edit {
            putString(key, value)
        }
    }

}
