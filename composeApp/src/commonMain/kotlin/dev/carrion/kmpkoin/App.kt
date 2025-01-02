package dev.carrion.kmpkoin

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.carrion.kmpkoin.di.appModule
import dev.carrion.kmpkoin.di.platformModule
import dev.carrion.kmpkoin.presentation.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration


@Composable
@Preview
fun App(koinAppDeclaration: KoinAppDeclaration? = null) {
    KoinApplication(
        application = {
            koinAppDeclaration?.invoke(this)
            modules(appModule, platformModule)
        }
    ) {
        MaterialTheme {
            MainScreen()
        }
    }
}
