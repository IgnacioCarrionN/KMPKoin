package dev.carrion.kmpkoin.di

import dev.carrion.kmpkoin.data.DefaultJokeRepository
import dev.carrion.kmpkoin.data.InMemoryLocalPreferences
import dev.carrion.kmpkoin.data.JokeDataSource
import dev.carrion.kmpkoin.data.JokeJsonDataSource
import dev.carrion.kmpkoin.data.LocalPreferences
import dev.carrion.kmpkoin.domain.GetJokeUseCase
import dev.carrion.kmpkoin.domain.JokeRepository
import dev.carrion.kmpkoin.presentation.MainViewModel
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::MainViewModel)

    factoryOf(::GetJokeUseCase)

    singleOf(::DefaultJokeRepository) bind JokeRepository::class

    singleOf(::JokeJsonDataSource) bind JokeDataSource::class

    single { Json { ignoreUnknownKeys = true } }
}

val Module.localPreferencesDefinition
    get() = singleOf(::InMemoryLocalPreferences) bind LocalPreferences::class

expect val platformModule: Module
