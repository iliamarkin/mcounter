package ru.markin.mcounter.ui.screen.launch

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.markin.mcounter.presentation.presenter.launch.LaunchPresenter
import ru.markin.mcounter.presentation.view.launch.LaunchView
import ru.markin.mcounter.ui.base.BaseActivity
import ru.markin.mcounter.ui.screen.auth.AuthActivity

class LaunchActivity : BaseActivity(), LaunchView {

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    override fun initializeContentView() {
    }

    override fun initializeToolbar(savedInstanceState: Bundle?) {
    }

    override fun initializeView(savedInstanceState: Bundle?) {
    }

    override fun doOnBadToken() {
        startActivity(Intent(this, AuthActivity::class.java))
    }
}
