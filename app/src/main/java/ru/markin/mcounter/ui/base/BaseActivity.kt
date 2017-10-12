package ru.markin.mcounter.ui.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeContentView()
        initializeToolbar(savedInstanceState)
        initializeView(savedInstanceState)
    }

    protected abstract fun initializeContentView()

    protected abstract fun initializeToolbar(savedInstanceState: Bundle?)

    protected abstract fun initializeView(savedInstanceState: Bundle?)
}