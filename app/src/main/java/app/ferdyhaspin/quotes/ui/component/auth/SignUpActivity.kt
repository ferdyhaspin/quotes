package app.ferdyhaspin.quotes.ui.component.auth

import android.content.Intent
import androidx.databinding.DataBindingUtil
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.databinding.ActivitySignUpBinding
import app.ferdyhaspin.quotes.ui.ViewModelFactory
import app.ferdyhaspin.quotes.ui.base.BaseActivity
import app.ferdyhaspin.quotes.ui.component.home.HomeActivity
import app.ferdyhaspin.quotes.utils.hide
import app.ferdyhaspin.quotes.utils.observe
import app.ferdyhaspin.quotes.utils.show
import app.ferdyhaspin.quotes.utils.snackbar
import kotlinx.android.synthetic.main.activity_sign_up.*
import javax.inject.Inject

class SignUpActivity : BaseActivity(), AuthListener {

    @Inject
    lateinit var authViewModel: AuthViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initializeViewModel() {
        authViewModel = viewModelFactory.create(AuthViewModel::class.java)
        authViewModel.authListener = this

        val binding: ActivitySignUpBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        binding.viewModel = authViewModel
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
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
