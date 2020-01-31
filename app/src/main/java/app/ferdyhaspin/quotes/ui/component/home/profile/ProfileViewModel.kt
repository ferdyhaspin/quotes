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

import app.ferdyhaspin.quotes.data.repositories.UserRepository
import app.ferdyhaspin.quotes.ui.base.BaseViewModel
import javax.inject.Inject

class ProfileViewModel @Inject
constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    val user = userRepository.getUser()

}