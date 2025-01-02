package dev.carrion.kmpkoin.di

import dev.carrion.kmpkoin.data.AndroidPreferences
import dev.carrion.kmpkoin.data.LocalPreferences
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/*
I know that we can use DataStore with KMP but I just want to try the KoinApplication function
from koin-compose and check if injects correctly the Android Context
*/
actual val platformModule: Module
    get() = module {
        singleOf(::AndroidPreferences) bind LocalPreferences::class
    }