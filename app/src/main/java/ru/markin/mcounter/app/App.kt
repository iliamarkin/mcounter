package ru.markin.mcounter.app

import android.app.Application
import ru.markin.mcounter.app.di.AppComponent
import ru.markin.mcounter.app.di.DaggerAppComponent

class App : Application() {

    companion object {
        var appComponent: AppComponent? = null
            private set(value) {
                field = value
            }
    }

    override fun onCreate() {
        super.onCreate()
        initInjector()
    }

    private fun initInjector() {
        appComponent = DaggerAppComponent.builder().build()
    }
}