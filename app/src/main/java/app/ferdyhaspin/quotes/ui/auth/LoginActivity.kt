package app.ferdyhaspin.quotes.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.data.network.NetworkConnectionInterceptor
import app.ferdyhaspin.quotes.data.network.Service
import app.ferdyhaspin.quotes.data.repository.UserRepository
import app.ferdyhaspin.quotes.databinding.ActivityLoginBinding
import app.ferdyhaspin.quotes.ui.home.HomeActivity
import app.ferdyhaspin.quotes.utils.hide
import app.ferdyhaspin.quotes.utils.show
import app.ferdyhaspin.quotes.utils.snackbar
import app.ferdyhaspin.quotes.utils.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interceptor = NetworkConnectionInterceptor(this)
        val db = AppDatabase(this)
        val service = Service(interceptor)
        val repository = UserRepository(service, db)
        val factory = AuthViewModelFactory(repository)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (user != null) {
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
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
}
