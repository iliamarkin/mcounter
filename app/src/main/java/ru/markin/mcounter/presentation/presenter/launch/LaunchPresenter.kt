package ru.markin.mcounter.presentation.presenter.launch

import com.arellomobile.mvp.InjectViewState
import com.google.firebase.auth.FirebaseAuth
import ru.markin.mcounter.app.App
import ru.markin.mcounter.presentation.base.BasePresenter
import ru.markin.mcounter.presentation.view.launch.LaunchView

@InjectViewState
class LaunchPresenter : BasePresenter<LaunchView>() {

    init {
        //todo change it
        if (FirebaseAuth.getInstance().currentUser == null || true) {
            viewState.doOnBadToken()
        }
    }

    override fun createComponent() {
        val component = DaggerLaunchComponent.builder()
                .appComponent(App.appComponent)
                .build()
        component.inject(this)
    }
}