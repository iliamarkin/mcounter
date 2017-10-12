package ru.markin.mcounter.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import ru.markin.mcounter.app.App
import ru.markin.mcounter.app.di.AppComponent

abstract class BasePresenter<View : MvpView>() : MvpPresenter<View>() {

    init {
        initializeDaggerComponent()
    }

    private fun initializeDaggerComponent() {
        createComponent()
    }

    protected abstract fun createComponent()

    protected fun getAppComponent(): AppComponent = App.appComponent
}