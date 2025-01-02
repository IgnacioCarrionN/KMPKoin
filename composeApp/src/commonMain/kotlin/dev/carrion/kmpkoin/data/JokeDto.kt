package dev.carrion.kmpkoin.data

import dev.carrion.kmpkoin.domain.Joke
import kotlinx.serialization.Serializable

@Serializable
data class JokeDto(val id: Int, val content: String, val date: Long)

fun JokeDto.toDomain() = Joke(id = id, content = content, date = date)
