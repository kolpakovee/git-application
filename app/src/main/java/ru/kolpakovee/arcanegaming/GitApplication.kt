package ru.kolpakovee.arcanegaming

import android.app.Application
import ru.kolpakovee.arcanegaming.data.AppContainer
import ru.kolpakovee.arcanegaming.data.DefaultAppContainer

class GitApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}