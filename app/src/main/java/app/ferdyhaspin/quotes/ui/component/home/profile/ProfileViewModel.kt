/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 5:11 PM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 5:11 PM
 */

package app.ferdyhaspin.quotes.ui.component.home.profile

import android.content.Intent
import android.view.View
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.repositories.UserRepository
import app.ferdyhaspin.quotes.ui.base.BaseViewModel
import app.ferdyhaspin.quotes.ui.component.auth.LoginActivity
import app.ferdyhaspin.quotes.utils.Coroutines
import javax.inject.Inject

class ProfileViewModel @Inject
constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    val user = userRepository.getUser()

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_logout -> doLogout(view)
        }
    }

    private fun doLogout(view: View) {
        Coroutines.io {
            userRepository.deleteUser(user.value!!)
            val context = view.context
            Intent(context, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(it)
            }
        }
    }

}