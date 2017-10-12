package ru.markin.mcounter.app.di

import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
}