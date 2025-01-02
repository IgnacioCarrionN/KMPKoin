package dev.carrion.kmpkoin.data

interface LocalPreferences {
    fun getString(key: String): String
    fun putString(key: String, value: String)
}