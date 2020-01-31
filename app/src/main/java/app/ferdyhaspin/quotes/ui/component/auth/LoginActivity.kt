package app.ferdyhaspin.quotes.ui.component.auth

import android.content.Intent
import androidx.databinding.DataBindingUtil
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.databinding.ActivityLoginBinding
import app.ferdyhaspin.quotes.ui.ViewModelFactory
import app.ferdyhaspin.quotes.ui.base.BaseActivity
import app.ferdyhaspin.quotes.ui.component.home.HomeActivity
import app.ferdyhaspin.quotes.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), AuthListener {

    @Inject
    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initializeViewModel() {
        authViewModel = viewModelFactory.create(AuthViewModel::class.java)
        authViewModel.authListener = this

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewmodel = authViewModel
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        user.also {
            toast(it.toString())
        }
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }

    private fun navigateToHome(user: User?) {
        if (user != null) {
            Intent(this, HomeActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }
    }

    override fun observeViewModel() {
        observe(authViewModel.getLoggedInUser(), ::navigateToHome)
    }
}
