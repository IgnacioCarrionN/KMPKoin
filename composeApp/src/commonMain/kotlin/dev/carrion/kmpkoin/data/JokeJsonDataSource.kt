package dev.carrion.kmpkoin.data

import dev.carrion.kmpkoin.domain.Joke
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.put

// Class to get Jokes from a Json until we call a real remote service
class JokeJsonDataSource(private val json: Json) : JokeDataSource {

    private val jokeJson = buildJsonObject {
        put("id", 1)
        put("content", "Test")
        put("date", 1223445)
    }

    override suspend fun getJoke(): Joke {
        return json.decodeFromJsonElement<JokeDto>(jokeJson).toDomain()
    }
}
