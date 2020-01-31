/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 11:00 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 11:00 AM
 */

package app.ferdyhaspin.quotes.ui.component.auth

import android.content.Intent
import android.view.View
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.repositories.UserRepository
import app.ferdyhaspin.quotes.ui.base.BaseViewModel
import app.ferdyhaspin.quotes.utils.ApiException
import app.ferdyhaspin.quotes.utils.Coroutines
import app.ferdyhaspin.quotes.utils.NoInternetException
import javax.inject.Inject

class AuthViewModel @Inject
constructor(private val userRepository: UserRepository) :
    BaseViewModel() {

    var name: String? = null
    var email: String? = null
    var password: String? = null
    var passwordConfirm: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = userRepository.getUser()

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_login -> doLogin()
            R.id.btn_sign_up -> doSignUp()
        }
    }

    private fun doLogin() {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResult = userRepository.userLogin(email!!, password!!)
                authResult.user?.let {
                    authListener?.onSuccess(user = it)
                    userRepository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResult.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

    private fun doSignUp() {
        authListener?.onStarted()

        if (name.isNullOrEmpty()) {
            authListener?.onFailure("Name is required")
            return
        }

        if (email.isNullOrEmpty()) {
            authListener?.onFailure("Email is required")
            return
        }

        if (password.isNullOrEmpty()) {
            authListener?.onFailure("Please enter a password")
            return
        }

        if (password != passwordConfirm) {
            authListener?.onFailure("Password did not match")
            return
        }

        Coroutines.main {
            try {
                val authResponse = userRepository.userSignUp(name!!, email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    userRepository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

    fun onSignUp(view: View) {
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onLogin(view: View) {
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

}