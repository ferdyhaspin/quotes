package app.ferdyhaspin.quotes.ui.home.profile

import androidx.lifecycle.ViewModel
import app.ferdyhaspin.quotes.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}