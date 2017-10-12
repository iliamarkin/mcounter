package ru.markin.mcounter.ui.screen.launch

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.markin.mcounter.R
import ru.markin.mcounter.presentation.presenter.launch.LaunchPresenter
import ru.markin.mcounter.presentation.view.launch.LaunchView
import ru.markin.mcounter.ui.base.BaseActivity

class LaunchActivity : BaseActivity(), LaunchView {

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    override fun initializeContentView() {
        setContentView(R.layout.activity_launch)
    }

    override fun initializeToolbar(savedInstanceState: Bundle?) {
    }

    override fun initializeView(savedInstanceState: Bundle?) {
    }
}
