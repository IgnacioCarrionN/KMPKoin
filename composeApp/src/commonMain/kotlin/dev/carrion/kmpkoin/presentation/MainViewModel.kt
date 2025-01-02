package dev.carrion.kmpkoin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.carrion.kmpkoin.data.LocalPreferences
import dev.carrion.kmpkoin.domain.GetJokeUseCase
import dev.carrion.kmpkoin.domain.Joke
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val useCase: GetJokeUseCase,
    private val localPreferences: LocalPreferences
) : ViewModel() {

    private val state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val mainState: StateFlow<State>
        get() = state.asStateFlow()


    fun sendIntent(intent: Intent) {
        when (intent) {
            is Intent.LoadJoke -> handleLoadJoke()
        }
    }

    private fun handleLoadJoke() {
        viewModelScope.launch {
            runCatching {
                useCase()
            }.fold(
                onSuccess = { content ->
                    state.update { State.Content(content) }
                },
                onFailure = { error ->
                    state.update { State.Error(error.message ?: "Unknown Error") }
                }
            )
        }
    }

    sealed interface Intent {
        data object LoadJoke : Intent
    }

    sealed interface State {
        data object Loading : State
        data class Error(val message: String) : State
        data class Content(val joke: Joke) : State
    }

}