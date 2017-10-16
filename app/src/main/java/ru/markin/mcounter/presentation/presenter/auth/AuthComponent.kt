package ru.markin.mcounter.presentation.presenter.auth

import dagger.Component
import ru.markin.mcounter.app.di.AppComponent

@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(AuthModule::class))
interface AuthComponent {

    fun inject(presenter: AuthPresenter)
}