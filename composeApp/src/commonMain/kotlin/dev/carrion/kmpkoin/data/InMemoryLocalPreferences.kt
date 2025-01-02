package dev.carrion.kmpkoin.data

class InMemoryLocalPreferences : LocalPreferences {
    private val map: MutableMap<String, String> = mutableMapOf()

    override fun getString(key: String): String {
        return map[key].orEmpty()
    }

    override fun putString(key: String, value: String) {
        map[key] = value
    }
}