package app.ferdyhaspin.quotes.ui.component.home.profile

import androidx.lifecycle.ViewModel
import app.ferdyhaspin.quotes.data.repositories.UserRepository

class ProfileViewModelOld(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}