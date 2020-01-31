package app.ferdyhaspin.quotes.ui.component.auth

import app.ferdyhaspin.quotes.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}