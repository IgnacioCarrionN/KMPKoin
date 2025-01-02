package dev.carrion.kmpkoin.data

import dev.carrion.kmpkoin.domain.Joke
import dev.carrion.kmpkoin.domain.JokeRepository

class DefaultJokeRepository(private val jokeDataSource: JokeDataSource) : JokeRepository {
    override suspend fun getJoke(): Joke {
        return jokeDataSource.getJoke()
    }
}
