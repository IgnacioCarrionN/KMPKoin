package dev.carrion.kmpkoin.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetJokeUseCase(
    private val jokeRepository: JokeRepository
) {
    suspend operator fun invoke(): Joke = withContext(Dispatchers.IO) {
        jokeRepository.getJoke()
    }
}