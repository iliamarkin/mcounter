package ru.markin.mcounter.ui.screen.auth

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import ru.markin.mcounter.R
import ru.markin.mcounter.ui.base.BaseActivity

class AuthActivity : BaseActivity() {

    private val requestCodeSignIn = 9001

    override fun initializeContentView() {
        setContentView(R.layout.activity_auth)
    }

    override fun initializeToolbar(savedInstanceState: Bundle?) {
        setSupportActionBar(findViewById(R.id.toolbar_auth) as Toolbar)
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        val button = findViewById(R.id.act_auth_sing_in_button)
        button.setOnClickListener { signIn() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCodeSignIn) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess) {
                val account = result.signInAccount
                fireBaseAuthWithGoogle(account)
            }
        }
    }

    private fun fireBaseAuthWithGoogle(account: GoogleSignInAccount?) {
        showProgressPar()
        val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
        val auth = FirebaseAuth.getInstance()
        auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(this, "Authentication success.",
                                Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                    }
                    hideProgressBar()
                }
    }

    private fun googleApiClient(): GoogleApiClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        return GoogleApiClient.Builder(this)
                .enableAutoManage(this, {
                    Toast.makeText(this, getString(R.string.google_play_services_error), Toast.LENGTH_LONG).show()
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()
    }

    private fun signIn() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient())
        startActivityForResult(signInIntent, requestCodeSignIn)
    }
}
