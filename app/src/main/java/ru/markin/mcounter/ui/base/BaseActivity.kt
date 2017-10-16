package ru.markin.mcounter.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class BaseActivity : MvpAppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeContentView()
        initializeToolbar(savedInstanceState)
        initializeView(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
        hideProgressBar()
    }

    protected fun showProgressPar() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog?.isIndeterminate = true
        }
    }

    protected fun hideProgressBar() {
        if (progressDialog?.isShowing == true) {
            progressDialog?.dismiss()
        }
    }

    protected abstract fun initializeContentView()

    protected abstract fun initializeToolbar(savedInstanceState: Bundle?)

    protected abstract fun initializeView(savedInstanceState: Bundle?)
}