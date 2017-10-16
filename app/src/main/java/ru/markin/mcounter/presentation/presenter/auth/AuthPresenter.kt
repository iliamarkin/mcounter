package ru.markin.mcounter.presentation.presenter.auth

import com.arellomobile.mvp.InjectViewState
import ru.markin.mcounter.app.App
import ru.markin.mcounter.presentation.base.BasePresenter
import ru.markin.mcounter.presentation.view.auth.AuthView

@InjectViewState
class AuthPresenter : BasePresenter<AuthView>() {

    override fun createComponent() {
        val component = DaggerAuthComponent.builder()
                .appComponent(App.appComponent)
                .build()
        component.inject(this)
    }
}