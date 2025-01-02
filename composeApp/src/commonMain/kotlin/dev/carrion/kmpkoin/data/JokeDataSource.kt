package dev.carrion.kmpkoin.data

import dev.carrion.kmpkoin.domain.Joke

interface JokeDataSource {
    suspend fun getJoke(): Joke
}
