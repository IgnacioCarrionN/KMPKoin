package dev.carrion.kmpkoin.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.carrion.kmpkoin.domain.Joke
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    val viewModelState by mainViewModel.mainState.collectAsStateWithLifecycle()
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { mainViewModel.sendIntent(MainViewModel.Intent.LoadJoke) }) {
            Text("Click me!")
        }
        Box(modifier = Modifier.fillMaxSize()) {
            when (val state = viewModelState) {
                is MainViewModel.State.Loading -> CircularProgressIndicator(
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
                is MainViewModel.State.Content -> showContent(state.joke)
                is MainViewModel.State.Error -> showError(state.message)
            }
        }
    }
}

@Composable
fun BoxScope.showContent(joke: Joke) {
    Text("Joke: ${joke.content}", modifier = Modifier.align(Alignment.TopCenter))
}

@Composable
fun BoxScope.showError(message: String) {
    Text("Error: $message", modifier = Modifier.align(Alignment.Center))
}
