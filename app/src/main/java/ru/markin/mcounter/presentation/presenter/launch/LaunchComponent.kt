package ru.markin.mcounter.presentation.presenter.launch

import dagger.Component
import ru.markin.mcounter.app.di.AppComponent

@Component(dependencies = arrayOf(AppComponent::class))
interface LaunchComponent {

    fun inject(presenter: LaunchPresenter)
}
