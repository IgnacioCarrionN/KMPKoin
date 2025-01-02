package dev.carrion.kmpkoin.domain

interface JokeRepository {
    suspend fun getJoke(): Joke
}
